package com.playmatecat.ctrl;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playmatecat.domain.vo.loginModule.LoginVO;
import com.playmatecat.utils.encrypt.UtilsAES;

@Controller
@RequestMapping("")
public class LoginController {
	
	private final static Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping("/login")
	public String loginView( @ModelAttribute LoginVO loginVO, Model model) {
		logger.info("login...");
		
		/*
		 * @step 根据原请求地址,计算出子项目登入地址.
		 * eg:www.playmate.com/user?id=123
		 * ->www.playmate.com
		 * ->www.playmate.com/cas-login
		 */
		//原请求地址
		String lastUrl = loginVO.getUrl();
		if(StringUtils.isNoneBlank(lastUrl)) {
			//排除第一个单斜杠
			String regex = "^.+//((?!(/)).)+";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(lastUrl);
			String baseUrl = StringUtils.EMPTY;
			while(m.find()) {
				//获得子项目干净的根网址
				baseUrl = m.group(0);
				break;
			}
			
			//拼出子项目登入服务地址
			String service =  baseUrl + "/cas-login";
			loginVO.setService(service);
		}
		
		return "/loginModule/login";
	}
	
	@RequestMapping("/login-params")
	public String loginParams(@Valid @ModelAttribute LoginVO loginVO, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String username = "abc";
		String password = "123";
		logger.info("login-params...");
		
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new UsernamePasswordToken(username,password);
		//@see CASRealm#doGetAuthenticationInfo(AuthenticationToken)
		try {
			subject.login(token);
		} catch (Exception e) {
			logger.error(MessageFormat.format("登陆失败.username={0},password={1}", username, password));
		}
		
		
		//生成ticket
		String ticketSrc = username + "," + password;
		String ticket = UtilsAES.encrypt(ticketSrc);
		
		//准备重定向
		String service = loginVO.getService();
		//匹配出项目所对应的	
		
		return "redirect:" + loginVO.getService() + "/?ticket=" + ticket;
	}
}

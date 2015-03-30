package com.playmatecat.ctrl;

import java.text.MessageFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playmatecat.domain.entity.User;
import com.playmatecat.domain.vo.loginModule.LoginVO;

@Controller
@RequestMapping("")
public class LoginController {
	
	private final static Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping("/login")
	public String loginView( @ModelAttribute LoginVO loginVO, Model model) {
		logger.info("login...");
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
		
		
		//生成token
		
		//重定向
		
		
		
		return "/loginModule/login";
	}
}

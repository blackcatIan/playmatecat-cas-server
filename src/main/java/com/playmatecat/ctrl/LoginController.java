package com.playmatecat.ctrl;

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

import com.playmatecat.domain.User;

@Controller
@RequestMapping("")
public class LoginController {
	
	private final static Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping("/login")
	public String loginView( @ModelAttribute User user, Model model) {
		logger.info("login...");
		return "/login";
	}
	
	@RequestMapping("/login-params")
	public String loginParams(@Valid @ModelAttribute User user, Model model) {
		String username = "abc";
		String password = "123";
		logger.info("login-params...");
		
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new UsernamePasswordToken(username,password);
		//@see CASRealm#doGetAuthenticationInfo(AuthenticationToken)
		subject.login(token);
		
		
		
		return "/loginView";
	}
}

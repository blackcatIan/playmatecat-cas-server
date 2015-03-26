package com.playmatecat.ctrl;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LoginController {
	
	private final static Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping("/login")
	public String loginView() {
		logger.info("login...");
		return "/login";
	}
	
	@RequestMapping("/login-params")
	public String loginParams() {
		String username = "abc";
		String password = "123";
		
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new UsernamePasswordToken(username,password);
		//@see CASRealm#doGetAuthenticationInfo(AuthenticationToken)
		subject.login(token);
		
		
		logger.info("login-params...");
		return "/loginView";
	}
}

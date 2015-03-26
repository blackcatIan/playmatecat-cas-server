package com.playmatecat.cas;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 实现jdbc realm
 * @author root
 *
 */
public class CASRealm extends AuthorizingRealm {
	
	/**
	 * 获得授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = (String) principals.fromRealm(getName()).iterator().next();
		
		if (username != null) {
			// 查询用户授权信息
//			Collection<String> pers = businessManager.queryPermissions(username);
//			if (pers != null && !pers.isEmpty()) {
//				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//				for (String each : pers)
//					info.addStringPermissions(each);
//
//				return info;
//			}
		}
		return null;
	}
	
	/**
	 * 获取认证信息,也就是验证用户名密码
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		// 通过表单接收的用户名
		String username = upToken.getUsername();

		if (username != null && StringUtils.isNotBlank(username)) {
			//从数据库查询
//			LoginAccount account = businessManager.get(username);
//
//			if (account != null) {
//				return new SimpleAuthenticationInfo(account.getLoginName(),
//						account.getPassword(), getName());
//			}
		}

		return null;
	}



}

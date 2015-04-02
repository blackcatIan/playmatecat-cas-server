package com.playmatecat.domain.vo.loginModule;

import com.playmatecat.domain.dto.UserDTO;

public class CasLoginVO {
	private UserDTO userDTO;

	/** 跳转的子项目登录地址 **/
	private String service;

	/** 请求跳转过来的地址 **/
	private String url;

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

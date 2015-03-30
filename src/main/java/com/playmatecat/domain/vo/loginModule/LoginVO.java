package com.playmatecat.domain.vo.loginModule;

import com.playmatecat.domain.dto.UserDTO;


public class LoginVO {
	private UserDTO userDTO;
	
	/**跳转的地址**/
	private String service;

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
	
	
}

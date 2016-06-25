package com.chenv.service;

import javax.servlet.http.HttpServletRequest;

import com.chenv.pojo.Role;

public interface RoleService {

	Role login(HttpServletRequest request);
		
	boolean changePwd(String pwd, String newPwd);
	
}

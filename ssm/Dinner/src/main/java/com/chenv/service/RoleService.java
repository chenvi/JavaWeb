package com.chenv.service;

import javax.servlet.http.HttpServletRequest;

import com.chenv.pojo.Role;

public interface RoleService {

	Role login(HttpServletRequest request);
		
	boolean changePwd(int pwd, int newPwd);
	
	boolean checkPwd(int pwd);
	
	boolean addRole(String name, int password);
}

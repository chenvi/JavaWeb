package com.chenv.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.chenv.dao.RoleMapper;
import com.chenv.pojo.Role;
import com.chenv.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {


	@Resource
	private RoleMapper roleMapper;

	@Override
	public boolean changePwd(String pwd, String newPwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Role login(HttpServletRequest request) {
		 HttpSession session = request.getSession();
		 String userName = request.getParameter("userName");
		 int password = Integer.parseInt(request.getParameter("password"));
		 Role loginAccount = new Role();
		 loginAccount.setUserName(userName);
		 loginAccount.setPassword(password);
		    
		 loginAccount = this.roleMapper.findAccount(loginAccount);
		 
		 
		 
		 if (loginAccount!=null) {
		    	 return loginAccount;
			} else {
				return null;
			}
	}

}

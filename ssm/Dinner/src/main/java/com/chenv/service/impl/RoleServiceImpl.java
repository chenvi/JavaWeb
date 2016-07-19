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

	//保存登录信息
	private Role aAccount = new Role();
	
	@Override
	public boolean changePwd(int pwd, int newPwd) {
		if (checkPwd(pwd)) {			
			aAccount.setPassword(newPwd);
			this.roleMapper.updateByPrimaryKeySelective(aAccount);
			return true;
		} else {
			return false;
		}
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
			 aAccount = loginAccount;
		    	 return loginAccount;
			} else {
				return null;
			}
	}

	@Override
	public boolean checkPwd(int pwd) {
		if (aAccount.getPassword().equals(pwd)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean addRole(String name, int password) {
		Role role = new Role();
		role.setUserName(name);
		role.setPassword(password);
		if(this.roleMapper.insert(role)>0){
			return true;
		}
		return false;
	}

}

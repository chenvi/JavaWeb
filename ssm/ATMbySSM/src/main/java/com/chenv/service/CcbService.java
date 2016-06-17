package com.chenv.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.chenv.dao.AccountsMapper;
import com.chenv.pojo.Accounts;

public interface CcbService {
	
	Accounts login(HttpServletRequest request);
	
	boolean changePwd(String pwd, String newPwd);
	
	public Accounts queryBalance();
	
	boolean fetch(double money);
	
	boolean deposit(double money);
	
	boolean checkPwd(String pwd);
	
	boolean exit();
}

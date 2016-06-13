package com.chenv.service;

import com.chenv.pojo.Accounts;

public interface CcbService {
	
	boolean login(String cardnum, String pwd);
	
	boolean changePwd(String pwd, String newPwd);
	
	public Accounts queryBalance();
	
	boolean fetch(double money);
	
	boolean deposit(double money);
	
	boolean checkPwd(String pwd);
	
	boolean exit();
}

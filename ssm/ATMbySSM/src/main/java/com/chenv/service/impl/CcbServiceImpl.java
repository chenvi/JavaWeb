package com.chenv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenv.dao.AccountsMapper;
import com.chenv.pojo.Accounts;
import com.chenv.service.CcbService;

@Service("ccbService")
public class CcbServiceImpl implements CcbService {

	@Autowired
	private AccountsMapper account;
	//保存登录信息
	private Accounts aAccount = new Accounts();
		
	@Override
	public Accounts setAccounts(Accounts accounts) {
		this.aAccount = accounts;
		return null;
	}

	/*@Override
	public Accounts login(String cardnum, String pwd) {
		aAccount.setCardnum(cardnum);
		aAccount.setPassword(pwd);
		if (this.account.findAccounts(aAccount)!= null) {
			//登录信息最初都是null 需要从mysql获取id来完善登录信息
			aAccount = this.account.findAccounts(aAccount);
			return this.account.findAccounts(aAccount);
		}else {
			aAccount=null;//如果不是正确用户就不保存信息
			return null;
		}
		
	}*/

	@Override
	public boolean changePwd(String pwd, String newPwd) {
		if (checkPwd(pwd)) {
			aAccount.setPassword(newPwd);
			this.account.updateByPrimaryKeySelective(aAccount);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Accounts queryBalance() {
		return this.account.findAccounts(aAccount);
	}

	@Override
	public boolean fetch(double money) {
		try {
			double newMoney = aAccount.getAccount()-money;
			
			if(newMoney>=0){
				aAccount.setAccount(newMoney);
				this.account.updateByPrimaryKeySelective(aAccount);
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deposit(double money) {
		try {
			aAccount.setAccount(aAccount.getAccount()+money);
			this.account.updateByPrimaryKeySelective(aAccount);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean checkPwd(String pwd) {
		if (aAccount.getPassword().equals(pwd)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean exit() {
		aAccount = null;
		return true;
	}

	
}

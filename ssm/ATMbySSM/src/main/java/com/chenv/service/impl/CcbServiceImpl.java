package com.chenv.service.impl;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public Accounts login(HttpServletRequest request) {
		 HttpSession session = request.getSession();
		 String cardnum = request.getParameter("cardnum");
		 String pwd = request.getParameter("pwd");
		 Accounts loginAccount = new Accounts();
		 loginAccount.setCardnum(cardnum);
		 loginAccount.setPassword(pwd);
		    
		 loginAccount = this.account.findAccounts(loginAccount);
		    
		 if (loginAccount!=null) {
			 	 aAccount = loginAccount;
		    	 return loginAccount;
			} else {
				return null;
			}
	}


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
		return null;
	}

	/**
	 * 取款
	 * @param money
	 * @return
	 */
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

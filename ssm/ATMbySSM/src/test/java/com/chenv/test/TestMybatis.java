package com.chenv.test;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.chenv.dao.AccountsMapper;
import com.chenv.pojo.Accounts;
import com.chenv.service.CcbService;


@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMybatis {

	private static Logger logger = Logger.getLogger(TestMybatis.class);
//	private ApplicationContext ac = null;
	@Resource
	private CcbService ccbService = null;
	//注意Resource紧跟上面 不然出现空指针异常
//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}
	
	
//	@Test
//	public void testAccount(){
//		System.out.println(this.ccbService.login("43670001","12346"));
//	}
	
	@Autowired
	private AccountsMapper accountsMapper;
	
	@Test
	public void testFetch(){
//		this.ccbService.fetch(100.0);
		Accounts accounts = new Accounts();
		accounts.setId(12);
		accounts.setCardnum("总");
		accountsMapper.insert(accounts);
		
	}
	
}

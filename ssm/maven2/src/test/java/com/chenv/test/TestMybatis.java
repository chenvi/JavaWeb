package com.chenv.test;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.chenv.pojo.User;
import com.chenv.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMybatis {

	private static Logger logger = Logger.getLogger(TestMybatis.class);
//	private ApplicationContext ac = null;
	@Resource
	private UserService userService = null;
	
//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}
	
	@Test
	public void test1() {
		User user = userService.getUserById(1);
		// System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
		logger.info(JSON.toJSONString(user));
	}
	
	@Test
	public void testTransaction(){
		List<User> users = new ArrayList<User>();
		for(int i = 0; i < 5; i++){
			User user = new User();
			user.setId(i);
			user.setUserName(i+"chenv");
			user.setAge(i+20);
			user.setPassword("100"+i);
			users.add(user);
		}
		this.userService.insertUser(users);
	}
}

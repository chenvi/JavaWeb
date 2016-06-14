package com.chenv.test;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.chenv.dao.UserMapper;
import com.chenv.pojo.Student;
import com.chenv.pojo.User;
import com.chenv.service.StudentService;
import com.chenv.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMybatis {

	private static Logger logger = Logger.getLogger(TestMybatis.class);
//	private ApplicationContext ac = null;
	@Autowired
	private UserMapper userMapper;
	
	@Resource
	private UserService userService = null;
	@Resource
	private StudentService studentService = null;
	//注意Resource紧跟上面 不然出现空指针异常
//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}
	
	@Test
	public void login() {
	// User user = new User(null, "wx", "123456", new Date());
	// User user = new User(null, "wangxin", "123456", new Date());
	// User loginExit = userMapper.login(user);
	 User loginExit = userMapper.login("chenv", "cc");
//	User loginExit = userMapper.login("wangxin", "123456");
	if (loginExit == null) {
	System.out.println("用户不存在");
	} else {
	System.out.println(loginExit);
	System.out.println("登录成功！");
	}
	}
	
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
		for(int i = 0; i < 1; i++){
			User user = new User();
			user.setId(i);
			user.setUserName(i+"chenv");
			user.setAge(i+20);
			user.setPassword("100"+i);
			users.add(user);
		}
		this.userService.insertUser(users);
	}
	
	@Test
	public void testStudent(){
		this.studentService.deleteAll();
		List<Student> students = new ArrayList<Student>();
		for(int i = 1; i < 5; i++){
		Student student = new Student();
		student.setId(i);
		student.setName("chenv"+i);
		students.add(student);
		}
		this.studentService.insertStudent(students);
		
		System.out.println(this.studentService.getStudentByName("chenv1"));
			
		
	}
}

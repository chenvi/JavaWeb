package com.chenv.test;

import java.io.InputStream;
import java.sql.Connection;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.chenv.pojo.Role;

public class TestCache {

	
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testCache1(){
		String res = "classpath:spring-mybatis.xml";
		InputStream is = TestCache.class.getClassLoader().getResourceAsStream(res);
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(is); 
		SqlSession session = this.sqlSessionFactory.openSession();
		String statement = "com.chenv.mapping.RoleMapper.selectByPrimaryKey";
		Role role = session.selectOne(statement, 1);
		System.out.println(role);		
		
	}
}

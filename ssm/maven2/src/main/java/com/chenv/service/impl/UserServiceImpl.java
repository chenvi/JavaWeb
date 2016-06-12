package com.chenv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chenv.dao.UserMapper;
import com.chenv.pojo.User;
import com.chenv.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
  @Autowired
  private UserMapper userDao;
  @Override
  public User getUserById(int userId) {
    // TODO Auto-generated method stub
    return this.userDao.selectByPrimaryKey(userId);
  }

  /**
   * 事务处理
   * 插入用户，如果用户数小于2就执行，否则，抛出异常
   * @param users
   */
  @Transactional
  @Override
  public void insertUser(List<User> users){
	  for(int i = 0; i < users.size(); i++){
		  if(i < 2){
			  this.userDao.insert(users.get(i));
		  }else{
			  throw new RuntimeException();
		  }
	  }
  }
}
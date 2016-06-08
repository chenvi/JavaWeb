package com.chenv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
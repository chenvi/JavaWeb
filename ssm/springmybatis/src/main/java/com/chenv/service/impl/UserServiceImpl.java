package com.chenv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenv.dao.UserMapper;
import com.chenv.domain.User;
import com.chenv.service.UserService;


/**
 * @author gacl
 * 使用@Service注解将UserServiceImpl类标注为一个service
 * service的id是userService
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 使用@Autowired注解标注userMapper变量，
     * 当需要使用UserMapper时，Spring就会自动注入UserMapper
     */
    @Autowired
    private UserMapper userMapper;//注入dao

    
    public void addUser(User user) {
        userMapper.insert(user);
    }

    
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
    
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }
}
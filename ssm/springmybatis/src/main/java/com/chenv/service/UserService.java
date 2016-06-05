package com.chenv.service;

import java.util.List;

import com.chenv.domain.User;



public interface UserService {

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);
    
    /**
     * 根据用户id获取用户
     * @param userId
     * @return
     */
    User getUserById(Integer userId);
    
    /**获取所有用户信息
     * @return List<User>
     */
    List<User> getAllUser();
}
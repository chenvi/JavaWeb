package com.chenv.dao;

import java.util.List;

import com.chenv.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**获取所有用户信息
     * @return List<User>
     */
    List<User> getAllUser();
    
    void deleteAllUser();
}
package com.chenv.dao;

import org.apache.ibatis.annotations.Param;

import com.chenv.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User login(@Param(value = "name") String name,
    		@Param(value = "password") String password);
}
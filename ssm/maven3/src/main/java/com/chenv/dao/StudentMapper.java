package com.chenv.dao;

import com.chenv.pojo.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteAll();
    
    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    Student selectByName(String name);
    
    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
package com.chenv.dao;

import java.util.List;

import com.chenv.pojo.DinnerTable;

public interface DinnerTableMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteAll();

    int insert(DinnerTable record);

    int insertSelective(DinnerTable record);

    DinnerTable selectByPrimaryKey(Integer id);
    
    List<DinnerTable> listAll();
    
    List<DinnerTable> listAllByTypeName(DinnerTable record);

    int updateByPrimaryKeySelective(DinnerTable record);

    int updateByPrimaryKey(DinnerTable record);
    
    int updateById(DinnerTable record);
    
}
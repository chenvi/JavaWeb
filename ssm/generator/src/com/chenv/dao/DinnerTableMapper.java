package com.chenv.dao;

import com.chenv.pojo.DinnerTable;

public interface DinnerTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DinnerTable record);

    int insertSelective(DinnerTable record);

    DinnerTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DinnerTable record);

    int updateByPrimaryKey(DinnerTable record);
}
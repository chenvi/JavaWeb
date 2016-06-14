package com.chenv.dao;

import com.chenv.pojo.Accounts;

public interface AccountsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Accounts record);

    int insertSelective(Accounts record);

    Accounts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Accounts record);

    int updateByPrimaryKey(Accounts record);
    
    Accounts findAccounts(Accounts record);
}
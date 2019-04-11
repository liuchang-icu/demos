package com.example.security.dao;

import com.example.security.model.Sys_user;
import org.apache.ibatis.annotations.Mapper;


public interface Sys_userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sys_user record);

    int insertSelective(Sys_user record);

    Sys_user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sys_user record);

    int updateByPrimaryKey(Sys_user record);
}
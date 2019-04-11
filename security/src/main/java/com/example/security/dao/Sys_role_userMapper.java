package com.example.security.dao;

import com.example.security.model.Sys_role_user;

public interface Sys_role_userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sys_role_user record);

    int insertSelective(Sys_role_user record);

    Sys_role_user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sys_role_user record);

    int updateByPrimaryKey(Sys_role_user record);
}
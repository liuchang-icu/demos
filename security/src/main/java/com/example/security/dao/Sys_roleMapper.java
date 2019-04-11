package com.example.security.dao;

import com.example.security.model.Sys_role;

public interface Sys_roleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sys_role record);

    int insertSelective(Sys_role record);

    Sys_role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sys_role record);

    int updateByPrimaryKey(Sys_role record);
}
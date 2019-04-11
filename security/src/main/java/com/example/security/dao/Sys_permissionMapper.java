package com.example.security.dao;

import com.example.security.model.Sys_permission;

import java.util.List;

public interface Sys_permissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sys_permission record);

    int insertSelective(Sys_permission record);

    Sys_permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sys_permission record);

    int updateByPrimaryKey(Sys_permission record);
    //查询所有权限
    List<Sys_permission> findAll();
    //通过用户id查询用户权限
    List<Sys_permission> findByAdminUserId(int userId);

}
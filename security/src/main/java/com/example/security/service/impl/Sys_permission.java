package com.example.security.service.impl;

import com.example.security.dao.Sys_permissionMapper;
import com.example.security.dao.Sys_role_permissionMapper;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/6/14
 */
@Service
public class Sys_permission {
    @Autowired
    Sys_permissionMapper sys_permissionMapper;
    public Map findAll(){
        Map map= new HashMap();
        map.put("findAll",sys_permissionMapper.findAll());
        map.put("findById",sys_permissionMapper.findByAdminUserId(1));
        return map;
    }

}

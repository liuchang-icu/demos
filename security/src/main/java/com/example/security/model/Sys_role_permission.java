package com.example.security.model;

public class Sys_role_permission {
    private Integer id;

    private Integer sysRoleId;

    private Integer sysPermisionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Integer sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public Integer getSysPermisionId() {
        return sysPermisionId;
    }

    public void setSysPermisionId(Integer sysPermisionId) {
        this.sysPermisionId = sysPermisionId;
    }
}
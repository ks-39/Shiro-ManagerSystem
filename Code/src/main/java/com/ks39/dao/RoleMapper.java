package com.ks39.dao;

import com.ks39.entity.Role;
import com.ks39.util.MyMapper;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {

    //0. SelectByRoleName
    Role SelectByRoleName(String rolename);

    //1. getList
    List<Role> RoleGetList(Role role);

    //2. add
    int RoleAdd(Role role);

    //3. edit
    int RoleEdit(Role role);

    //4. delete
    int RoleDelete(Integer rid);
}
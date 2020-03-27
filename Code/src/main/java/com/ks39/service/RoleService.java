package com.ks39.service;

import com.ks39.entity.Role;

import java.util.List;

/**
 * @Author: Ks-39
 * @Description: RoleService接口
 * @Date: Create in 23:21 2020/3/14
 */
public interface RoleService extends Iservice<Role> {

    //0. SelectByRoleName
    Role SelectByRoleName(String rolename);

    //1. getList
    List<Role> RoleGetList(Role role);

    //2. add
    boolean RoleAdd(Role role,Integer[] pids);

    //3. edit
    boolean RoleEdit(Role role,Integer[] pids);

    //4. delete
    boolean RoleDelete(Integer rid);
}

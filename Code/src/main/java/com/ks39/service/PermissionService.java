package com.ks39.service;

import com.ks39.entity.Permission;

import java.util.List;

/**
 * @Author: Ks-39
 * @Description:
 * @Date: Create in 19:56 2020/3/16
 */
public interface PermissionService extends Iservice<Permission> {

    //1. getList
    List<Permission> PermissionGetList(Permission permission);

    //2. add
    int PermissionAdd(Permission permission);

    //3. edit
    int PermissionEdit(Permission permission);

    //4. delete
    boolean PermissionDelete(Integer pid);
}

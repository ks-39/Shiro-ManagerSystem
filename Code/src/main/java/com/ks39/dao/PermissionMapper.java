package com.ks39.dao;

import com.ks39.entity.Permission;
import com.ks39.util.MyMapper;

import java.util.List;

/**
 * @Author: Ks-39
 * @Description: PermissionMapper
 * @Date: Create in 19:55 2020/3/16
 */
public interface PermissionMapper extends MyMapper<Permission> {

    //1. getList
    List<Permission> PermissionGetList(Permission permission);

    //2. add
    int PermissionAdd(Permission permission);

    //3. edit
    int PermissionEdit(Permission permission);

    //4. delete
    int PermissionDelete(Integer pid);
}

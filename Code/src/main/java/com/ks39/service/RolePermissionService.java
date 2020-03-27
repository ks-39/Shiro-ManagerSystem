package com.ks39.service;

import com.ks39.entity.RolePermission;

/**
 * @Author: Ks-39
 * @Description:
 * @Date: Create in 22:25 2020/3/19
 */
public interface RolePermissionService extends Iservice<RolePermission> {

    //1. deleteByRoleId
    int delete(Integer rid);

    //2. addToRolePermission
    int insert(Integer rid, Integer[] pid);
}

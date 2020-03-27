package com.ks39.service.Impl;

import com.ks39.dao.rolePermissionMapper;
import com.ks39.entity.RolePermission;
import com.ks39.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Ks-39
 * @Description: RolePermissionService业务
 * @Date: Create in 22:26 2020/3/19
 */
@Service
public class RolePermissionServiceImpl extends BaseService<RolePermission> implements RolePermissionService {

    @Autowired
    private rolePermissionMapper rolePermissionMapper;

    //1. delete
    @Override
    public int delete(Integer rid) {
        return rolePermissionMapper.DeleteByRoleId(rid);
    }

    //2. add
    @Override
    public int insert(Integer rid, Integer[] pids) {
        return rolePermissionMapper.InsertRoleIdAndPermissionId(rid,pids);
    }
}

package com.ks39.service.Impl;

import com.ks39.dao.PermissionMapper;
import com.ks39.dao.rolePermissionMapper;
import com.ks39.entity.Permission;
import com.ks39.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ks-39
 * @Description: PermissionService业务
 * @Date: Create in 19:57 2020/3/16
 */
@Service
public class PermissionServiceImpl extends BaseService<Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private rolePermissionMapper rolePermissionMapper;

    //1. getList
    @Override
    public List<Permission> PermissionGetList(Permission permission) {
        return permissionMapper.PermissionGetList(permission);
    }

    //2. add
    @Override
    public int PermissionAdd(Permission permission) {
        return permissionMapper.PermissionAdd(permission);
    }

    //3. edit
    @Override
    public int PermissionEdit(Permission permission) {
        return permissionMapper.PermissionEdit(permission);
    }

    //4. delete
    @Override
    public boolean PermissionDelete(Integer pid) {
        try {
            //1. 先删除permission中的数据
            permissionMapper.PermissionDelete(pid);
            //2. 再删除role_permission中的数据
            rolePermissionMapper.DeleteByPid(pid);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

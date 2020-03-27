package com.ks39.service.Impl;

import com.ks39.dao.RoleMapper;
import com.ks39.dao.rolePermissionMapper;
import com.ks39.entity.Role;
import com.ks39.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ks-39
 * @Description: RoleService业务
 * @Date: Create in 23:22 2020/3/14
 */
@Service
public class RoleServiceImpl extends BaseService<Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private rolePermissionMapper rolePermissionMapper;

    @Override
    public Role SelectByRoleName(String rolename) {
        return roleMapper.SelectByRoleName(rolename);
    }

    //1. getList
    @Override
    public List<Role> RoleGetList(Role role) {
        return roleMapper.RoleGetList(role);
    }

    //2. add
    @Override
    public boolean RoleAdd(Role role,Integer[] pids) {
        try{
            //1. 先在tb_role中加入数据
            roleMapper.RoleAdd(role);
            //2. 在添加完后根据rolename查找刚刚添加role数据
            Role roleId = roleMapper.SelectByRoleName(role.getRolename());
            //3. 再根据查询到的rid删除对应rid在tb_role_permission中的数据（只是保险起见，add操作应该是不需要这一步的）
            rolePermissionMapper.DeleteByRoleId(roleId.getRid());
            //4. 重新在tb_role_permission加入数据
            rolePermissionMapper.InsertRoleIdAndPermissionId(roleId.getRid(),pids);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //3. edit
    @Override
    public boolean RoleEdit(Role role, Integer[] pids) {
        try{
            //1. 先在tb_role中更新数据
            roleMapper.RoleEdit(role);
            //2. 在更新完后根据rolename查找刚刚更新的role数据
            Role roleId = roleMapper.SelectByRoleName(role.getRolename());
            //3. 再根据查询到的rid删除对应rid在tb_role_permission中的数据（只是保险起见，add操作应该是不需要这一步的）
            rolePermissionMapper.DeleteByRoleId(roleId.getRid());
            //4. 重新在tb_role_permission加入数据
            rolePermissionMapper.InsertRoleIdAndPermissionId(roleId.getRid(),pids);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //4. delete
    @Override
    public boolean RoleDelete(Integer rid) {
        try{
            //1. 先根据rid删除role表中的role数据
            roleMapper.RoleDelete(rid);
            //2. 再根据rid删除role_permission表中的数据
            rolePermissionMapper.DeleteByRoleId(rid);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

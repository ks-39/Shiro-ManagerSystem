package com.ks39.dao;

import com.ks39.entity.RolePermission;
import com.ks39.util.MyMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Ks-39
 * @Description:
 * @Date: Create in 22:20 2020/3/19
 */
public interface rolePermissionMapper extends MyMapper<RolePermission> {

    //1. deleteByRoleId
    int DeleteByRoleId(@Param("rid") Integer rid);

    //2. addToRolePermission
    int InsertRoleIdAndPermissionId(@Param("rid") Integer rid, @Param("pids") Integer[] pids);

    //3. deleteByPid
    int DeleteByPid(@Param("pid") Integer pid);
}

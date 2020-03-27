package com.ks39.service;

import com.ks39.entity.User;

import java.util.List;
import java.util.Set;

/**
 * @Author: Ks-39
 * @Description: UserService接口,实现了Iservice通用接口
 * @Date: Create in 19:20 2020/3/13
 */
public interface UserService extends Iservice<User> {

    //1. getList
    List<User> UserGetList(User user);

    //2. add
    int UserAdd(User user);

    //3. edit
    int UserEdit(User user);

    //4. delete
    int UserDelete(User user);

    //5. shiro —— findByUserName
    User findByUserName(String username);

    //6. shiro —— selectRoleByUserName
    Set<String> selectRoleByUserName(String username);

    //7. shiro —— selectPermsByUserName
    Set<String> selectPermsByUsername(String username);

    //8. updateLastLoginTime
    void UserUpdateLastLoginTime(String username);
}

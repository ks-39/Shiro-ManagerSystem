package com.ks39.dao;

import com.ks39.entity.User;
import com.ks39.util.MyMapper;

import java.util.List;
import java.util.Set;

public interface UserMapper extends MyMapper<User> {

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
    Set<String> selectPermsByUserName(String username);

    //8. updateLastLoginTime
    void UserUpdateLastLoginTime(String username);
}
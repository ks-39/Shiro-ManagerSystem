package com.ks39.service.Impl;

import com.ks39.dao.UserMapper;
import com.ks39.entity.User;
import com.ks39.service.UserService;
import com.ks39.util.PasswordGenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Author: Ks-39
 * @Description: UserService业务
 * @Date: Create in 19:22 2020/3/13
 */
@Service
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    //1. getList
    @Override
    public List<User> UserGetList(User user) {
       return userMapper.UserGetList(user);
    }

    //2. add
    @Override
    public int UserAdd(User user) {
        //使用md5加密password
        String password = PasswordGenerateUtil.getPassword(user.getUsername(),user.getPassword(), 4);
        user.setPassword(password);
        return userMapper.UserAdd(user);
    }

    //3. edit
    @Override
    public int UserEdit(User user) {
        //使用md5加密password
        String password = PasswordGenerateUtil.getPassword(user.getUsername(),user.getPassword(), 4);
        user.setPassword(password);
        return userMapper.UserEdit(user);
    }

    //4. delete
    @Override
    public int UserDelete(User user) {
        return userMapper.UserDelete(user);
    }

    //5. shiro——findByUserName
    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    //6. shiro —— selectRoleByUserName
    @Override
    public Set<String> selectRoleByUserName(String username) {
        return userMapper.selectRoleByUserName(username);
    }

    //7. shiro —— selectPermsByUserName
    @Override
    public Set<String> selectPermsByUsername(String username) {
        return userMapper.selectPermsByUserName(username);
    }

    //8. updateLastLoginTime
    @Override
    public void UserUpdateLastLoginTime(String username) {
        userMapper.UserUpdateLastLoginTime(username);
    }

}

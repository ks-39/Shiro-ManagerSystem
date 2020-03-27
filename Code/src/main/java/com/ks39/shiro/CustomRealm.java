package com.ks39.shiro;

import com.ks39.entity.User;
import com.ks39.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @Author: Ks-39
 * @Description: CustomRealm（用于授权和认证）
 * @Date: Create in 16:25 2020/3/22
 */
public class CustomRealm extends AuthorizingRealm {

    //0. 注入业务对象
    @Autowired
    private UserService userService;

    //1. 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1. 获取当前登录用户
        User user = (User) principalCollection.getPrimaryPrincipal();
        //2.1 查找rolename
        Set<String> roles  = userService.selectRoleByUserName(user.getUsername());
        //2.2 查找permissionname
        Set<String> perms = userService.selectPermsByUsername(user.getUsername());
        //3. 创建授权对象
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //4.  添加授权对象
        authorizationInfo.addRoles(roles);
        authorizationInfo.addStringPermissions(perms);
        return authorizationInfo;
    }

    //2. 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1. 将authenticationToken对象转换为UsernamePasswordToken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //2. 查找数据库
        User user = userService.findByUserName(token.getUsername());
        //3. 验证
        if(user==null){
            return null;
        }
        //4. 返回认证
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getUsername()),getName());
        return simpleAuthenticationInfo;
    }
}

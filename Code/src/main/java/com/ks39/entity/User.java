package com.ks39.entity;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable{

    private static final long serialVersionUID = 281450177692340853L;
    private Integer userid;

    private String username;

    private String password;

    private String state;

    private Date createtime;

    private Date lastlogintime;

    private String roleId;

    private String rolename;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                ", createtime=" + createtime +
                ", lastlogintime=" + lastlogintime +
                ", roleId='" + roleId + '\'' +
                ", rolename='" + rolename + '\'' +
                '}';
    }

    //1. 根据username查找的构造方法
    public User(Integer userid){
        this.userid = userid;
    }

}
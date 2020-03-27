package com.ks39.entity;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Table(name = "tb_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 4642424754521517975L;
    private Integer rid;

    private String rolename;

    private String describe;

    private String permission_name;

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rolename='" + rolename + '\'' +
                ", describe='" + describe + '\'' +
                ", permission_name='" + permission_name + '\'' +
                '}';
    }

    //1. 根据username查找的构造方法
    public Role(Integer rid){
        this.rid = rid;
    }
}
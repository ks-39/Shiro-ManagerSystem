package com.ks39.entity;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: Ks-39
 * @Description:
 * @Date: Create in 23:24 2020/3/14
 */
@Table(name = "tb_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = -4802960717814133846L;
    private Integer pid;

    private String permissionname;

    private String url;

    private String describe;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "pid=" + pid +
                ", permissionname='" + permissionname + '\'' +
                ", url='" + url + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }

    //1.
    public Permission(Integer pid){
        this.pid = pid;
    }
}

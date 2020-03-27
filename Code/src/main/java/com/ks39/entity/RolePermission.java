package com.ks39.entity;

import java.io.Serializable;

/**
 * @Author: Ks-39
 * @Description:
 * @Date: Create in 22:22 2020/3/19
 */
public class RolePermission implements Serializable {
    private static final long serialVersionUID = -6241243013548175387L;
    private Integer rid;

    private Integer pid;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "rid=" + rid +
                ", pid=" + pid +
                '}';
    }
}

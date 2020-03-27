package com.ks39.util;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Ks-39
 * @Description: 返回数据工具类
 * @Date: Create in 19:52 2020/3/13
 */
public class PageResultBean<T> implements Serializable {

    private long count;
    private int code;
    private List<T> data;

    public PageResultBean(long count, List<T> data) {
        this.count = count;
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

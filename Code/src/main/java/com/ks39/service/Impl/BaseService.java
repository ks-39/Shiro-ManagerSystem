package com.ks39.service.Impl;

import com.ks39.service.Iservice;

import java.util.List;

/**
 * @Author: Ks-39
 * @Description:
 * @Date: Create in 18:35 2020/3/13
 */
public class BaseService<T> implements Iservice<T> {
    @Override
    public T selectByKey(Object key) {
        return null;
    }

    @Override
    public int save(T entity) {
        return 0;
    }

    @Override
    public int delete(Object key) {
        return 0;
    }

    @Override
    public int updateAll(T entity) {
        return 0;
    }

    @Override
    public int updateNotNull(T entity) {
        return 0;
    }

    @Override
    public List<T> selectByExample(Object example) {
        return null;
    }
}

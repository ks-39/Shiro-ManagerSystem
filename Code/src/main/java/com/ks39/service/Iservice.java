package com.ks39.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ks-39
 * @Description: 通用接口
 * @Date: Create in 19:48 2020/3/10
 */
@Service
public interface Iservice<T> {

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

    //TODO 其他...
}

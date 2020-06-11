package com.loan.framework.service.dao;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019-04-17 22:38
 */
public interface ISingleTableDao<T> {
    int insert(T var1);

    int updateByPk(T var1);

    int deleteByPrimaryKey(T var1);

    T getOneByPrimaryKey(T var1);

    List<T> getAllItemsByQueryObject(T var1);
}

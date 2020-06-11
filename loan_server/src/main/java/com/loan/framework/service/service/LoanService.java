package com.loan.framework.service.service;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019-04-17 22:39
 */
public interface LoanService<T> {
    Long getLongUniqueId();

    Long create(T entity);

    void modifyEntityById(T entity);

    void deleteEntityById(Long id);

    T getEntityById(Long id);

    List<T> queryEntityList(T queryObject);

}

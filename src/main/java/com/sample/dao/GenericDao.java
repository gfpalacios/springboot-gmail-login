package com.sample.dao;

import java.util.List;

public interface GenericDao<PK, T> {

    PK add(T entity);

    void saveOrUpdate(T entity);

    void delete(T entity);

    T getByKey(PK key);

    List<T> getAll();
}

package com.sample.dao;

import java.util.List;

public interface GenericDao<PK, T> {

    public PK add(T entity);

    public void saveOrUpdate(T entity);

    public void delete(T entity);

    public T getByKey(PK key);

    public List<T> getAll();

    public Integer getInteger(Object val);

    public String getString(Object val);

    public Boolean getBoolean(Object val);

    public void print(String name, Object object);

}

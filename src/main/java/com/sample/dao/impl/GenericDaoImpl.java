package com.sample.dao.impl;

import com.sample.dao.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<PK extends Serializable, T> implements GenericDao<PK, T> {

    private final Class<? extends T> daoType;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[1];
    }

    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(daoType);
    }

    @Override
    public PK add(T entity) {
        return (PK) getSession().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public T getByKey(PK key) {
        return getSession().get(daoType, key);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) createEntityCriteria().list();
    }

}

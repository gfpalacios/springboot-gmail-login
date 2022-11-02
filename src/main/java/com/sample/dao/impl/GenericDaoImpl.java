/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private SessionFactory sessionFactory;

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
        return (T) getSession().get(daoType, key);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) createEntityCriteria().list();
    }

    @Override
    public Integer getInteger(Object val) {
        try {
            return Integer.parseInt(val.toString());
        } catch (NullPointerException | NumberFormatException e) {
            return 0;
        }
    }

    @Override
    public String getString(Object val) {
        try {
            return val.toString();
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public Boolean getBoolean(Object val) {
        try {
            return Boolean.parseBoolean(val.toString());
        } catch (NullPointerException e) {
            return null;
        }
    }


    public Double getDouble(Object val) {
        try {
            return new Double(val.toString());
        } catch (NullPointerException e) {
            return null;
        }
    }


    @Override
    public void print(String name,Object object){
        System.out.println("HR-PRINT : "+name+" > "+object);
    }


    public void print(String name){
        System.out.println("SAMO-PRINT : "+name);
    }

}

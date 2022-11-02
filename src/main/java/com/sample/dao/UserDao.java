package com.sample.dao;

import com.sample.entity.SampleUser;

import java.util.List;

public interface UserDao extends GenericDao<Integer, SampleUser> {
    public int delete(Class className,int id);

}

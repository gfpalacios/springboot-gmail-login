package com.sample.dao;

import com.sample.entity.SampleUser;

public interface UserDao extends GenericDao<Integer, SampleUser> {
    int delete(Class className,int id);

}

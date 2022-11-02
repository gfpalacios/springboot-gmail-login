package com.sample.dao;

import com.sample.entity.SampleContact;

import java.util.List;

public interface ContactDao extends GenericDao<Integer,SampleContact> {
    public List<SampleContact> getAllContactsForUserId(int userId);
}

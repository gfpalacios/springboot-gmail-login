package com.sample.service.impl;

import com.sample.dao.UserDao;
import com.sample.dto.contact.ViewContactDto;
import com.sample.dto.message.SystemMessage;
import com.sample.dto.user.ViewUserDto;
import com.sample.entity.SampleContact;
import com.sample.entity.SampleUser;
import com.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserDao userDao;

    @Override
    public ResponseEntity getAllUsers() {
        System.out.println("UserServiceImpl.getAllUsers");
        List<SampleUser> dataList = userDao.getAll();
        if (dataList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            List<ViewUserDto> responseList = new ArrayList<>();
            ViewUserDto responseData;
            for (SampleUser user : dataList) {
                responseData = new ViewUserDto();
                responseData.setUserId(user.getUserId());
                responseData.setUsername(user.getUsername());
                responseData.setSampleContactCollection(toSampleContact(user.getSampleContactCollection()));
                responseList.add(responseData);
            }
            return new ResponseEntity(responseList, HttpStatus.OK);
        }
    }

    public List<ViewContactDto> toSampleContact (List<SampleContact> contacts){
        List<ViewContactDto> responseList = new ArrayList<>();
        for (SampleContact contact : contacts) {
            ViewContactDto responseData;
            responseData = new ViewContactDto();
            responseData.setContact(contact.getContact());
            responseData.setContactId(contact.getContactId());
            responseList.add(responseData);
        }
        return  responseList;
    }

    public ResponseEntity getUser(Integer userId){
        SampleUser user = userDao.getByKey(userId);

        ViewUserDto responseData = new ViewUserDto();
        responseData.setUserId(user.getUserId());
        responseData.setUsername(user.getUsername());
        responseData.setSampleContactCollection(toSampleContact(user.getSampleContactCollection()));
        return new ResponseEntity(responseData, HttpStatus.OK);
    }

    @Override
    public ResponseEntity addUser(SampleUser user) {
        System.out.println("UserServiceImpl.addUser");
        for (int i = 0; i < user.getSampleContactCollection().size(); i++) {
            user.getSampleContactCollection().get(i).setUserId(user);
        }
        if (userDao.add(user) > 0) {
            ViewUserDto responseData = new ViewUserDto();
            responseData.setUserId(user.getUserId());
            responseData.setUsername(user.getUsername());
            responseData.setSampleContactCollection(toSampleContact(user.getSampleContactCollection()));
            return new ResponseEntity(responseData, HttpStatus.OK);
        } else {
            return new ResponseEntity(new SystemMessage("Oops User Add Failed ;)"), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity addContacts(Integer userId, List<String> contacts) {
        SampleUser user = userDao.getByKey(userId);

        for (int i = 0; i < contacts.size(); i++) {
            SampleContact newContact = new SampleContact();
            newContact.setContact(contacts.get(i));
            newContact.setUserId(user);
            user.getSampleContactCollection().add(newContact);
        }

        try{
            userDao.saveOrUpdate(user);
            return new ResponseEntity(new SystemMessage("User Added Success..!"), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("UserServiceImpl.editUser:" + e.getMessage());
            return new ResponseEntity(new SystemMessage("Oops User Add Failed ;)"), HttpStatus.BAD_REQUEST);
        }
    }
}

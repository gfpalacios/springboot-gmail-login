package com.sample.service;

import com.sample.entity.SampleUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public ResponseEntity getAllUsers();
    public ResponseEntity getUser(Integer userId);
    public ResponseEntity addUser(SampleUser user);
    public ResponseEntity addContacts(Integer userId, List<String> contacts);
    public ResponseEntity deleteUser(int userId);
}

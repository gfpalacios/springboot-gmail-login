package com.sample.service;

import com.sample.entity.SampleUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
     ResponseEntity getAllUsers();
     ResponseEntity getUser(Integer userId);
     ResponseEntity addUser(SampleUser user);
     ResponseEntity addContacts(Integer userId, List<String> contacts);
}

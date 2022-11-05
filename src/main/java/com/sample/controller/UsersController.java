package com.sample.controller;

import com.sample.entity.SampleUser;
import com.sample.service.ContactService;
import com.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import java.util.List;


@Controller
@RequestMapping(value = {"user"})
public class UsersController {

    private static final Gson gson = new Gson();

    @Autowired
    private UserService userService;

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = {"get"}, method = RequestMethod.GET)
    public ResponseEntity getAllUsers() {
        System.out.println("ViewUsersController.getAllUsers");
        return userService.getAllUsers();
    }

    @RequestMapping(value = {"get/{userId}"}, method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable("userId")  Integer userId) {
        System.out.println("ViewUsersController.getUser");
        return userService.getUser(userId);
    }

    @RequestMapping(value = {"get/contact"}, method = RequestMethod.GET)
    public ResponseEntity getContactsForUser(@RequestParam("userId") Integer userId) {
        System.out.println("ViewUsersController.getContactsForUser");
        return contactService.getAllContactForUsrId(userId);
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody SampleUser sampleUser) {
        System.out.println("ViewUsersController.getContactsForUser");
        return userService.addUser(sampleUser);
    }
    @RequestMapping(value = {"edit/{userId}/contacts"}, method = RequestMethod.POST)
    public ResponseEntity addContacts(@PathVariable("userId") Integer userId, @RequestBody List<String> contacts) {
        System.out.println("ViewUsersController.addContacts");
        return userService.addContacts(userId, contacts);
    }

    @RequestMapping(value = {"delete/{userId}"}, method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("userId") Integer userId) {
        System.out.println("ViewUsersController.deleteUser");
        return userService.deleteUser(userId);
    }


}

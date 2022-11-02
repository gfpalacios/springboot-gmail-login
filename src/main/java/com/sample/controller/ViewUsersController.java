package com.sample.controller;

import com.sample.entity.SampleUser;
import com.sample.service.ContactService;
import com.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;


@Controller
@RequestMapping(value = {"user"})
public class ViewUsersController {

    private static final Gson gson = new Gson();

    @Autowired
    private UserService userService;

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public ModelAndView viewUsers( Model model)  {
        System.out.println("ViewUsersController.viewUsers");


        ResponseEntity usersList = userService.getAllUsers();
        System.out.println(gson.toJson(usersList.getBody()));

        model.addAttribute("users", gson.toJson(usersList.getBody()));
        return new ModelAndView("ViewUsers");
    }

    @RequestMapping(value = {"get"}, method = RequestMethod.GET)
    public ResponseEntity getAllUsers() {
        System.out.println("ViewUsersController.getAllUsers");
        return userService.getAllUsers();
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

    @RequestMapping(value = {"delete/{userId}"}, method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("userId") Integer userId) {
        System.out.println("ViewUsersController.deleteUser");
        return userService.deleteUser(userId);
    }


}

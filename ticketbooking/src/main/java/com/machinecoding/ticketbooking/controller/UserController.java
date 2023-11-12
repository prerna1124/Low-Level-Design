package com.machinecoding.ticketbooking.controller;

import com.machinecoding.ticketbooking.model.User;
import com.machinecoding.ticketbooking.service.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String addUser(String email, String name) {
        return userService.addUser(email, name);
    }

    public User getUserById(String mail) {
        return userService.getUserById(mail);
    }
}

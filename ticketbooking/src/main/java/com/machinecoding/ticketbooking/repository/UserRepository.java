package com.machinecoding.ticketbooking.repository;

import com.machinecoding.ticketbooking.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private final Map<String, User> userMap;

    public UserRepository() {
        this.userMap = new HashMap<>();
    }


    public String addUser(User user) {
        userMap.put(user.getUserEmail(), user);
        return user.getUserEmail();
    }

    public User getUserById(String mail) {
        return userMap.get(mail);
    }
}

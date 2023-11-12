package com.machinecoding.ticketbooking.service;

import com.machinecoding.ticketbooking.model.User;
import com.machinecoding.ticketbooking.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String addUser(String email, String name) {
        return userRepository.addUser(new User(email, name));
    }

    public User getUserById(String mail) {
        return userRepository.getUserById(mail);
    }
}

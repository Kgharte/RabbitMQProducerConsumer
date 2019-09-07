package com.kalpesh.gharte.login.services;

import com.kalpesh.gharte.login.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();

}

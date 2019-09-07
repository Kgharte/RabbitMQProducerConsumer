package com.kalpesh.practice.registration.service;

import com.kalpesh.practice.registration.domain.User;

import java.util.List;

public interface RegistrationService {

    public User saveUser(User user);
    public List<User> getAllUser();
    public boolean deleteUser(String userId);
    public User updateUser(User user);

    public User getByUserId(String userId);
}

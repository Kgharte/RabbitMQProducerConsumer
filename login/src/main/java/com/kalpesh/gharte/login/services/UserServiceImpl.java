package com.kalpesh.gharte.login.services;

import com.kalpesh.gharte.login.exception.UserNotFoundException;
import com.kalpesh.gharte.login.model.User;
import com.kalpesh.gharte.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin("*")

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user)  {

        User userSaved = userRepository.save(user);

        return userSaved;

    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }



}

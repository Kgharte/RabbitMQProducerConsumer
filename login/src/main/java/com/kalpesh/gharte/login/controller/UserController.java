package com.kalpesh.gharte.login.controller;

import com.kalpesh.gharte.login.exception.UserNotFoundException;
import com.kalpesh.gharte.login.model.User;
import com.kalpesh.gharte.login.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/")
public class UserController
{
    private UserService userService;
    private ResponseEntity responseEntity;

    @Autowired

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity<?> save(@RequestBody User user){
        userService.saveUser(user);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUser()
    {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }
}

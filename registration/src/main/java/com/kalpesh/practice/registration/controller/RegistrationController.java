package com.kalpesh.practice.registration.controller;

import com.kalpesh.practice.registration.domain.User;
import com.kalpesh.practice.registration.service.RabbitMqProducer;
import com.kalpesh.practice.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/")
public class RegistrationController {

    private ResponseEntity responseEntity;
    private RegistrationService registrationService;

    @Autowired
    RabbitMqProducer rabbitMqProducer;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
            this.registrationService = registrationService;
    }

    @PostMapping("user")
    public ResponseEntity<?> save(@RequestBody User user){
            registrationService.saveUser(user);
            responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
             rabbitMqProducer.produce(user);
            return responseEntity;

    }

    @DeleteMapping("user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId)
    {
            registrationService.deleteUser(userId);
            responseEntity=new ResponseEntity("Successfully deleted",HttpStatus.OK);
            return responseEntity;
    }

    @PutMapping("user/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("userId") String userId)
    {
            User updatedUser = registrationService.updateUser(user);
            responseEntity = new ResponseEntity(user, HttpStatus.OK);
            return responseEntity;
    }
    @GetMapping("user/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable("userId") String userId)
    {
            User user=registrationService.getByUserId(userId);
            responseEntity=new ResponseEntity<User>(user,HttpStatus.OK);
            return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUser()
    {
            responseEntity=new ResponseEntity(registrationService.getAllUser(),HttpStatus.OK);
            return responseEntity;
    }
}

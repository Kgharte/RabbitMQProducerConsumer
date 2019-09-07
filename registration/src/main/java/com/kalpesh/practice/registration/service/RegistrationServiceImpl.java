package com.kalpesh.practice.registration.service;

import com.kalpesh.practice.registration.domain.User;
import com.kalpesh.practice.registration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin("*")
public class RegistrationServiceImpl implements RegistrationService {

    private RegistrationRepository registrationRepository;
    private User user;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public User saveUser(User user) {
        User savedUser = registrationRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getAllUser() {
        return registrationRepository.findAll();
    }

    @Override
    public boolean deleteUser(String userId) {
        boolean status = false;
        Optional optional = registrationRepository.findById(userId);
        if (optional.isPresent()) {
            registrationRepository.deleteById(userId);
            status = true;
        }
        return status;

    }

    @Override
    public User updateUser(User user) {
        User updateUser = registrationRepository.save(user);
        return updateUser;
    }


    @Override
    public User getByUserId(String userId) {
        return registrationRepository.findByUserId(userId);
    }
}

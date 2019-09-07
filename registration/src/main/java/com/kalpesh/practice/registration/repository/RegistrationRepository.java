package com.kalpesh.practice.registration.repository;

import com.kalpesh.practice.registration.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistrationRepository extends MongoRepository<User, String> {
    public User findByUserId(String userId);
}

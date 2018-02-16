package com.example.ua.mongodbsecurity.service;

import com.example.ua.mongodbsecurity.model.User;
import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService{
     Optional<User> findById(ObjectId id);
}

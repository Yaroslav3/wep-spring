package com.example.ua.mongodbsecurity.service.impl;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;

public class UserServiceImplTest {

    @Test
    public void loadUserByUsername() {
        String s = "7uHLy3pmG/6l97sKAfni4g==";
        System.out.println(new String(Base64.getDecoder().decode(s)));
        System.out.println(new BCryptPasswordEncoder().encode("password"));
    }
}
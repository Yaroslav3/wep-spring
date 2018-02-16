package com.example.ua.mongodbsecurity.service.impl;

import org.bson.types.ObjectId;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;

public class TokenHandlerTest {

    @Test
    public void generateUserId() {

        TokenHandler tokenHandler = new TokenHandler();
        String token = tokenHandler.generateAccessToken(new ObjectId("5a84bc6501fbae16685b03c3"), LocalDateTime.now().plusDays(14));
        System.out.println(token);

        Optional<ObjectId> objectId = tokenHandler.extractUserId(token);
        System.out.println(objectId.get().toString());
    }
}
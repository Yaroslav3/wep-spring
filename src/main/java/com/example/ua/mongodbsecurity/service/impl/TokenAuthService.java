package com.example.ua.mongodbsecurity.service.impl;


import com.example.ua.mongodbsecurity.filter.UserAuthentication;
import com.example.ua.mongodbsecurity.service.UserService;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class TokenAuthService {

    private static final String AUTH_HEADER_NAME = "X-Auth-Token";

    @Autowired
    private TokenHandler tokenHandler;
    @Autowired
    private UserService userService;

    public Optional<Authentication> getAuthentication(@NonNull HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(AUTH_HEADER_NAME))
                .flatMap(tokenHandler::extractUserId)
                .flatMap(userService::findById)
                .map(UserAuthentication::new);
    }
}

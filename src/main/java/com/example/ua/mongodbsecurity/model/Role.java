package com.example.ua.mongodbsecurity.model;

import org.springframework.security.core.GrantedAuthority;

public enum  Role  implements GrantedAuthority {
    USER,
    POWER_USER;

    @Override
    public String getAuthority() {
        return null;
    }
}

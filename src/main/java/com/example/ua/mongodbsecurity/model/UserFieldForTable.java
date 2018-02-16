package com.example.ua.mongodbsecurity.model;


public enum UserFieldForTable {
    USER_NAME("username");

    UserFieldForTable(String field) {
        this.field = field;
    }

    private final String field;

    public String field() {
        return field;
    }
}

package com.andyadc.tinyspring.test.bean;

public class UserService {

    private final String name;

    public UserService(String name) {
        this.name = name;
    }

    public String hello(String words) {
        return "Hello " + words;
    }
}

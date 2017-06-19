package com.example.ocaaa.reimburseproject;

/**
 * Created by Asus on 6/18/2017.
 */

public class User {
    private String id;
    private String name;
    private String username;
    private String email;
    private String token;
    private int limit;

    public User(String id, String name, String username, String email, String token, int limit) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.token = token;
        this.limit = limit;

    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

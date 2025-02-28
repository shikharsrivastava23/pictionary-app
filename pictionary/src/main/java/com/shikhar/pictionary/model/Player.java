package com.shikhar.pictionary.model;

public class Player {
    private String username;
    private boolean admin;

    public Player(String username, boolean admin) {
        this.username = username;
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }
    public boolean isAdmin() {
        return admin;
    }
}

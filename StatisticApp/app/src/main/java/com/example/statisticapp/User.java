package com.example.statisticapp;

public class User {
    private String email;
    private String password;
    private String team;
    private String role;


    public User()
    {}

    public User(String email, String password, String team, String role) {
        this.email = email;
        this.password = password;
        this.team = team;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


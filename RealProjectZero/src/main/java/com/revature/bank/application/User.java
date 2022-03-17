package com.revature.bank.application;

public class User {
    private int id;
    public String username = null;
    private String password;
    private double balance;

    public User() {

    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance(){
        return balance;
    }
}



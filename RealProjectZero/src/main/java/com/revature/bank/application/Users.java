package com.revature.bank.application;

public class Users {

    private String usernames = null;
    private String passwords = null;
    private int accountNum;

    public String getUsernames()
    {
        return usernames;
    }
    public void setUsernames(String usernames)
    {
        this.usernames = usernames;
    }

    public String getPasswords()
    {
        return passwords;
    }
    public void setPasswords(String passwords)
    {
        this.passwords = passwords;
    }

    public void SignUp(String usernames, String passwords)
    {
        this.usernames = usernames;
        this.passwords = passwords;

    }

}

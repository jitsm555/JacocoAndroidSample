package com.jiteshmohite619.jacocoandroidsample.model;

/**
 * This class will be responsible for handling user details.
 *
 * @author jiteshmohite
 */

public class User {
    private String emailId;
    private String password;

    public User() {
        // Empty constructor
    }

    public User(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }


    public String getPassword() {
        return password;
    }

}
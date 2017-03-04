package com.alife.Entity;

/**
 * Created by admin on 04/03/2017.
 */
public class User {

    private Integer userId;
    private String name;
    private String email;
    private String signUpDate;
    private String profileImageURL;
    private Boolean isAdmin;

    public User() {
    }

    public User(Integer userId, String name, String email, String signUpDate) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.signUpDate = signUpDate;
    }

    public String getProfileImageURL() {
        return profileImageURL;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public void setProfileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(String signUpDate) {
        this.signUpDate = signUpDate;
    }

}

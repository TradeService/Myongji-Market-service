package com.example.myongjimarket.domain.Login;

public class UserDto {
    private String userID;
    private String userPassword;

    public String getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userID='" + userID + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserDto(String userID, String userPassword) {
        this.userID = userID;
        this.userPassword = userPassword;
    }
}

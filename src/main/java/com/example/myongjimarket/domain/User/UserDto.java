package com.example.myongjimarket.domain.User;

public class UserDto {
    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "UserID='" + UserID + '\'' +
                ", Name='" + Name + '\'' +
                ", NickName='" + Nickname + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }

    private String UserID;
    private String Name;
    private String Nickname;
    private String Email;
    private String password;

    public UserDto(String userID, String name, String nickname, String email, String password) {
        UserID = userID;
        Name = name;
        Nickname = nickname;
        Email = email;
        this.password = password;
    }
    public UserDto(String nickname,String name, String password, String email) {

        Nickname = nickname;
        this.password = password;
        Email = email;
        Name=name;

    }

}

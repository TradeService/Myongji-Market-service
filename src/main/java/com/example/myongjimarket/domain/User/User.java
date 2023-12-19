package com.example.myongjimarket.domain.User;

import jakarta.persistence.*;

@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncrement 설정
    private Long userId;
    @Column(name = "Name")
    private String name;
    @Column(name = "NickName")
    private String nickname;
    @Column(name = "ProfileImageURL")
    private String profileImageURL;
    @Column(name = "Email")
    private String email;
    @Column(name ="Password")
    private String password;
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", profileImageURL='" + profileImageURL + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getProfileImageURL() {
        return profileImageURL;
    }
    public void setProfileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
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
    public void setPassword(String Password) {
        this.password = Password;
    }

    public User() {
    }
    public User( String nickname,String password, String email){
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }
    public User(String nickname, String Password) {
        this.nickname = nickname;
        this.password = Password;
    }
    public User( String name, String nickname, String password, String email) {
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
    }
    public User( String name, String nickname, String profileImageURL, String email,String password) {
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.profileImageURL = profileImageURL;
    }
}

package com.example.myongjimarket.domain;

import jakarta.persistence.*;

@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncrement 설정
    private Long userId;
    @Column(name ="Password")
    private String password;
    @Column(name = "Name")
    private String name;
    @Column(name = "NickName")
    private String nickname;
    @Column(name = "Email")
    private String email;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUserPassword() {
        return password;
    }
    public void setUserPassword(String Password) {
        this.password = Password;
    }
    public String getUsername() {
        return name;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public User( String nickname, String name, String password, String email) {
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
    }
}

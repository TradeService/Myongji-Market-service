package com.example.myongjimarket.domain.User;

public class UserDto {
    private String UserID;
    private String Name;
    private String Nickname;
    private String ProfileImageURL;
    private String Email;
    private String password;
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
    public String getProfileImageURL(){return ProfileImageURL;}
    public void setProfileImageURL(String profileImageURL){ProfileImageURL =profileImageURL; }
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
                ", Nickname='" + Nickname + '\'' +
                ", ProfileImageURL='" + ProfileImageURL + '\'' +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public UserDto(String name, String nickname, String profileImageURL, String email,String password) {
        this.Name=name;
        this.Nickname = nickname;
        this.ProfileImageURL = profileImageURL;
        this.password = password;
        this.Email = email;


    }

}

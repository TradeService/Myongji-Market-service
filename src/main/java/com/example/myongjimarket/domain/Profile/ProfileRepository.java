package com.example.myongjimarket.domain.Profile;


import com.example.myongjimarket.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<User, String> {
    User findByNickname(String nickname);
}

package com.example.myongjimarket.domain.Profile;


import com.example.myongjimarket.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<User, String> {
    User findByUserId(Long userId);
    User findByNickname(String nickname);

}

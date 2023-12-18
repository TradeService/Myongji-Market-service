package com.example.myongjimarket.domain.Login;

import com.example.myongjimarket.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<User, String> {
    User findByUserId(Long userId);
    User findByNickname(String nickname);

}

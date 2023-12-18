package com.example.myongjimarket.domain.Login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<User, String> {
    User findByUserId(String userId);
}

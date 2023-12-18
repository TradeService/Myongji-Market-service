package com.example.myongjimarket.domain.Signup;

import com.example.myongjimarket.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository<User, String> {
}

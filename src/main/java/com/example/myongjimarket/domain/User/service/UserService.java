package com.example.myongjimarket.domain.User.service;

import com.example.myongjimarket.domain.User.User;
import com.example.myongjimarket.domain.User.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getobj() {
        return userRepository.findAll();
    }
}

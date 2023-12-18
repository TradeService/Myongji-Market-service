package com.example.myongjimarket.domain.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public boolean authenticate(String userId, String password) {
        User user = loginRepository.findByUserId(userId);
        if (user != null && user.getUserPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

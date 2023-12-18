package com.example.myongjimarket.domain.Login;

import com.example.myongjimarket.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public boolean authenticate(String nickname, String password) {
        User user = loginRepository.findByNickname(nickname);
        if (user != null && user.getUserPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

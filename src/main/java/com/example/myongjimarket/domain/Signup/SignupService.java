package com.example.myongjimarket.domain.Signup;

import com.example.myongjimarket.domain.User;
import com.example.myongjimarket.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    private SignupRepository signupRepository;

    public User registerNewUser(UserDto userDto) {
        User newUser = new User(
                userDto.getNickname(),
                userDto.getName(),
                userDto.getPassword(),
                userDto.getEmail());
        return signupRepository.save(newUser);
    }
}

package com.example.myongjimarket.domain.Signup;

import com.example.myongjimarket.domain.User.User;
import com.example.myongjimarket.domain.User.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    private SignupRepository signupRepository;

    public User registerNewUser(UserDto userDto) {
        User newUser = new User(
                userDto.getName(),
                userDto.getNickname(),
                userDto.getProfileImageURL(),
                userDto.getEmail(),
                userDto.getPassword());
        return signupRepository.save(newUser);
    }
}

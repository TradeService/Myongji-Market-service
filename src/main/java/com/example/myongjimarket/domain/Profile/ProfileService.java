package com.example.myongjimarket.domain.Profile;

import com.example.myongjimarket.domain.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    public User getUserProfile(String nickname){
        return profileRepository.findByNickname(nickname);
    }
    public void updateUserProfile(User user){
        profileRepository.save(user);
    }
}

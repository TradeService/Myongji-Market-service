package com.example.myongjimarket.domain.Profile;

import com.example.myongjimarket.domain.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping()
    public ModelAndView getUserProfile(
            @RequestParam("nickname") String nickname
    ){
        User user = profileService.getUserProfile(nickname);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("soyun/mypage");
        return modelAndView;
    }
}

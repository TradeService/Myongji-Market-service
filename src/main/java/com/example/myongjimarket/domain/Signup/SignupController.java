package com.example.myongjimarket.domain.Signup;

import com.example.myongjimarket.domain.User;
import com.example.myongjimarket.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("signup")
public class SignupController {
    @Autowired
    private SignupService signupService;
    @GetMapping()
    public ModelAndView getSignupPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("soyun/signuppage");
        return modelAndView;
    }
    @PostMapping("")
    public ModelAndView registerUser(
            @RequestParam("nickname") String nickname,
            @RequestParam("name") String name,
            @RequestParam("password") String password,
            @RequestParam("email") String email
    ) {
        UserDto userDto = new UserDto(nickname, name, password, email);
        User registeredUser = signupService.registerNewUser(userDto);
        ModelAndView modelAndView = new ModelAndView();
        if (registeredUser != null) {
            modelAndView.setViewName("soyun/mypage");
            return modelAndView;
        } else {
            modelAndView.setViewName("soyun/signuppage");
            modelAndView.addObject("error", "failed to create user");
            return modelAndView;
        }
    }
}

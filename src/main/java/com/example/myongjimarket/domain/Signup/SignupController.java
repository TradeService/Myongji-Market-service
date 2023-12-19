package com.example.myongjimarket.domain.Signup;

import com.example.myongjimarket.domain.User.User;
import com.example.myongjimarket.domain.User.UserDto;
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
            @RequestParam("name") String name,
            @RequestParam("nickname") String nickname,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        UserDto userDto = new UserDto(name, nickname, "" ,email, password);
        User registeredUser = signupService.registerNewUser(userDto);
        ModelAndView modelAndView = new ModelAndView();
        if (registeredUser != null) {
            modelAndView.setViewName("soyun/loginpage"); // modified
            return modelAndView;
        } else {
            modelAndView.setViewName("soyun/signuppage");
            modelAndView.addObject("error", "failed to create user");
            return modelAndView;
        }
    }
}

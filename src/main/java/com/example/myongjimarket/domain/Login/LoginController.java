package com.example.myongjimarket.domain.Login;

import com.example.myongjimarket.domain.Profile.ProfileService;
import com.example.myongjimarket.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private ProfileService profileService;
    //http://localhost:8080/post
    // GET /login
    @GetMapping("")
    public ModelAndView getLoginPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("soyun/loginpage");
        return modelAndView;
    }
    @PostMapping("")
    public ModelAndView getLogin(
            @RequestParam("nickname") String nickname,
            @RequestParam("password") String password
    ){
        boolean isAuthenticated = loginService.authenticate(nickname, password);
        ModelAndView modelAndView = new ModelAndView();
        if(isAuthenticated){
            User user = profileService.getUserProfile(nickname);
            modelAndView.addObject("user", user);
            modelAndView.setViewName("soyun/mypage");
            return modelAndView;
        }else{
            modelAndView.setViewName("soyun/loginpage");
            modelAndView.addObject("error", "Invalid username or password.");
            return modelAndView;
        }

    }


}

package com.example.myongjimarket.domain.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    //http://localhost:8080/post
    // GET /login
    @GetMapping()
    public ModelAndView sampleThyme(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("soyun/loginpage");
        return modelAndView;
    }
    @PostMapping("")
    public ModelAndView getLogin(@RequestParam String userId, @RequestParam String userPassword){
        boolean isAuthenticated = loginService.authenticate(userId, userPassword);
        ModelAndView modelAndView = new ModelAndView();
        if(isAuthenticated){
            modelAndView.setViewName("soyun/mypage");
            return modelAndView;
        }else{
            modelAndView.setViewName("soyun/loginpage");
            modelAndView.addObject("error", "Invalid username or password.");
            return modelAndView;
        }

    }


}

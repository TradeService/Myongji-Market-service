package com.example.myongjimarket.domain.User.controller;

import com.example.myongjimarket.domain.User.User;
import com.example.myongjimarket.domain.User.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String test(){
        List<User> posts = userService.getobj();
        System.out.println(posts.get(0).getName());
        return "posts/index";
    }
}

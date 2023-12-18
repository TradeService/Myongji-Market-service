package com.example.myongjimarket.domain.Home.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    public HomeController(){

    }
    @GetMapping("")
    public String main(Model model){
        return "home/home";
    }
}

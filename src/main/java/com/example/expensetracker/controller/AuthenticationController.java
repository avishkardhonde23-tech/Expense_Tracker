package com.example.expensetracker.controller;

import com.example.expensetracker.entity.User;
import com.example.expensetracker.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }
    @PostMapping("/register")
     public String register (User user){
        userService.register(user);
        return "redirect:/";

    }
}

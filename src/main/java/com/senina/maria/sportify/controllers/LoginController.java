package com.senina.maria.sportify.controllers;

import com.senina.maria.sportify.controllers.dtos.LoginRequestDto;
import com.senina.maria.sportify.models.User;
import com.senina.maria.sportify.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

    @PostMapping
    public String doLogin(LoginRequestDto requestDto, Model model) {
        Optional<User> user = userService.findByEmailAndPassword(requestDto.getEmail(), requestDto.getPassword());
        String page;

        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            page = "userHome";
        } else {
            page = "login";
        }

        return page;
    }
}


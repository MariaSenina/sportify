package com.senina.maria.sportify.controllers;

import com.senina.maria.sportify.controllers.dtos.LoginRequestDto;
import com.senina.maria.sportify.models.User;
import com.senina.maria.sportify.services.ScheduleService;
import com.senina.maria.sportify.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static final int LEAGUE_ID = 663;

    private UserService userService;
    private ScheduleService scheduleService;

    @Autowired
    public LoginController(UserService userService,
                           ScheduleService scheduleService) {
        this.userService = userService;
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

    @PostMapping
    public String doLogin(LoginRequestDto requestDto, Model model, HttpSession session) throws IOException {
        Optional<User> user = userService.findByEmailAndPassword(requestDto.getEmail(), requestDto.getPassword());
        String page;

        if (user.isPresent()) {
            session.setAttribute("user", user.get());

            Map<String, Object> scheduleMap = scheduleService.findByLeagueId(LEAGUE_ID);
            model.addAttribute("today", LocalDate.now());
            model.addAttribute("matches", scheduleMap.get("match"));
            model.addAttribute("league", scheduleMap.get("league"));
            model.addAttribute("user", user.get());

            page = "userHome";
        } else {
            page = "login";
        }

        return page;
    }
}


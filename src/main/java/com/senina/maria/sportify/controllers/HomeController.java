package com.senina.maria.sportify.controllers;

import com.senina.maria.sportify.services.ScheduleService;
import com.senina.maria.sportify.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private SeasonService seasonService;
    private ScheduleService scheduleService;

    @Autowired
    public HomeController(SeasonService seasonService, ScheduleService scheduleService) {
        this.seasonService = seasonService;
        this.scheduleService = scheduleService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }
}

package com.senina.maria.sportify.controllers;

import com.senina.maria.sportify.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

@Controller
public class HomeController {
    private static final int LEAGUE_ID = 663;

    private ScheduleService scheduleService;

    @Autowired
    public HomeController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) throws IOException {
        Map<String, Object> scheduleMap = scheduleService.findByLeagueId(LEAGUE_ID);
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("matches", scheduleMap.get("match"));
        model.addAttribute("league", scheduleMap.get("league"));

        return "index";
    }
}

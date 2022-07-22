package com.senina.maria.sportify.controllers;

import com.senina.maria.sportify.models.User;
import com.senina.maria.sportify.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

@Controller
public class LeagueController {
    private ScheduleService scheduleService;

    @Autowired
    public LeagueController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/leagues/{leagueId}")
    public String getSchedule(@PathVariable Integer leagueId, Model model, HttpSession session) throws IOException {
        User user = (User) session.getAttribute("user");

        Map<String, Object> scheduleMap = scheduleService.findByLeagueId(leagueId);
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("matches", scheduleMap.get("match"));
        model.addAttribute("league", scheduleMap.get("league"));
        model.addAttribute("user", user);

        return "userHome";
    }
}

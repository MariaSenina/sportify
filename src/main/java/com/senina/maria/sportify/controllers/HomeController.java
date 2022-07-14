package com.senina.maria.sportify.controllers;

import com.senina.maria.sportify.models.schedule.MatchResponse;
import com.senina.maria.sportify.services.ScheduleService;
import com.senina.maria.sportify.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

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
    public String getHomePage(Model model) throws IOException {
        int seasonId = seasonService.findByLeagueId(290).get(1).getSeasonId();
        MatchResponse matchResponse = scheduleService.findBySeasonAndDate(seasonId, "2022-07-12", "2022-09-23");
        model.addAttribute("matches", matchResponse.getMatches());
        return "index";
    }
}

package com.senina.maria.sportify.controllers;

import com.senina.maria.sportify.models.league.LeagueResponse;
import com.senina.maria.sportify.models.schedule.MatchResponse;
import com.senina.maria.sportify.services.LeagueService;
import com.senina.maria.sportify.services.ScheduleService;
import com.senina.maria.sportify.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomeController {
    private static final int LEAGUE_ID = 290;

    private SeasonService seasonService;
    private ScheduleService scheduleService;
    private LeagueService leagueService;

    @Autowired
    public HomeController(SeasonService seasonService, ScheduleService scheduleService, LeagueService leagueService) {
        this.seasonService = seasonService;
        this.scheduleService = scheduleService;
        this.leagueService = leagueService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) throws IOException {
        int seasonId = seasonService.findByLeagueId(LEAGUE_ID).get(1).getSeasonId();
        MatchResponse matchResponse = scheduleService.findBySeasonAndDate(seasonId, "2022-07-12", "2022-09-23");
        LeagueResponse leagueResponse = leagueService.findById(LEAGUE_ID);
        model.addAttribute("matches", matchResponse.getMatches());
        model.addAttribute("league", leagueResponse.getLeagueData());
        return "index";
    }
}

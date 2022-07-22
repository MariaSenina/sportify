package com.senina.maria.sportify.services;

import com.senina.maria.sportify.models.league.LeagueResponse;
import com.senina.maria.sportify.models.schedule.Match;
import com.senina.maria.sportify.models.schedule.MatchResponse;
import com.senina.maria.sportify.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SportDataApiScheduleService implements ScheduleService {
    private ScheduleRepository scheduleRepository;
    private SeasonService seasonService;
    private LeagueService leagueService;

    @Autowired
    public SportDataApiScheduleService(ScheduleRepository scheduleRepository,
                                       SeasonService seasonService,
                                       LeagueService leagueService) {
        this.scheduleRepository = scheduleRepository;
        this.seasonService = seasonService;
        this.leagueService = leagueService;
    }

    @Override
    public MatchResponse findBySeasonAndDate(int seasonId, String fromDate, String toDate) {
        List<Match> matches = new ArrayList();

        try {
            matches = scheduleRepository.findBySeasonAndDate(seasonId, fromDate, toDate);
        } catch (Exception exception) {
            System.out.println("An exception has occurred: " + exception);
        }

        return mapToMatchResponse(matches);
    }

    private MatchResponse mapToMatchResponse(List<Match> matches) {
        MatchResponse matchResponse = new MatchResponse();
        matchResponse.setMatches(matches);

        return matchResponse;
    }

    public Map<String, Object> findByLeagueId(Integer leagueId) throws IOException {
        int seasonId = seasonService.findByLeagueId(leagueId).getSeasonId();
        LocalDate today = LocalDate.now();
        MatchResponse matchResponse = findBySeasonAndDate(seasonId, today.toString(), today.plusMonths(1).toString());
        LeagueResponse leagueResponse = leagueService.findById(leagueId);

        return new HashMap() {
            {
                put("match", matchResponse.getMatches());
                put("league", leagueResponse.getLeagueData());
            }
        };
    }
}

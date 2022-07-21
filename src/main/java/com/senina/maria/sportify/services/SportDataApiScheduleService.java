package com.senina.maria.sportify.services;

import com.senina.maria.sportify.models.league.LeagueResponse;
import com.senina.maria.sportify.models.schedule.Match;
import com.senina.maria.sportify.models.schedule.MatchResponse;
import com.senina.maria.sportify.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    public MatchResponse findBySeasonAndDate(int seasonId, String fromDate, String toDate) throws IOException {
        return mapToMatchResponse(scheduleRepository.findBySeasonAndDate(seasonId, fromDate, toDate));
    }

    private MatchResponse mapToMatchResponse(List<Match> matches) {
        MatchResponse matchResponse = new MatchResponse();
        matchResponse.setMatches(matches);

        return matchResponse;
    }

    public Map<String, Object> findByLeagueId(Integer leagueId) throws IOException {
        int seasonId = seasonService.findByLeagueId(leagueId).get(1).getSeasonId();
        MatchResponse matchResponse = findBySeasonAndDate(seasonId, "2022-07-12", "2022-09-23");
        LeagueResponse leagueResponse = leagueService.findById(leagueId);

        return new HashMap() {
            {
                put("match", matchResponse.getMatches());
                put("league", leagueResponse.getLeagueData());
            }
        };
    }
}

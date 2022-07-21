package com.senina.maria.sportify.services;

import com.senina.maria.sportify.models.schedule.MatchResponse;

import java.io.IOException;
import java.util.Map;

public interface ScheduleService {
    MatchResponse findBySeasonAndDate(int seasonId, String fromDate, String toDate) throws IOException;
    Map<String, Object> findByLeagueId(Integer leagueId) throws IOException;
}

package com.senina.maria.sportify.repositories;

import com.senina.maria.sportify.models.schedule.Match;

import java.io.IOException;
import java.util.List;

public interface ScheduleRepository {
    List<Match> findBySeasonAndDate(int seasonId, String fromDate, String toDate) throws IOException;
}

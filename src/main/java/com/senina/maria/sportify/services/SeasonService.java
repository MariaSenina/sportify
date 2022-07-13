package com.senina.maria.sportify.services;

import com.senina.maria.sportify.models.season.Season;

import java.io.IOException;
import java.util.List;

public interface SeasonService {
    List<Season> findByLeagueId(int leagueId) throws IOException;
}

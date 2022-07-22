package com.senina.maria.sportify.services;

import com.senina.maria.sportify.models.season.Season;

import java.io.IOException;

public interface SeasonService {
    Season findByLeagueId(int leagueId) throws IOException;
}

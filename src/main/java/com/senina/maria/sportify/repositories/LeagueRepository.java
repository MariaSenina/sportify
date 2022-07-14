package com.senina.maria.sportify.repositories;

import com.senina.maria.sportify.models.league.LeagueData;

import java.io.IOException;

public interface LeagueRepository {
    LeagueData findById(int leagueId) throws IOException;
}

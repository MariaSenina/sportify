package com.senina.maria.sportify.services;

import com.senina.maria.sportify.models.league.LeagueResponse;

import java.io.IOException;

public interface LeagueService {
    LeagueResponse findById(int leagueId) throws IOException;
}

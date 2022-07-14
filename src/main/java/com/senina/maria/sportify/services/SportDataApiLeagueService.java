package com.senina.maria.sportify.services;

import com.senina.maria.sportify.models.league.LeagueData;
import com.senina.maria.sportify.models.league.LeagueResponse;
import com.senina.maria.sportify.repositories.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SportDataApiLeagueService implements LeagueService {
    private LeagueRepository leagueRepository;

    @Autowired
    public SportDataApiLeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public LeagueResponse findById(int leagueId) throws IOException {
        return mapToLeagueResponse(leagueRepository.findById(leagueId));
    }

    private LeagueResponse mapToLeagueResponse(LeagueData leagueData) {
        LeagueResponse leagueResponse = new LeagueResponse();
        leagueResponse.setLeagueData(leagueData);

        return leagueResponse;
    }
}

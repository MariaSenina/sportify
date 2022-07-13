package com.senina.maria.sportify.services;

import com.senina.maria.sportify.models.season.Season;
import com.senina.maria.sportify.repositories.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SportDataApiSeasonService implements SeasonService {
    private SeasonRepository seasonRepository;

    @Autowired
    public SportDataApiSeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public List<Season> findByLeagueId(int leagueId) throws IOException {
        return seasonRepository.findByLeagueId(leagueId);
    }
}

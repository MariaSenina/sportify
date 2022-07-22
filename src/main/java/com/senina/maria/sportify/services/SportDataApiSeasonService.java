package com.senina.maria.sportify.services;

import com.senina.maria.sportify.models.season.Season;
import com.senina.maria.sportify.repositories.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SportDataApiSeasonService implements SeasonService {
    private SeasonRepository seasonRepository;

    @Autowired
    public SportDataApiSeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public Season findByLeagueId(int leagueId) throws IOException {
        List<Season> seasons = seasonRepository.findByLeagueId(leagueId);
        Optional<Season> currentSeason
                = seasons.stream().filter(season -> season.isCurrent() == 1).findFirst();

        return currentSeason.get();
    }
}

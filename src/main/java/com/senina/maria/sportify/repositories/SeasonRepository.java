package com.senina.maria.sportify.repositories;

import com.senina.maria.sportify.models.season.Season;

import java.io.IOException;
import java.util.List;

public interface SeasonRepository {
    List<Season> findByLeagueId(int leagueId) throws IOException;
}

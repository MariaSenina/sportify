package com.senina.maria.sportify.repositories;

import com.senina.maria.sportify.models.season.Season;
import com.senina.maria.sportify.models.season.SeasonResponse;
import com.senina.maria.sportify.repositories.helpers.HttpRequestHelper;
import com.senina.maria.sportify.repositories.helpers.JsonParser;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Repository
public class SportDataApiSeasonRepository implements SeasonRepository {

    @Override
    public List<Season> findByLeagueId(int leagueId) throws IOException {
        URL url = new URL(ApiSetting.BASE_URL.getValue() + "seasons?league_id=" + leagueId);
        String jsonPayload = HttpRequestHelper.sendGetRequest(url);
        JsonParser<SeasonResponse> jsonParser = new JsonParser(SeasonResponse.class);

        return jsonParser.parse(jsonPayload).getSeasons();
    }
}

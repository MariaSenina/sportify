package com.senina.maria.sportify.repositories;

import com.senina.maria.sportify.models.league.LeagueData;
import com.senina.maria.sportify.models.league.LeagueResponse;
import com.senina.maria.sportify.repositories.helpers.HttpRequestHelper;
import com.senina.maria.sportify.repositories.helpers.JsonParser;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URL;

@Repository
public class SportDataApiLeagueRepository implements LeagueRepository {

    @Override
    public LeagueData findById(int leagueId) throws IOException {
        URL url = new URL(ApiSetting.BASE_URL.getValue() + "leagues/" + leagueId);
        String jsonPayload = HttpRequestHelper.sendGetRequest(url);
        JsonParser<LeagueResponse> jsonParser = new JsonParser(LeagueResponse.class);

        return jsonParser.parse(jsonPayload).getLeagueData();
    }
}

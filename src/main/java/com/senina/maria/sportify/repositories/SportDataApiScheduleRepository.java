package com.senina.maria.sportify.repositories;

import com.senina.maria.sportify.models.schedule.Match;
import com.senina.maria.sportify.models.schedule.MatchResponse;
import com.senina.maria.sportify.repositories.helpers.HttpRequestHelper;
import com.senina.maria.sportify.repositories.helpers.JsonParser;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Repository
public class SportDataApiScheduleRepository implements ScheduleRepository {

    @Override
    public List<Match> findBySeasonAndDate(int seasonId, String fromDate, String toDate) throws IOException {
        URL url = new URL(ApiSetting.BASE_URL.getValue() + "matches?season_id=" + seasonId
                + "&date_from=" + fromDate + "&date_to=" + toDate);
        String jsonPayload = HttpRequestHelper.sendGetRequest(url);
        JsonParser<MatchResponse> jsonParser = new JsonParser(MatchResponse.class);

        return jsonParser.parse(jsonPayload).getMatches();
    }
}

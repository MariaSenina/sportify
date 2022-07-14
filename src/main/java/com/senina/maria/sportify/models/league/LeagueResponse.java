package com.senina.maria.sportify.models.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = {"query"})
public class LeagueResponse {
    @JsonProperty("data")
    private LeagueData leagueData;

    public LeagueData getLeagueData() {
        return leagueData;
    }

    public void setLeagueData(LeagueData leagueData) {
        this.leagueData = leagueData;
    }

    @Override
    public String toString() {
        return "LeagueResponse{" +
                "leagueData=" + leagueData +
                '}';
    }
}

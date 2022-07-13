package com.senina.maria.sportify.models.schedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = {"match_id", "status_code", "status", "match_start_iso",
        "minute", "group", "referee_id", "stats", "round"})
public class Match {
    @JsonProperty("match_start")
    private String matchStart;
    @JsonProperty("league_id")
    private String leagueId;
    @JsonProperty("season_id")
    private String seasonId;
    private Stage stage;
    @JsonProperty("home_team")
    private Team homeTeam;
    @JsonProperty("away_team")
    private Team awayTeam;
    private Venue venue;

    public String getMatchStart() {
        return matchStart;
    }

    public void setMatchStart(String matchStart) {
        this.matchStart = matchStart;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchStart='" + matchStart + '\'' +
                ", leagueId='" + leagueId + '\'' +
                ", seasonId='" + seasonId + '\'' +
                ", stage=" + stage +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", venue=" + venue +
                '}';
    }
}

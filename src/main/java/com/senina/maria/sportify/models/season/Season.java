package com.senina.maria.sportify.models.season;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = {"league_id", "name"})
public class Season {
    @JsonProperty("season_id")
    private int seasonId;
    @JsonProperty("country_id")
    private int countryId;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("is_current")
    private Integer current;

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer isCurrent() {
        return current;
    }

    public void setIsCurrent(Integer current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonId=" + seasonId +
                ", countryId=" + countryId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", current='" + current + '\'' +
                '}';
    }
}

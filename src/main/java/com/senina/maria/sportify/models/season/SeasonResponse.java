package com.senina.maria.sportify.models.season;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(value = {"query"})
public class SeasonResponse {
    @JsonProperty("data")
    private List<Season> seasons;

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasonData) {
        this.seasons = seasonData;
    }

    @Override
    public String toString() {
        return "SeasonResponse{" +
                "seasons=" + seasons +
                '}';
    }
}

package com.senina.maria.sportify.models.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"league_id", "country_id"})
public class LeagueData {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LeagueData{" +
                "name='" + name + '\'' +
                '}';
    }
}

package com.senina.maria.sportify.models.schedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"stage_id"})
public class Stage {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "name='" + name + '\'' +
                '}';
    }
}

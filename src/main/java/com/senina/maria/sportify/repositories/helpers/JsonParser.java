package com.senina.maria.sportify.repositories.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonParser<T> {
    private Class<T> type;

    public JsonParser(Class<T> type) {
        this.type = type;
    }

    public T parse(String jsonPayload) throws JsonProcessingException {
        ObjectMapper objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        return objectMapper.readValue(jsonPayload, type);
    }
}

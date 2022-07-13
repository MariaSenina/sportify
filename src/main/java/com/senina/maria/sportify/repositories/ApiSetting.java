package com.senina.maria.sportify.repositories;

public enum ApiSetting {
    BASE_URL("https://app.sportdataapi.com/api/v1/soccer/"),
    KEY("04df0fc0-e779-11ec-b64c-f10f1fe36800");

    ApiSetting(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}

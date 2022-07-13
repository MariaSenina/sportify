package com.senina.maria.sportify.repositories.helpers;

import com.senina.maria.sportify.repositories.ApiSetting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class HttpRequestHelper {
    public static String sendGetRequest(URL url) throws IOException {
        // Open connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("apikey", ApiSetting.KEY.getValue());

        // Read input stream
        InputStream responseStream = connection.getInputStream();
        String result = new BufferedReader(new InputStreamReader(responseStream))
                .lines().collect(Collectors.joining("\n"));

        // Close connection
        connection.disconnect();

        return result;
    }
}

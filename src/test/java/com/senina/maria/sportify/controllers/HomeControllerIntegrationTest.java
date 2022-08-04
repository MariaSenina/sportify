package com.senina.maria.sportify.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration-test")
public class HomeControllerIntegrationTest {
    private static final String BASE_URL = "/";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturnHomePageWhenRequested() {
        ResponseEntity<String> response = testRestTemplate.getForEntity(BASE_URL, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("<title>Home</title>"));
    }
}

package com.senina.maria.sportify.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Reference: https://rieckpil.de/guide-to-springboottest-for-spring-boot-integration-tests/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration-test")
public class LoginControllerIntegrationTest {
    private static final String BASE_URL = "/login";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturnLoginPageWhenRequested() {
        ResponseEntity<String> response = testRestTemplate.getForEntity(BASE_URL, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("<title>Login</title>"));
    }

    @Test
    public void shouldReturnHomePageWhenSuccessfulLogin() throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap();
        map.add("email", "scooper@email.com");
        map.add("password", "123qwe");
        HttpEntity request = new HttpEntity(map, headers);

        ResponseEntity<String> response = testRestTemplate.postForEntity(new URI(BASE_URL), request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("<title>Home</title>"));
        assertTrue(response.getBody().contains("<p>Your username is: scooper</p>"));
    }

    @Test
    public void shouldReturnLoginPageWhenFailedLogin() throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap();
        map.add("email", "some_email");
        map.add("password", "some_password");
        HttpEntity request = new HttpEntity(map, headers);

        ResponseEntity<String> response = testRestTemplate.postForEntity(new URI(BASE_URL), request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("<title>Login</title>"));
    }

    @Test
    public void shouldReturnLoginPageWhenNoCredentialsSent() throws URISyntaxException {
        HttpEntity request = new HttpEntity(new LinkedMultiValueMap(), new HttpHeaders());

        ResponseEntity<String> response = testRestTemplate.postForEntity(new URI(BASE_URL), request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("<title>Login</title>"));
    }
}

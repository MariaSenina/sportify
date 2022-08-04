package com.senina.maria.sportify.controllers;

import com.senina.maria.sportify.models.User;
import com.senina.maria.sportify.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration-test")
public class LeagueControllerIntegrationTest {
    private static final String BASE_URL = "/leagues/";
    private static final Integer LEAGUE_ID = 663;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UserService userService;

//    @Test
//    public void shouldReturnUserHomePageWhenRequested() {
//        User user = userService.findByEmailAndPassword("scooper@email.com", "123qwe").get();
//        Model model = new ConcurrentModel();
//        model.addAttribute("user", user);
//
//        ResponseEntity<String> response = testRestTemplate.getForEntity(BASE_URL + LEAGUE_ID, String.class);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertTrue(response.getBody().contains("<title>Home</title>"));
//    }
}

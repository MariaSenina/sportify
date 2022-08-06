package com.senina.maria.sportify.controllers;

import com.senina.maria.sportify.models.User;
import com.senina.maria.sportify.services.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration-test")
public class LeagueControllerIT {
    private static final String BASE_URL = "/leagues/";
    private static final Integer LEAGUE_ID = 663;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Test
    public void shouldReturnUserHomePageWhenRequested() throws Exception {
        User user = userService.findByEmailAndPassword("scooper@email.com", "123qwe").get();
        Model model = new ConcurrentModel();
        model.addAttribute("user", user);
        Map<String, Object> sessionAttrs = new HashMap<>();
        sessionAttrs.put("user", user);

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + LEAGUE_ID).sessionAttrs(sessionAttrs))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("userHome"))
                .andExpect(MockMvcResultMatchers.model().attribute("user", user));
    }
}

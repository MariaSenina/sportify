package com.senina.maria.sportify.services;

import com.senina.maria.sportify.repositories.LeagueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SportDataApiLeagueServiceTest {
    private static final int LEAGUE_ID = 123;

    @Mock
    private LeagueRepository leagueRepository;

    private LeagueService leagueService;

    @BeforeEach
    void setUp() {
        leagueService = new SportDataApiLeagueService(leagueRepository);
    }

    @Test
    void shouldCallFindByIdWithSameIdWhenIdValid() throws IOException {
        leagueService.findById(LEAGUE_ID);

        verify(leagueRepository).findById(LEAGUE_ID);
    }
}
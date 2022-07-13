package com.senina.maria.sportify.services;

import com.senina.maria.sportify.models.schedule.Match;
import com.senina.maria.sportify.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SportDataApiScheduleService implements ScheduleService {
    private ScheduleRepository scheduleRepository;

    @Autowired
    public SportDataApiScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Match> findBySeasonAndDate(int seasonId, String fromDate, String toDate) throws IOException {
        return scheduleRepository.findBySeasonAndDate(seasonId, fromDate, toDate);
    }
}

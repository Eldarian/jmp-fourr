package com.eldarian.jmpfour.service;

import com.eldarian.jmpfour.repository.SportRepository;
import com.eldarian.jmpfour.apiclient.SportsApiClient;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@AllArgsConstructor
public class ETLService {
    private static final Logger logger = LogManager.getLogger(ETLService.class);

    private SportRepository sportRepository;

    private SportsApiClient sportsApiClient;

    public void populateModel(Model model) {
        //sportRepository.findAll().collectList().subscribe(sportList -> logger.info("all:" + sportList.toString()));
        sportRepository.findAll()
                .collectList()
                .subscribe(sports -> model.addAttribute("sportslist", sports));
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void populateDatabase() {
            sportsApiClient.getAllSports()
                    .doOnNext(sportRepository::save)
                    .subscribe();
    }
}

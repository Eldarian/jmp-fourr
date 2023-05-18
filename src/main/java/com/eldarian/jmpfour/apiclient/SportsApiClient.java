package com.eldarian.jmpfour.apiclient;

import com.eldarian.jmpfour.model.Sport;
import com.eldarian.jmpfour.model.SportData;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
@Log4j2
public class SportsApiClient {

    @Autowired
    private final WebClient webClient;

    public Flux<Sport> getAllSports() {
        return webClient.get()
                .uri("/sports")
                .exchangeToMono(response -> response.bodyToMono(SportData.class))
                .doOnError(err -> log.error("error on response", err))
                .flatMapIterable(SportData::getData)
                .doOnNext(sport -> log.info(sport.toString()));

    }
}

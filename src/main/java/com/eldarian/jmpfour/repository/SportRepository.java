package com.eldarian.jmpfour.repository;

import com.eldarian.jmpfour.model.Sport;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface SportRepository extends ReactiveCrudRepository<Sport, Integer> {
    Mono<Sport> findSportById(Integer id);
    @NotNull
    Flux<Sport> findAll();
}

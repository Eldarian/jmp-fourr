package com.eldarian.jmpfour.apiclient;

import com.eldarian.jmpfour.repository.SportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SportApiConsumer implements SmartLifecycle {

    private final SportsApiClient apiClient;
    private final SportRepository repository;

    @Override
    public void start() {
        repository.saveAll(apiClient.getAllSports()).blockLast();
    }

    @Override
    public void stop() {}

    @Override
    public boolean isRunning() {
        return false;
    }
}

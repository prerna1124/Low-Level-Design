package com.machinecoding.ticketbooking.service;

import com.machinecoding.ticketbooking.model.Screen;
import com.machinecoding.ticketbooking.model.Theatre;
import com.machinecoding.ticketbooking.repository.ScreenRepository;

import java.util.UUID;

public class ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenService(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    public String addScreen(String name, Theatre theatre) {
        String theatreId = theatre.getId();
        Screen screen = new Screen(theatre, name);
        theatre.addScreen(screen);
        return screenRepository.addScreen(screen).getId();
    }

    public Screen getScreenById(String screenId) {
        return screenRepository.getScreenById(screenId);
    }
}

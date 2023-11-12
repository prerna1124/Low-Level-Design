package com.machinecoding.ticketbooking.controller;

import com.machinecoding.ticketbooking.model.Screen;
import com.machinecoding.ticketbooking.model.Theatre;
import com.machinecoding.ticketbooking.service.ScreenService;
import lombok.NonNull;

public class ScreenController {
    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    public String createScreen(@NonNull final String screenName, @NonNull final Theatre theatre) {
        return screenService.addScreen(screenName, theatre);
    }

    public Screen getScreenById(String screenId) {
        return screenService.getScreenById(screenId);
    }
}

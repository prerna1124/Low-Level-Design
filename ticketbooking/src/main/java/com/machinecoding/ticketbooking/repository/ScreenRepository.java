package com.machinecoding.ticketbooking.repository;

import com.machinecoding.ticketbooking.model.Screen;

import java.util.HashMap;
import java.util.Map;

public class ScreenRepository {
    private final Map<String, Screen> screenMap;
    public ScreenRepository() {
        this.screenMap = new HashMap<>();
    }

    public Screen addScreen(Screen screen) {
        screenMap.put(screen.getId(),screen);
        return screen;
    }

    public Screen getScreenById(String screenId) {
        return screenMap.get(screenId);
    }
}

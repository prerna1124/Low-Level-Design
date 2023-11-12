package com.machinecoding.ticketbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Theatre {
    private String id;
    private List<Screen> screens;
    private String name;

    public Theatre(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.screens = new ArrayList<>();
    }

    public void addScreen(Screen screen) {
        this.screens.add(screen);
    }
}

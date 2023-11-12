package com.machinecoding.ticketbooking.repository;

import com.machinecoding.ticketbooking.model.Movie;
import com.machinecoding.ticketbooking.model.Screen;
import com.machinecoding.ticketbooking.model.Show;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ShowRepository {

    private final Map<String, Show> showMap;

    public ShowRepository() {
        this.showMap = new HashMap<>();
    }

    public Show addShow(Show show) {
        showMap.put(show.getId(), show);
        return show;
    }

    public Show getShowById(String showId) {
        return showMap.get(showId);
    }
}

package com.machinecoding.ticketbooking.repository;

import com.machinecoding.ticketbooking.exception.InvalidTheatre;
import com.machinecoding.ticketbooking.model.Screen;
import com.machinecoding.ticketbooking.model.Theatre;

import java.util.*;

public class TheatreRepository {

    private final Map<String, Theatre> theatreMap;
    public TheatreRepository() {
        this.theatreMap = new HashMap<>();
    }

    public Theatre addTheatre(Theatre theatre) {
        theatreMap.put(theatre.getId(),theatre);
        return theatre;
    }

    public Theatre getTheatreById(String id) {
        if(!theatreMap.containsKey(id)) {
            throw new InvalidTheatre();
        }

        return theatreMap.get(id);
    }
}

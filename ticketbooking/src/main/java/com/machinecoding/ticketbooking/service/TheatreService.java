package com.machinecoding.ticketbooking.service;

import com.machinecoding.ticketbooking.exception.InvalidTheatre;
import com.machinecoding.ticketbooking.model.Theatre;
import com.machinecoding.ticketbooking.repository.TheatreRepository;
import lombok.NonNull;

import java.util.UUID;

public class TheatreService {
    private final TheatreRepository theatreRepository;

    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public String addTheatre(@NonNull final String theatreName) {
        Theatre theatre = new Theatre(theatreName);
        return theatreRepository.addTheatre(theatre).getId();
    }

    public Theatre getTheatreById(String id) {
        return theatreRepository.getTheatreById(id);
    }
}

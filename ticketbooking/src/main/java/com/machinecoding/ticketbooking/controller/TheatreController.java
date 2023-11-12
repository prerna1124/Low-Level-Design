package com.machinecoding.ticketbooking.controller;

import com.machinecoding.ticketbooking.model.Theatre;
import com.machinecoding.ticketbooking.service.TheatreService;
import lombok.NonNull;

public class TheatreController {
    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public String createTheatre(@NonNull final String theatreName) {
        return theatreService.addTheatre(theatreName);
    }
    public Theatre getTheatreById(String id) {
        return theatreService.getTheatreById(id);
    }
}

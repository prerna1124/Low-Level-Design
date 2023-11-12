package com.machinecoding.ticketbooking.controller;

import com.machinecoding.ticketbooking.model.Show;
import com.machinecoding.ticketbooking.service.ShowService;
import lombok.NonNull;

import java.util.Date;

public class ShowController {
    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    public String createShow(@NonNull final String showName, @NonNull final String movieId,
                               @NonNull final String screenId, @NonNull final Date startTime,
                               @NonNull final Integer duration) {
        return showService.addShow(showName, movieId, screenId, startTime, duration);
    }

    public Show getShowById(String showId) {
        return showService.getShowById(showId);
    }
}

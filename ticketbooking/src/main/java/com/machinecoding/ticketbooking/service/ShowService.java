package com.machinecoding.ticketbooking.service;

import com.machinecoding.ticketbooking.model.Movie;
import com.machinecoding.ticketbooking.model.Screen;
import com.machinecoding.ticketbooking.model.Show;
import com.machinecoding.ticketbooking.repository.ShowRepository;

import java.util.Date;
import java.util.UUID;

public class ShowService {
    private final ShowRepository showRepository;
    private final MovieService movieService;
    private final ScreenService screenService;

    public ShowService(ShowRepository showRepository, MovieService movieService, ScreenService screenService) {
        this.showRepository = showRepository;
        this.movieService = movieService;
        this.screenService = screenService;
    }

    public String addShow(String showName, String movieId, String screenId, Date startTime, Integer duration) {
        Movie movie = movieService.getMovieById(movieId);
        Screen screen = screenService.getScreenById(screenId);
        return showRepository.addShow(new Show(UUID.randomUUID().toString(), movie, screen, startTime, duration)).getId();
    }

    public Show getShowById(String showId) {
        return showRepository.getShowById(showId);
    }
}

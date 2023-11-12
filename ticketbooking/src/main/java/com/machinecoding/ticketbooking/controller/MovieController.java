package com.machinecoding.ticketbooking.controller;

import com.machinecoding.ticketbooking.model.Movie;
import com.machinecoding.ticketbooking.service.MovieService;
import lombok.NonNull;

public class MovieController {
    final private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public String createMovie(@NonNull final String movieName) {
        return movieService.addMovie(movieName);
    }

    public Movie getMovieById(String id) {
        return movieService.getMovieById(id);
    }
}

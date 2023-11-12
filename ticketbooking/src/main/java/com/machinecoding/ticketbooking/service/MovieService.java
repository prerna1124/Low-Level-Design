package com.machinecoding.ticketbooking.service;

import com.machinecoding.ticketbooking.model.Movie;
import com.machinecoding.ticketbooking.repository.MovieRepository;

import java.util.UUID;

public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public String addMovie(String name) {
        Movie movie = new Movie(UUID.randomUUID().toString(), name);
        return movieRepository.addMovie(movie).getId();
    }

    public Movie getMovieById(String id) {
        return movieRepository.getMovieById(id);
    }
}

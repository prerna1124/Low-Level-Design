package com.machinecoding.ticketbooking.repository;

import com.machinecoding.ticketbooking.model.Movie;
import com.machinecoding.ticketbooking.model.Screen;
import com.machinecoding.ticketbooking.model.Theatre;

import java.util.HashMap;
import java.util.Map;

public class MovieRepository {
    private final Map<String, Movie> movieMap;
    public MovieRepository() {
        this.movieMap = new HashMap<>();
    }

    public Movie addMovie(Movie movie) {
        movieMap.put(movie.getId(),movie);
        return movie;
    }

    public Movie getMovieById(String id) {
        return movieMap.get(id);
    }
}

package com.machinecoding.ticketbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Screen {
    private String id;
    private Theatre theatre;
    private String name;
    private List<Seat> seats;

    public Screen(Theatre theatre, String name) {
        this.id = UUID.randomUUID().toString();
        this.theatre = theatre;
        this.name = name;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }
}

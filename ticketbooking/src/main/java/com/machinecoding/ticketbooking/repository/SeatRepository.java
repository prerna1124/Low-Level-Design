package com.machinecoding.ticketbooking.repository;

import com.machinecoding.ticketbooking.exception.InvalidTheatre;
import com.machinecoding.ticketbooking.model.Seat;

import java.util.HashMap;

public class SeatRepository {

    private final HashMap<String, Seat> seatMap;

    public SeatRepository() {
        this.seatMap = new HashMap<>();
    }

    public String addSeat(Seat seat) {
        seatMap.put(seat.getId(), seat);
        return seat.getId();
    }

    public Seat getSeatById(String id) {
        if(seatMap.containsKey(id)) {
            throw new InvalidTheatre();
        }

        return seatMap.get(id);
    }
}

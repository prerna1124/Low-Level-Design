package com.machinecoding.ticketbooking.service;

import com.machinecoding.ticketbooking.model.Seat;
import com.machinecoding.ticketbooking.model.Show;
import com.machinecoding.ticketbooking.repository.SeatRepository;
import com.machinecoding.ticketbooking.utils.InMemoryLockingService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public String addSeat(char seatRow, int seatNumber) {
        return seatRepository.addSeat(new Seat(UUID.randomUUID().toString(), seatRow, seatNumber));
    }

    public Seat getSeatById(String id) {
        return seatRepository.getSeatById(id);
    }
}

package com.machinecoding.ticketbooking.controller;

import com.machinecoding.ticketbooking.model.Seat;
import com.machinecoding.ticketbooking.service.SeatService;

public class SeatController {
    private final SeatService seatService;


    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    public String addSeat(char seatRow, int seatNumber) {
        return seatService.addSeat(seatRow, seatNumber);
    }

    public Seat getSeatById(String id) {
        return seatService.getSeatById(id);
    }
}

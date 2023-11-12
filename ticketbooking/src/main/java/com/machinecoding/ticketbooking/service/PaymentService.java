package com.machinecoding.ticketbooking.service;

import com.machinecoding.ticketbooking.exception.SeatCurrentlyUnavailable;
import com.machinecoding.ticketbooking.model.Seat;
import com.machinecoding.ticketbooking.model.Show;
import com.machinecoding.ticketbooking.model.User;
import com.machinecoding.ticketbooking.utils.InMemoryLockingService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PaymentService {
    private final InMemoryLockingService inMemoryLockingService;

    public PaymentService(InMemoryLockingService inMemoryLockingService) {
        this.inMemoryLockingService = inMemoryLockingService;
    }

    public void payForSelectedSeats(Show show, List<Seat> seats, User user) {
        inMemoryLockingService.lockSeats(show, seats, user);
    }

    public List<Seat> paymentSuccessful(Show show, List<Seat> seats, User user) {

    }
}

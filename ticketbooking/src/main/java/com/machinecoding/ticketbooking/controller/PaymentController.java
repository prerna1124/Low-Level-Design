package com.machinecoding.ticketbooking.controller;

import com.machinecoding.ticketbooking.model.Seat;
import com.machinecoding.ticketbooking.model.Show;
import com.machinecoding.ticketbooking.model.User;
import com.machinecoding.ticketbooking.service.PaymentService;
import com.machinecoding.ticketbooking.utils.InMemoryLockingService;

import java.util.List;

public class PaymentController {
    private final PaymentService paymentService;


    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void payForSelectedSeats(Show show, List<Seat> seats, User user) {
        paymentService.payForSelectedSeats(show, seats, user);
    }

    public List<Seat> paymentSuccessful() {
        return paymentService.paymentSuccessful();
    }
}

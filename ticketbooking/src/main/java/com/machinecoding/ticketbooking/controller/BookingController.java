package com.machinecoding.ticketbooking.controller;

import com.machinecoding.ticketbooking.model.Seat;
import com.machinecoding.ticketbooking.model.Show;
import com.machinecoding.ticketbooking.model.User;
import com.machinecoding.ticketbooking.service.BookingService;

import java.util.List;

public class BookingController {

    private final BookingService bookingService;

//    public String createBooking(Show show, List<Seat> seats, User user) {
//        bookingService.createBooking(show, seats, user)
//    }

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
}

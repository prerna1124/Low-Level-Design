package com.machinecoding.ticketbooking.model;

import com.machinecoding.ticketbooking.exception.InvalidStateException;

import java.util.List;

public class Booking {
    private String id;
    private Show show;
    private List<Seat> seatsBooked;
    private BookingStatus status;

    private User user;

    public Booking(String id, Show show, List<Seat> seats, BookingStatus status, User user) {
        this.id = id;
        this.show = show;
        this.seatsBooked = seats;
        this.status = BookingStatus.BOOKING_CREATED;
        this.user = user;
    }

    public boolean isConfirmed() {
        return this.status == BookingStatus.BOOKING_SUCCESSFUL;
    }

    public void confirmBooking() {
        if(this.status != BookingStatus.BOOKING_CREATED) {
            throw new InvalidStateException();
        }
        this.status = BookingStatus.BOOKING_SUCCESSFUL;
    }

    public void expiryBooking() {
        if(this.status != BookingStatus.BOOKING_CREATED) {
            throw new InvalidStateException();
        }
        this.status = BookingStatus.BOOKING_EXPIRED;
    }
}

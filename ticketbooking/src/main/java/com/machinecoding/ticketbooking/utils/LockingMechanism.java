package com.machinecoding.ticketbooking.utils;

import com.machinecoding.ticketbooking.model.Seat;
import com.machinecoding.ticketbooking.model.Show;
import com.machinecoding.ticketbooking.model.User;

import java.util.List;

public interface LockingMechanism {

    void lockSeats(Show show, List<Seat> seats, User user);

    void unlockSeats(Show show, List<Seat> seats, String user);
    List<Seat> getLockedSeats(Show show);
}

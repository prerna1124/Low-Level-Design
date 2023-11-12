package com.machinecoding.ticketbooking.utils;

import com.machinecoding.ticketbooking.exception.SeatCurrentlyUnavailable;
import com.machinecoding.ticketbooking.model.LockSeat;
import com.machinecoding.ticketbooking.model.Seat;
import com.machinecoding.ticketbooking.model.Show;

import java.util.*;

public class InMemoryLockingService implements LockingMechanism {

    private final Map<Show, Map<Seat, LockSeat>> lockedSeats;

    public InMemoryLockingService(Map<Show, Map<Seat, LockSeat>> lockedSeats) {
        this.lockedSeats = lockedSeats;
    }

    public void lockSeats(Show show, List<Seat> seats, String user) {
        for(Seat seat : seats) {
            if(isSeatLocked(show, seat)) {
                throw new SeatCurrentlyUnavailable();
            }
        }

        for(Seat seat : seats) {
            lockSeat(show, seat, user);
        }
    }

    public void lockSeat(Show show, Seat seat, String user) {
        if(!lockedSeats.containsKey(show)) {
            lockedSeats.put(show, new HashMap<>());
        }
        LockSeat lockSeat = new LockSeat(seat, show, 2, new Date(), user);
        lockedSeats.get(show).put(seat, lockSeat);
    }

    public void unlockSeats(Show show, List<Seat> seats, String user) {
        for(Seat seat : seats) {
            if(isValidate(show, seat, user)) {
                unlockSeat(show, seat);
            }
        }
    }

    public void unlockSeat(Show show, Seat seat) {
        if(lockedSeats.containsKey(show)) {
            if(lockedSeats.get(show).containsKey(seat)) {
                lockedSeats.get(show).remove(seat);
            }
        }
    }

    public boolean isValidate(Show show, Seat seat, String user) {
        return isSeatLocked(show, seat) && lockedSeats.get(show).get(seat).getLockedBy().equals(user);
    }

    public boolean isSeatLocked(Show show, Seat seat) {
        if(lockedSeats.containsKey(show)) {
            if(lockedSeats.get(show).containsKey(seat)) {
                return lockedSeats.get(show).get(seat).isLockedExpired();
            }
        }

        return false;
    }

    public List<Seat> getLockedSeats(Show show) {
        if(lockedSeats.containsKey(show)) {
            return new ArrayList<>();
        }

        final List<Seat> seats = new ArrayList<>();

        for (Seat seat : lockedSeats.get(show).keySet()) {
            if (isSeatLocked(show, seat)) {
                seats.add(seat);
            }
        }
        return seats;
    }
}

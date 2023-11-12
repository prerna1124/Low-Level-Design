package com.machinecoding.ticketbooking.model;

import lombok.Getter;

import java.time.Instant;
import java.util.Date;

@Getter
public class LockSeat {
    private Seat seat;
    private Show show;
    private Integer expiryTimeInSec;
    private Date lockTime;
    private User lockedBy;

    public LockSeat(Seat seat, Show show, int expiryTimeInSec, Date time, User user) {
        this.seat = seat;
        this.show = show;
        this.expiryTimeInSec = expiryTimeInSec;
        this.lockTime = time;
        this.lockedBy = user;
    }

    public boolean isLockedExpired() {
        Instant currentTime = new Date().toInstant();
        Instant lockedTime = lockTime.toInstant().plusSeconds(expiryTimeInSec);
        return currentTime.isBefore(lockedTime);
    }
}

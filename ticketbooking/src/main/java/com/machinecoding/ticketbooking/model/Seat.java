package com.machinecoding.ticketbooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class Seat {
    private String id;
    private char row;
    private int seatNumber;

    public Seat(char row, int seatNumber) {
        this.id = UUID.randomUUID().toString();
        this.row = row;
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id='" + id + '\'' +
                ", row=" + row +
                ", seatNumber=" + seatNumber +
                '}';
    }
}

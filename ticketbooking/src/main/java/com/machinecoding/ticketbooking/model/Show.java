package com.machinecoding.ticketbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class Show {
    private String id;
    private Movie movie;
    private Screen screen;
    private Date startTime;
    private int duration;

}

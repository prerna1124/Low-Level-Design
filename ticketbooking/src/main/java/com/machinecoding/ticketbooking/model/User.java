package com.machinecoding.ticketbooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class User {
    private String userEmail;
    private String name;
}

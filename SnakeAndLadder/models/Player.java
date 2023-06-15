package SnakeAndLadder.models;

import java.util.UUID;

public class Player {
    private String name;
    private String id;

    public Player(String name) {
        this.name = name;
        id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

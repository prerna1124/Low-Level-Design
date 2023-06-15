package SnakeAndLadder.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private Map<String, Integer> playersPieces;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private int size;

    public Board(int size) {
        this.playersPieces = new HashMap<>();
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.size = size;
    }

    public Map<String, Integer> getPlayers() {
        return playersPieces;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public int getSize() {
        return size;
    }

    public void setPlayersPieces(Map<String, Integer> playersPieces) {
        this.playersPieces = playersPieces;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<String, Integer> getPlayersPieces() {
        return playersPieces;
    }
}

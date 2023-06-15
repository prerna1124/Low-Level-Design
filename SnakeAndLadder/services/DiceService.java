package SnakeAndLadder.services;

import java.util.Random;

public class DiceService {
    int diceValue;

    int rollDice() {
        diceValue = new Random().nextInt(6) + 1;
        return diceValue;
    }
}

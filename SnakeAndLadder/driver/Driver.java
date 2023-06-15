package SnakeAndLadder.driver;

import SnakeAndLadder.models.Ladder;
import SnakeAndLadder.models.Player;
import SnakeAndLadder.models.Snake;
import SnakeAndLadder.services.SnakeAndLadderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noOfSnakes = Integer.parseInt(reader.readLine());
        int noOfLadders = Integer.parseInt(reader.readLine());
        int noOfPlayers = Integer.parseInt(reader.readLine());

        List<Snake> snakeList = new ArrayList<>();
        List<Ladder> ladderList = new ArrayList<>();
        List<Player> playersList = new ArrayList<>();

        for(int i = 0; i < noOfSnakes; i++) {
            String[] st = reader.readLine().trim().split("\\s+");
            snakeList.add(new Snake(Integer.parseInt(st[0]), Integer.parseInt(st[1])));
        }

        for(int i = 0; i < noOfLadders; i++) {
            String[] st = reader.readLine().trim().split("\\s+");
            ladderList.add(new Ladder(Integer.parseInt(st[0]), Integer.parseInt(st[1])));
        }

        for(int i = 0; i < noOfPlayers; i++) {
            String[] st = reader.readLine().trim().split("\\s+");
            playersList.add(new Player(st[0]));
        }

        SnakeAndLadderService service = new SnakeAndLadderService();
        service.setSnakes(snakeList);
        service.setLadders(ladderList);
        service.setPlayers(playersList);
        service.setShouldGameRunTillLastPlayer(true);
        service.setShouldAllowMultipleRollsOnSix(true);

        service.startGame();
    }
}

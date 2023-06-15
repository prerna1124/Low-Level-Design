package SnakeAndLadder.services;

import SnakeAndLadder.models.Board;
import SnakeAndLadder.models.Ladder;
import SnakeAndLadder.models.Player;
import SnakeAndLadder.models.Snake;

import java.util.*;

public class SnakeAndLadderService {
    private Board board;
    private int initialNumberOfPlayers;
    private int numberOfDices;
    private Queue<Player> gameQueue;
    private boolean isGameCompleted;


    private boolean shouldGameRunTillLastPlayer;
    private boolean shouldAllowMultipleRollsOnSix;

    private static final int BOARD_SIZE = 100;
    private static final int NUMBER_OF_DICE = 1;

    SnakeAndLadderService(int size) {
        this.board = new Board(size);
        this.gameQueue = new LinkedList<>();
        this.numberOfDices = SnakeAndLadderService.NUMBER_OF_DICE;
    }

    public SnakeAndLadderService() {
        this(SnakeAndLadderService.BOARD_SIZE);
    }


    public int getNumberOfDices() {
        return this.numberOfDices;
    }

    public void setNumberOfDices(int numberOfDices) {
        this.numberOfDices = numberOfDices;
    }

    public boolean isGameCompleted() {
        return this.isGameCompleted;
    }

    public void setGameCompleted(boolean gameCompleted) {
        this.isGameCompleted = gameCompleted;
    }

    public boolean isShouldGameRunTillLastPlayer() {
        return this.shouldGameRunTillLastPlayer;
    }

    public void setShouldGameRunTillLastPlayer(boolean shouldGameRunTillLastPlayer) {
        this.shouldGameRunTillLastPlayer = shouldGameRunTillLastPlayer;
    }

    public boolean isShouldAllowMultipleRollsOnSix() {
        return this.shouldAllowMultipleRollsOnSix;
    }

    public void setShouldAllowMultipleRollsOnSix(boolean shouldAllowMultipleRollsOnSix) {
        this.shouldAllowMultipleRollsOnSix = shouldAllowMultipleRollsOnSix;
    }

    public int getInitialNumberOfPlayers() {
        return this.initialNumberOfPlayers;
    }

    public void setInitialNumberOfPlayers(int initialNumberOfPlayers) {
        this.initialNumberOfPlayers = initialNumberOfPlayers;
    }

    public void setPlayers(List<Player> players) {
        Map<String, Integer> playerPieces = new HashMap<>();

        for(int i = 0; i < players.size(); i++) {
            playerPieces.put(players.get(i).getId(), 0);
            this.gameQueue.add(players.get(i));
        }

        this.board.setPlayersPieces(playerPieces);
    }

    public void setSnakes(List<Snake> snakes) {
        this.board.setSnakes(snakes);
    }

    public void setLadders(List<Ladder> ladders) {
        this.board.setLadders(ladders);
    }

    public Queue<Player> getGameQueue() {
        return this.gameQueue;
    }

    int moveWhen3ConsecutiveSix() {
        int val = 0;
        if(this.isShouldAllowMultipleRollsOnSix()) {
            int numOfSix = 0, move = 0;
            do {
                val = new DiceService().rollDice();
                System.out.println(val +" is thrown");
                move += val;
                if(val == 6) numOfSix += 1;
            } while(val == 6 && numOfSix < 3);

            if(numOfSix >= 3) {
                System.out.println("3 six thrown, 1 chance will be given");
                val = new DiceService().rollDice();
                System.out.println("Finally "+ val +" is thrown");
                return val;
            } else {
                return move;
            }
        } else {
            val = new DiceService().rollDice();
            System.out.println(val +" is thrown");
            return val;
        }
    }

    public void startGame() {
        int count = 0;
        while(!this.isGameCompleted) {
            Player currPlayer = this.gameQueue.poll();
            System.out.println("Current player is : "+ currPlayer.getName());

            int move = moveWhen3ConsecutiveSix();
            movePlayer(currPlayer, move);
            if(checkIfWins(currPlayer)) {
                count += 1;
                if(this.shouldGameRunTillLastPlayer) {
                    if(this.gameQueue.size() > 1)
                        System.out.println(currPlayer.getName() + " wins the game with "+ count+" position.");
                    else {
                        System.out.println(currPlayer.getName() + " wins the game with "+ count+" position.");
                        System.out.println(this.gameQueue.poll().getName() + " looses the game.");
                        this.isGameCompleted = true;
                    }
                }
            } else {
                this.gameQueue.add(currPlayer);
            }
        }
    }

    private boolean checkIfWins(Player currPlayer) {
        if(this.board.getPlayersPieces().get(currPlayer.getId()) == SnakeAndLadderService.BOARD_SIZE) {
            return true;
        } else {
            return false;
        }
    }

    private void movePlayer(Player currPlayer, int move) {
        int position = this.board.getPlayersPieces().get(currPlayer.getId());
        int newPosition = position + move;

        if(newPosition > SnakeAndLadderService.BOARD_SIZE) {
            newPosition = position;
        }
        else {
            int prevPosition;
            do {
                prevPosition = newPosition;
                for (Snake snake : this.board.getSnakes()) {
                    if (snake.getStartPostion() == newPosition) {
                        newPosition = snake.getEndPosition();
                    }
                }

                for (Ladder ladder : this.board.getLadders()) {
                    if (ladder.getStartPostion() == newPosition) {
                        newPosition = ladder.getEndPosition();
                    }
                }
            } while (prevPosition != newPosition);
        }
        if(newPosition > SnakeAndLadderService.BOARD_SIZE)
            System.out.println(currPlayer.getName() +" can not make a move.");
        else {
            this.board.getPlayersPieces().put(currPlayer.getId(), newPosition);
            System.out.println("Dice rolled by " + currPlayer.getName() + " with " + move + " from "+ position + " with new position " + newPosition);
        }
    }
}

package SnakeAndLadder.models;

public class Ladder {
    private int startPostion;
    private int endPosition;

    public Ladder(int startPostion, int endPosition) {
        this.startPostion = startPostion;
        this.endPosition = endPosition;
    }

    public int getStartPostion() {
        return startPostion;
    }

    public int getEndPosition() {
        return endPosition;
    }
}

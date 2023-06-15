package SnakeAndLadder.models;

public class Snake {
    private int startPostion;
    private int endPosition;

    public Snake(int startPostion, int endPosition) {
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

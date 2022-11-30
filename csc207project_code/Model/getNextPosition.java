package Model;

import java.util.ArrayList;

public interface getNextPosition {
    /**
     * Return all possible next locations the chess can move.
     * @param board the Board we are looking at
     * @return all possible next locations the chess can move
     */
    public ArrayList<Location> getNextPosition(Board board);
}

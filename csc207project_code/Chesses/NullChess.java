package Chesses;
import Model.*;

import java.util.ArrayList;

public class NullChess extends Chess{


    public NullChess(Location location, String faction, String type) {
        // TODO - implement Chess.Chess
//		throw new UnsupportedOperationException();
        super(location, faction, type);
    }

    /**
     *
     * @param destination
     * @param board
     */
    public void move(Location destination, Board board) {
        throw new UnsupportedOperationException();
    }

    public ArrayList<Location> getNextPosition(Board board) {
        return new ArrayList<Location>();
    }

}
package Chesses;
import Model.*;

import java.util.ArrayList;

public class NullChess extends Chess{


    /**
     * Constructor of NullChess. it is just inherited from Chess.
     * @param location the location the chess is on
     * @param faction the faction the chess is
     * @param type the type of the chess, for NullChess it is Null
     */
    public NullChess(Location location, String faction, String type) {
        super(location, faction, type);
    }

    /**
     * null chess cannot move!
     * api is still here.
     * @param destination the location the chess move to
     * @param board the board the game is on
     */
    public void move(Location destination, Board board) {
        throw new UnsupportedOperationException();
    }

    /**
     * null chess has no next positions
     * @param board the board the game is on
     * @return a new arraylist that doesn't contain an element.
     */
    public ArrayList<Location> getNextPosition(Board board){
        return new ArrayList<>();
    }

}
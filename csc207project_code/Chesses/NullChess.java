package Chesses;
import Model.*;

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
        // TODO - implement General.move
        throw new UnsupportedOperationException();
    }

}
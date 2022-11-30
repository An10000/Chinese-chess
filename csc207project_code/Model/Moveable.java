package Model;

public abstract interface Moveable {

	/**
	 * Move the chess to destination location on the board.
	 * @param destination the destination, the chess moves there.
	 * @param board the board we are moving on.
	 */
	void move(Location destination, Board board);

}
package Model;

public abstract interface Moveable {

	/**
	 * 
	 * @param destination
	 * @param board
	 */
	void move(Location destination, Board board);

}
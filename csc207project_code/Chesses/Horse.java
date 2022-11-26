package Chesses;
import Model.*;

import java.util.ArrayList;

public class Horse extends Chess implements Moveable, getNextPosition {

	/**
	 * @param location
	 * @param faction
	 * @param type
	 */
	public Horse(Location location, String faction, String type) {
		super(location, faction, type);
	}

	/**
	 * 
	 * @param destination
	 * @param board
	 */
	public void move(Location destination, Board board) {
		// TODO - implement Horse.move
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Location> getNextPosition(Board board) {
		return null;
	}
}
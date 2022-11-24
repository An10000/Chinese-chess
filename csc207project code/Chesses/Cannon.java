package Chesses;
import Model.*;

import java.util.ArrayList;

public class Cannon extends Chess implements Moveable, getNextPosition {

	/**
	 * @param location
	 * @param faction
	 * @param type
	 */
	public Cannon(Location location, String faction, String type) {
		super(location, faction, type);
	}

	/**
	 * 
	 * @param destination
	 * @param board
	 */
	public void move(Location destination, Board board) {
		// TODO - implement Cannon.move
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Location> getNextPosition(Board board) {
		return null;
	}
}
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
		board.removeChessAt(getLocation());
		this.getLocation().setRow(destination.getRow());
		this.getLocation().setCol(destination.getCol());
		board.setChessAt(this, destination);
	}


	/**
	 * Get All legal positions for Cannon.
	 * Cannon can move to almost every spot on the board when there is no chess blocked his way,
	 * but only in vertical or horizontal direction.
	 * If Cannon what to kill other chess, there must be another chess between the target chess and itself.
	 * @param board the board the players are playing
	 * @return all possible next locations the chess can move
	 */
	@Override
	public ArrayList<Location> getNextPosition(Board board) {
		//前进 towards
		int curr = 0;
		ArrayList<Location> locations = new ArrayList<>();
		for (int i = this.getLocation().getRow(); i > 0; i--) {

			Location new_location = new Location(i - 1, this.getLocation().getCol());
			if (board.getChessAt(new_location).getType() == null) {
				locations.add(new_location);
			}
			else {
				curr = i;
				break;
			}
		}
		System.out.println("curr: " +curr);
		for (int j = curr - 2; j > 0; j--) {
			Location after_location = new Location(j - 1, getLocation().getCol());
			if ((board.getChessAt(after_location).getType() != null && !board.getChessAt(after_location).getType().equalsIgnoreCase(getType()))) {
				if (!locations.contains(after_location)) {
					locations.add(after_location);
					break;
				}
			}
		}



		//------------------------------------------------------
        //后退 backwards
		curr = 0;
		for (int i = this.getLocation().getRow(); i < 9; i++) {

			Location new_location = new Location(i + 1, this.getLocation().getCol());
			if (board.getChessAt(new_location).getType() == null) {
				locations.add(new_location);
			}
			else {
				curr = i;
				break;
			}
		}
		for (int j = curr + 2; j < 9; j++) {
			Location after_location = new Location(j + 1, getLocation().getCol());
			if ((board.getChessAt(after_location).getType() != null && !board.getChessAt(after_location).getType().equalsIgnoreCase(getType()))) {
				if (!locations.contains(after_location)) {
					locations.add(after_location);
					break;
				}
			}
		}



		//------------------------------------------------------
		//left
		curr = 0;
		for (int i = this.getLocation().getCol(); i > 0; i--) {

			Location new_location = new Location(this.getLocation().getRow(), i - 1);
			if (board.getChessAt(new_location).getType() == null) {
				locations.add(new_location);
			}
			else {
				curr = i;
				break;
			}
		}
		for (int j = curr - 2; j > 0; j--) {
			Location after_location = new Location(getLocation().getRow(), j - 1);
			if ((board.getChessAt(after_location).getType() != null && !board.getChessAt(after_location).getType().equalsIgnoreCase(getType()))) {
				if (!locations.contains(after_location)) {
					locations.add(after_location);
					break;
				}
			}
		}




		//------------------------------------------------------
		//right
		curr = 0;
		for (int i = this.getLocation().getCol(); i < 8; i++) {

			Location new_location = new Location(this.getLocation().getRow(), i + 1);
			if (board.getChessAt(new_location).getType() == null) {
				locations.add(new_location);
			}
			else {
				curr = i;
				break;
			}
		}
		for (int j = curr + 2; j < 8; j++) {
			Location after_location = new Location(getLocation().getRow(), j + 1);
			if ((board.getChessAt(after_location).getType() != null && !board.getChessAt(after_location).getType().equalsIgnoreCase(getType()))) {
				if (!locations.contains(after_location)) {
					locations.add(after_location);
					break;
				}
			}
		}
		return locations;
	}
}
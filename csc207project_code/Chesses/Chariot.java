package Chesses;
import Model.*;

import java.util.ArrayList;

public class Chariot extends Chess implements Moveable, getNextPosition {

	/**
	 * @param location
	 * @param faction
	 * @param type
	 */
	public Chariot(Location location, String faction, String type) {
		super(location, faction, type);
	}

	/**
	 *
	 * @param destination
	 * @param board
	 */
	public void move(Location destination, Board board) {
		// TODO - implement Chariot.move
		board.removeChessAt(getLocation());
		this.getLocation().setRow(destination.getRow());
		this.getLocation().setCol(destination.getCol());
		board.setChessAt(this, destination);
	}



	/**
	 * Get All legal positions for Chariot.
	 * Chariot can move to almost every spot on the board when there is no chess blocked his way,
	 * but only in vertical or horizontal direction.
	 * No other rules on killing target chess.
	 * @param board the board the players are playing
	 * @return all possible next locations the chess can move
	 */
	@Override
	public ArrayList<Location> getNextPosition(Board board) {
		ArrayList<Location> locations = new ArrayList<>();
		//前进 towards
		System.out.println(board);
		for (int i = this.getLocation().getRow(); i > 0; i--) {
			System.out.println(i);
			Location new_location = new Location(i - 1, this.getLocation().getCol());
			if (board.getChessAt(new_location).getType() == null){
				locations.add(new_location);
			}
			else if (board.getChessAt(new_location).getType() != null && !board.getChessAt(new_location).getFaction().equalsIgnoreCase(getFaction())){
				locations.add(new_location);
			}
			else{
				System.out.println("jinlaile");
				break;
			}
		}

		//后退 backwards
		for (int i = this.getLocation().getRow(); i < 9; i++) {
			Location new_location = new Location(i + 1, this.getLocation().getCol());
			if (board.getChessAt(new_location).getType() == null){
				locations.add(new_location);
			}

			else if (board.getChessAt(new_location).getType() != null && !board.getChessAt(new_location).getFaction().equalsIgnoreCase(getFaction())){
				locations.add(new_location);
			}
			else{
				break;
			}
		}

		// 向左 Left
		for (int i = this.getLocation().getCol(); i > 0; i--) {
			Location new_location = new Location(this.getLocation().getRow(), i - 1);
			if (board.getChessAt(new_location).getType() == null){
				locations.add(new_location);
			}

			else if (board.getChessAt(new_location).getType() != null && !board.getChessAt(new_location).getFaction().equalsIgnoreCase(getFaction())){
				locations.add(new_location);
			}
			else{
				break;
			}
		}
		// 向右 Right
		for (int i = this.getLocation().getCol(); i < 8; i++) {
			Location new_location = new Location(this.getLocation().getRow(), i + 1);
			if (board.getChessAt(new_location).getType() == null){
				locations.add(new_location);
			}
			else if (board.getChessAt(new_location).getType() != null && !board.getChessAt(new_location).getFaction().equalsIgnoreCase(getFaction())){
				locations.add(new_location);
			}

			else{
				break;
			}
		}

		System.out.println(locations);



		return locations;
	}
}
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
		board.setChessAt(this, destination);
	}

	@Override
	public ArrayList<Location> getNextPosition(Board board) {
		ArrayList<Location> locations = new ArrayList<>();
		//前进 towards
		for (int i = this.getLocation().getRow(); i > 0; i--) {
			Location new_location = new Location(i - 1, this.getLocation().getCol());
			if (board.getChessAt(new_location).getType() == null){
				locations.add(new_location);
			}
			if ((this.getFaction().equalsIgnoreCase("Red") && board.getChessAt(new_location).getFaction().equalsIgnoreCase("Black"))
					||(this.getFaction().equalsIgnoreCase("Black") && board.getChessAt(new_location).getFaction().equalsIgnoreCase("Red"))){
				locations.add(new_location);
			}
			else{
				break;
			}
		}

		//后退 backwards
		for (int i = this.getLocation().getRow(); i < 9; i++) {
			Location new_location = new Location(i + 1, this.getLocation().getCol());
			if (board.getChessAt(new_location).getType() == null){
				locations.add(new_location);
			}

			if ((this.getFaction().equalsIgnoreCase("Red") && board.getChessAt(new_location).getFaction().equalsIgnoreCase("Black"))
					||(this.getFaction().equalsIgnoreCase("Black") && board.getChessAt(new_location).getFaction().equalsIgnoreCase("Red"))){
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

			if ((this.getFaction().equalsIgnoreCase("Red") && board.getChessAt(new_location).getFaction().equalsIgnoreCase("Black"))
					||(this.getFaction().equalsIgnoreCase("Black") && board.getChessAt(new_location).getFaction().equalsIgnoreCase("Red"))){
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
			if ((this.getFaction().equalsIgnoreCase("Red") && board.getChessAt(new_location).getFaction().equalsIgnoreCase("Black"))
					||(this.getFaction().equalsIgnoreCase("Black") && board.getChessAt(new_location).getFaction().equalsIgnoreCase("Red"))){
				locations.add(new_location);
			}

			else{
				break;
			}
		}




		return locations;
	}
}
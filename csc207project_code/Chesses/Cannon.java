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
		board.setChessAt(this, destination);
	}

	@Override
	public ArrayList<Location> getNextPosition(Board board) {
		//前进 towards
		ArrayList<Location> locations = new ArrayList<>();
		for (int i = this.getLocation().getRow(); i > 0; i--) {
			Location new_location = new Location(i - 1, this.getLocation().getCol());
			if (board.getChessAt(new_location).getType() == null){
				locations.add(new_location);
			}
			if ((this.getFaction().equalsIgnoreCase("Red") && board.getChessAt(new_location).getFaction().equalsIgnoreCase("Black"))
					||(this.getFaction().equalsIgnoreCase("Black") && board.getChessAt(new_location).getFaction().equalsIgnoreCase("Red"))){
				for (int j = i + 1; j > 0; j--){
					Location after_location = new Location(j -1, getLocation().getCol());
					if ((this.getFaction().equalsIgnoreCase("Red") && board.getChessAt(after_location).getFaction().equalsIgnoreCase("Black"))
							||(this.getFaction().equalsIgnoreCase("Black") && board.getChessAt(after_location).getFaction().equalsIgnoreCase("Red"))){
						locations.add(after_location);
						break;
					}
				}
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
				for (int j = i - 1; j < 9; j++){
					Location after_location = new Location(j -1, getLocation().getCol());
					if ((this.getFaction().equalsIgnoreCase("Red") && board.getChessAt(after_location).getFaction().equalsIgnoreCase("Black"))
							||(this.getFaction().equalsIgnoreCase("Black") && board.getChessAt(after_location).getFaction().equalsIgnoreCase("Red"))){
						locations.add(after_location);
						break;
					}
				}
			}
		}
		//left
		for (int i = this.getLocation().getCol(); i > 0; i--) {
			Location new_location = new Location(getLocation().getRow(), i - 1);
			if (board.getChessAt(new_location).getType() == null){
				locations.add(new_location);
			}
			if ((this.getFaction().equalsIgnoreCase("Red") && board.getChessAt(new_location).getFaction().equalsIgnoreCase("Black"))
					||(this.getFaction().equalsIgnoreCase("Black") && board.getChessAt(new_location).getFaction().equalsIgnoreCase("Red"))){
				for (int j = i - 1; j > 0; j--){
					Location after_location = new Location(new_location.getRow(), j - 1);
					if ((this.getFaction().equalsIgnoreCase("Red") && board.getChessAt(after_location).getFaction().equalsIgnoreCase("Black"))
							||(this.getFaction().equalsIgnoreCase("Black") && board.getChessAt(after_location).getFaction().equalsIgnoreCase("Red"))){
						locations.add(after_location);
						break;
					}
				}
			}
		}

		for (int i = this.getLocation().getCol(); i < 8; i++) {
			Location new_location = new Location(getLocation().getRow(), i + 1);
			if (board.getChessAt(new_location).getType() == null){
				locations.add(new_location);
			}
			if ((this.getFaction().equalsIgnoreCase("Red") && board.getChessAt(new_location).getFaction().equalsIgnoreCase("Black"))
					||(this.getFaction().equalsIgnoreCase("Black") && board.getChessAt(new_location).getFaction().equalsIgnoreCase("Red"))){
				for (int j = i + 1; j < 8; j++){
					Location after_location = new Location(new_location.getRow(), j + 1);
					if ((this.getFaction().equalsIgnoreCase("Red") && board.getChessAt(after_location).getFaction().equalsIgnoreCase("Black"))
							||(this.getFaction().equalsIgnoreCase("Black") && board.getChessAt(after_location).getFaction().equalsIgnoreCase("Red"))){
						locations.add(after_location);
						break;
					}
				}
			}
		}
		return locations;
	}
}
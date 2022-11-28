package Chesses;
import Model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class General extends Chess implements Moveable, getNextPosition {

	/**
	 * @param location
	 * @param faction
	 * @param type
	 */
	public General(Location location, String faction, String type) {
		super(location, faction, type);
	}

	/**
	 *
	 * @param destination
	 * @param board
	 */
	public void move(Location destination, Board board) {
		// TODO - implement General.move
		board.removeChessAt(getLocation());
		board.setChessAt(this, destination);
	}

	@Override
	public ArrayList<Location> getNextPosition(Board board) {
//		return null;
		ArrayList<Location> locations = new ArrayList<>();
		ArrayList<ArrayList<Integer>> lst_index = new ArrayList<>();
		ArrayList<Integer> move_index1 = new ArrayList<>(Arrays.asList(-1, 0));
		ArrayList<Integer> move_index2 = new ArrayList<>(Arrays.asList(1, 0));
		ArrayList<Integer> move_index3 = new ArrayList<>(Arrays.asList(0, 1));
		ArrayList<Integer> move_index4 = new ArrayList<>(Arrays.asList(0, -1));
		lst_index.add(move_index1);
		lst_index.add(move_index2);
		lst_index.add(move_index3);
		lst_index.add(move_index4);
		for (ArrayList<Integer> move_index: lst_index){
			Location location = new Location(this.getLocation().getRow() + move_index.get(0),
					this.getLocation().getCol() + move_index.get(1));
			if (getFaction().equalsIgnoreCase("red")) {
				if (location.getRow() >= 7 && location.getRow() <= 9 &&
						location.getRow() >= 3 && location.getRow() <= 5
						&& (board.getChessAt(location).getType() == null)){
					locations.add(location);
				}
				if ((board.getChessAt(location).getType().equalsIgnoreCase("Black"))){
					locations.add(location);
				}
			}

			else if (getFaction().equalsIgnoreCase("black")) {
				if (location.getRow() >= 0 && location.getRow() <= 2 &&
						location.getRow() >= 3 && location.getRow() <= 5
						&& (board.getChessAt(location).getType() == null)){
					locations.add(location);
				}
				if ((board.getChessAt(location).getType().equalsIgnoreCase("red"))){
					locations.add(location);
				}
			}
		}

		return locations;



	}
}
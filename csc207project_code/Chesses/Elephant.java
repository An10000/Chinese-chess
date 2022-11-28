package Chesses;
import Model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Elephant extends Chess implements Moveable, getNextPosition {

	/**
	 * @param location
	 * @param faction
	 * @param type
	 */
	public Elephant(Location location, String faction, String type) {
		super(location, faction, type);
	}

	/**
	 *
	 * @param destination
	 * @param board
	 */
	public void move(Location destination, Board board) {
		// TODO - implement Elephant.move
		board.removeChessAt(getLocation());
		board.setChessAt(this, destination);
	}

	@Override
	public ArrayList<Location> getNextPosition(Board board) {
		ArrayList<Location> locations = new ArrayList<>();
		ArrayList<ArrayList<Integer>> lst_index = new ArrayList<>();
		ArrayList<Integer> move_index1 = new ArrayList<>(Arrays.asList(-2, -2));
		ArrayList<Integer> move_index2 = new ArrayList<>(Arrays.asList(-2, 2));
		ArrayList<Integer> move_index3 = new ArrayList<>(Arrays.asList(2, -2));
		ArrayList<Integer> move_index4 = new ArrayList<>(Arrays.asList(2, 2));
		lst_index.add(move_index1);
		lst_index.add(move_index2);
		lst_index.add(move_index3);
		lst_index.add(move_index4);
		if (getFaction().equalsIgnoreCase("red")) {
			for (ArrayList<Integer> moveindex : lst_index) {
				Location new_location = new Location(getLocation().getRow() + moveindex.get(0),
						getLocation().getCol() + moveindex.get(1));
				if (new_location.getRow() >= 5
						&& new_location.getRow() <= 9
						&& new_location.getCol() >= 0
						&& new_location.getCol() <= 8
						&& board.getChessAt(new_location).getType() == null) {
					Location after_location = new Location(getLocation().getRow() - 1, getLocation().getCol() - 1);
					if (moveindex.get(0) == -2
							&& moveindex.get(1) == -2
							&& board.getChessAt(after_location).getType() == null
							&& board.getChessAt(new_location).getFaction().equalsIgnoreCase("Black")){
						locations.add(new_location);
					}

					after_location = new Location(getLocation().getRow() - 1, getLocation().getCol() + 1);
					if (moveindex.get(0) == -2
							&& moveindex.get(1) == 2
							&& board.getChessAt(after_location).getType() == null
							&& board.getChessAt(new_location).getFaction().equalsIgnoreCase("Black")){
						locations.add(new_location);
					}

					after_location = new Location(getLocation().getRow() + 1, getLocation().getCol() - 1);
					if (moveindex.get(0) == 2
							&& moveindex.get(1) == -2
							&& board.getChessAt(after_location).getType() == null
							&& board.getChessAt(new_location).getFaction().equalsIgnoreCase("Black")){
						locations.add(new_location);
					}

					after_location = new Location(getLocation().getRow() + 1, getLocation().getCol() + 1);
					if (moveindex.get(0) == 2
							&& moveindex.get(1) == 2
							&& board.getChessAt(after_location).getType() == null
							&& board.getChessAt(new_location).getFaction().equalsIgnoreCase("Black")){
						locations.add(new_location);
					}
				}
			}
		}

		if (getFaction().equalsIgnoreCase("black")) {
			for (ArrayList<Integer> moveindex : lst_index) {
				Location new_location = new Location(getLocation().getRow() + moveindex.get(0),
						getLocation().getCol() + moveindex.get(1));
				if (new_location.getRow() >= 5
						&& new_location.getRow() <= 9
						&& new_location.getCol() >= 0
						&& new_location.getCol() <= 8
						&& board.getChessAt(new_location).getType() == null) {
					Location after_location = new Location(getLocation().getRow() - 1, getLocation().getCol() - 1);
					if (moveindex.get(0) == -2
							&& moveindex.get(1) == -2
							&& board.getChessAt(after_location).getType() == null
							&& board.getChessAt(new_location).getFaction().equalsIgnoreCase("red")){
						locations.add(new_location);
					}

					after_location = new Location(getLocation().getRow() - 1, getLocation().getCol() + 1);
					if (moveindex.get(0) == -2
							&& moveindex.get(1) == 2
							&& board.getChessAt(after_location).getType() == null
							&& board.getChessAt(new_location).getFaction().equalsIgnoreCase("red")){
						locations.add(new_location);
					}

					after_location = new Location(getLocation().getRow() + 1, getLocation().getCol() - 1);
					if (moveindex.get(0) == 2
							&& moveindex.get(1) == -2
							&& board.getChessAt(after_location).getType() == null
							&& board.getChessAt(new_location).getFaction().equalsIgnoreCase("red")){
						locations.add(new_location);
					}

					after_location = new Location(getLocation().getRow() + 1, getLocation().getCol() + 1);
					if (moveindex.get(0) == 2
							&& moveindex.get(1) == 2
							&& board.getChessAt(after_location).getType() == null
							&& board.getChessAt(new_location).getFaction().equalsIgnoreCase("red")){
						locations.add(new_location);
					}
				}
			}
		}


		return locations;


	}
}
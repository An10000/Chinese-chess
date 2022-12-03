package Chesses;
import Model.*;

import java.util.ArrayList;
import java.util.Arrays;

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
		board.removeChessAt(getLocation());
		this.getLocation().setRow(destination.getRow());
		this.getLocation().setCol(destination.getCol());
		board.setChessAt(this, destination);
	}



	/**
	 * Get All legal positions for Horse
	 * Pretty much like Elephant, but it can move any spot in the board.
	 * However, it moves within a 2 x 1 area like 日.
	 * For example, if Horse what to move from left bottom to top right in 日,
	 * there should no other chess block in **front** of Horse.
	 * Same rule when you rotate 日 90 degree, no other chess block in **front** of Horse between target chess and itself.
	 * @param board the board the players are playing
	 * @return all possible next locations the chess can move
	 */
	@Override
	public ArrayList<Location> getNextPosition(Board board) {
		ArrayList<Location> locations = new ArrayList<>();
		ArrayList<ArrayList<Integer>> lst_index = new ArrayList<>();
		ArrayList<Integer> move_index1 = new ArrayList<>(Arrays.asList(2, 1));
		ArrayList<Integer> move_index2 = new ArrayList<>(Arrays.asList(2, -1));
		ArrayList<Integer> move_index3 = new ArrayList<>(Arrays.asList(-2, 1));
		ArrayList<Integer> move_index4 = new ArrayList<>(Arrays.asList(-2, -1));
		ArrayList<Integer> move_index5 = new ArrayList<>(Arrays.asList(1, 2));
		ArrayList<Integer> move_index6 = new ArrayList<>(Arrays.asList(-1, 2));
		ArrayList<Integer> move_index7 = new ArrayList<>(Arrays.asList(1, -2));
		ArrayList<Integer> move_index8 = new ArrayList<>(Arrays.asList(-1, -2));
		lst_index.add(move_index1);
		lst_index.add(move_index2);
		lst_index.add(move_index3);
		lst_index.add(move_index4);
		lst_index.add(move_index5);
		lst_index.add(move_index6);
		lst_index.add(move_index7);
		lst_index.add(move_index8);

		for (ArrayList<Integer> moveindex: lst_index) {

			//new location
			Location new_location = new Location(
					getLocation().getRow() + moveindex.get(0),
					getLocation().getCol() + moveindex.get(1));
			if (new_location.getRow() <= 9
					&& new_location.getRow() >= 0
					&& new_location.getCol() <= 8
					&& new_location.getCol() >= 0
					&& board.getChessAt(new_location).getType() == null) {
				//Forward
				if (moveindex.get(0) == -2 && (moveindex.get(1) == 1 || moveindex.get(1) == -1)){
					Location bad_location = new Location(getLocation().getRow() - 1, getLocation().getCol());
					if (board.getChessAt(bad_location).getType() == null){
						locations.add(new_location);
					}
				}
				//Backward
				if (moveindex.get(0) == 2 && (moveindex.get(1) == 1 || moveindex.get(1) == -1)){
					Location bad_location = new Location(getLocation().getRow() + 1, getLocation().getCol());
					if (board.getChessAt(bad_location).getType() == null){
						locations.add(new_location);
					}
				}
				//left
				if (moveindex.get(1) == -2 && (moveindex.get(0) == 1 || moveindex.get(0) == -1)){
					Location bad_location = new Location(getLocation().getRow(), getLocation().getCol() - 1);
					if (board.getChessAt(bad_location).getType() == null){
						locations.add(new_location);
					}
				}
				//right
				if (moveindex.get(1) == 2 && (moveindex.get(0) == 1 || moveindex.get(0) == -1)){
					Location bad_location = new Location(getLocation().getRow(), getLocation().getCol() + 1);
					if (board.getChessAt(bad_location).getType() == null){
						locations.add(new_location);
					}
				}

			}
			if (new_location.getRow() <= 9
					&& new_location.getRow() >= 0
					&& new_location.getCol() <= 8
					&& new_location.getCol() >= 0
					&& board.getChessAt(new_location).getType() != null
					&& !(board.getChessAt(new_location).getFaction().equalsIgnoreCase(getFaction()))){
				locations.add(new_location);
			}

		}

		return locations;


	}
}
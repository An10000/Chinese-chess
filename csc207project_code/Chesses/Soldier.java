package Chesses;
import Model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Soldier extends Chess implements Moveable, getNextPosition {

	/**
	 * Initializer of Soldier. The same as normal chess.
	 * @param location location of soldier
	 * @param faction faction of soldier
	 * @param type type: "Soldier"
	 */
	public Soldier(Location location, String faction, String type) {
		super(location, faction, type);
	}

	/**
	 * Move the chess to destination location on the board.
	 * Soldiers can only move forward one step in the beginning, after crossing the river, they can move left or right one step as well.
	 * @param destination the destination, the chess moves there.
	 * @param board the board we are moving on.
	 */
	public void move(Location destination, Board board) {
		Location oldLocation = this.getLocation();
		board.setChessAt(this, destination);
		board.setChessAt(new NullChess(oldLocation, null, null), oldLocation);
	}

	/**
	 * Return all possible next locations the chess can move.
	 * @param board the Board we are looking at
	 * @return all possible next locations the chess can move
	 */
	@Override
	public ArrayList<Location> getNextPosition(Board board) {
		ArrayList<Location> locations = new ArrayList<>();
		if (this.getFaction().equalsIgnoreCase("Red")) {
			ArrayList<ArrayList<Integer>> lst_index = new ArrayList<>();
			ArrayList<Integer> move_index1 = new ArrayList<>(Arrays.asList(-1, 0));
			ArrayList<Integer> move_index2 = new ArrayList<>(Arrays.asList(0, 1));
			ArrayList<Integer> move_index3 = new ArrayList<>(Arrays.asList(0, -1));
			lst_index.add(move_index1);
			lst_index.add(move_index2);
			lst_index.add(move_index3);
			for (ArrayList<Integer> move_index: lst_index){
				int row = move_index.get(0) + this.getLocation().getRow();
				int col = move_index.get(1) + this.getLocation().getCol();
				if (row < 0 || col < 0){
					continue;
				}
				else if (row >= 10|| col >= 9){
					continue;
				}
				Location location = new Location(row, col);
				if (this.getLocation().getRow() > 4){
					if (board.getChessAt(location).getFaction() == null){
						locations.add(location);
					}
					else if (board.getChessAt(location).getFaction().equalsIgnoreCase("black")){
						locations.add(location);
					}
					break;
				}
				else if(this.getLocation().getRow() <= 4){
					if (board.getChessAt(location).getFaction() == null){
						locations.add(location);
					}
					else if (board.getChessAt(location).getFaction().equalsIgnoreCase("black")){
						locations.add(location);
					}
				}
			}
		}
		else if (this.getFaction().equalsIgnoreCase("black")) {
			ArrayList<ArrayList<Integer>> lst_index = new ArrayList<>();
			ArrayList<Integer> move_index1 = new ArrayList<>(Arrays.asList(1, 0));
			ArrayList<Integer> move_index2 = new ArrayList<>(Arrays.asList(0, 1));
			ArrayList<Integer> move_index3 = new ArrayList<>(Arrays.asList(0, -1));
			lst_index.add(move_index1);
			lst_index.add(move_index2);
			lst_index.add(move_index3);
			for (ArrayList<Integer> move_index: lst_index){
				int row = move_index.get(0) + this.getLocation().getRow();
				int col = move_index.get(1) + this.getLocation().getCol();
				if (row < 0 || col < 0){
					continue;
				}
				else if (row >= 10|| col >= 9){
					continue;
				}
				Location location = new Location(row, col);
				if (this.getLocation().getRow() < 5){
					if (board.getChessAt(location).getFaction() == null){
						locations.add(location);
					}
					else if (board.getChessAt(location).getFaction().equalsIgnoreCase("red")){
						locations.add(location);
					}
					break;
				}

				else if(this.getLocation().getRow() >= 5){
					if (board.getChessAt(location).getFaction() == null){
						locations.add(location);
					}
					else if (board.getChessAt(location).getFaction().equalsIgnoreCase("red")){
						locations.add(location);
					}
				}
			}
		}
		return locations;
	}
}
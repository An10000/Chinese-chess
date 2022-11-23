package Chesses;
import Model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Soldier extends Chess implements Moveable, getNextPosition {

	/**
	 * @param location
	 * @param faction
	 * @param type
	 */
	public Soldier(Location location, String faction, String type) {
		super(location, faction, type);
	}

	/**
	 * 
	 * @param destination
	 * @param board
	 */
	public void move(Location destination, Board board) {
		// TODO - implement Soldier.move
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Location> getNextPosition(Board board) {
		ArrayList<Location> locations = new ArrayList<>();
		if (this.getType().equalsIgnoreCase("red")) {
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
				Location location = new Location(row, col);
				if (this.getLocation().getRow() > 4){
					if (board.getChessAt(location).getFaction().equalsIgnoreCase("red")){
						locations.add(location);
					}
					break;
				}
				else if(this.getLocation().getRow() <= 4){
					if (board.getChessAt(location).getFaction().equalsIgnoreCase("red")){
						locations.add(location);
					}
				}
			}
		}
		else if (this.getType().equalsIgnoreCase("black")) {
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
				Location location = new Location(row, col);
				if (this.getLocation().getRow() < 5){
					if (board.getChessAt(location).getFaction().equalsIgnoreCase("Black")){
						locations.add(location);
					}
					break;
				}

				else if(this.getLocation().getRow() >= 5){
					if (board.getChessAt(location).getFaction().equalsIgnoreCase("Black")){
						locations.add(location);
					}
				}
			}
		}
		return locations;
	}
}
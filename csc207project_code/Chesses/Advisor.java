package Chesses;
import Model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Advisor extends Chess implements Moveable, getNextPosition{

	public Advisor(Location location, String faction, String type) {
		// TODO - implement Chess.Chess
//		throw new UnsupportedOperationException();
		super(location, faction, type);
	}
	/**
	 *
	 * @param destination
	 * @param board
	 */
	public void move(Location destination, Board board) {
		// TODO - implement Advisor.move
		board.removeChessAt(getLocation());
		board.setChessAt(this, destination);
	}





	@Override
	public ArrayList<Location> getNextPosition(Board board) {
		ArrayList<Location> locations = new ArrayList<>();
		ArrayList<ArrayList<Integer>> lst_index = new ArrayList<>();
		ArrayList<Integer> move_index1 = new ArrayList<>(Arrays.asList(-1, -1));
		ArrayList<Integer> move_index2 = new ArrayList<>(Arrays.asList(-1, 1));
		ArrayList<Integer> move_index3 = new ArrayList<>(Arrays.asList(1, -1));
		ArrayList<Integer> move_index4 = new ArrayList<>(Arrays.asList(1, 1));
		lst_index.add(move_index1);
		lst_index.add(move_index2);
		lst_index.add(move_index3);
		lst_index.add(move_index4);
		for (ArrayList<Integer> move_index: lst_index){
			if (getFaction().equalsIgnoreCase("red")) {
				Location location = new Location(this.getLocation().getRow() + move_index.get(0)
						, this.getLocation().getCol() + move_index.get(1));
				System.out.println(location);
				if ((this.getLocation().getRow() + move_index.get(0) <= 9
						&& this.getLocation().getRow() + move_index.get(0) >= 8
						&& this.getLocation().getCol() + move_index.get(1) >= 3
						&& this.getLocation().getCol() + move_index.get(1) <= 5)
						&& ( board.getChessAt(location).getFaction() == null
								||board.getChessAt(location).getFaction().equalsIgnoreCase("Black"))) {

					locations.add(location);
				}
			}

			else if (getFaction().equalsIgnoreCase("Black")) {
				Location location = new Location(this.getLocation().getRow() + move_index.get(0)
						, this.getLocation().getCol() + move_index.get(1));
				if (this.getLocation().getRow() + move_index.get(0) <= 2
						&& this.getLocation().getRow() + move_index.get(0) >= 0
						&& this.getLocation().getCol() + move_index.get(1) >= 3
						&& this.getLocation().getCol() + move_index.get(1) <= 5
						&& ( board.getChessAt(location).getFaction() == null
						||board.getChessAt(location).getFaction().equalsIgnoreCase("Red"))) {
					locations.add(location);
				}
			}
		}
		return locations;
	}
}
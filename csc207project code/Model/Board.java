package Model;

public class Board {

	private Chess[][] chessList;
	private static Board board;

	public boolean checkMate() {
		// TODO - implement Board.checkMate
		throw new UnsupportedOperationException();
	}

	public Chess[][] getChessList() {
		return this.chessList;
	}

	/**
	 * 
	 * @param chess
	 * @param location
	 */
	public void setChessAt(Chess chess, Location location) {
		// TODO - implement Board.setChessAt
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param location
	 */
	public Chess getChessAt(Location location) {
		// TODO - implement Board.getChessAt
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param location
	 */
	public void removeChessAt(Location location) {
		// TODO - implement Board.removeChessAt
		throw new UnsupportedOperationException();
	}

	public static Board getInstance() {
		// TODO - implement Board.getInstance
		throw new UnsupportedOperationException();
	}

	private Board() {
		// TODO - implement Board.Board
		throw new UnsupportedOperationException();
	}

}
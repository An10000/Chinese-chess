package Model;

public class Location {

	private int row;
	private int col;

	/**
	 * 
	 * @param row
	 * @param col
	 */
	public Location(int row, int col) {
		// TODO - implement Location.Location
		this.row = row;
		this.col = col;
		// throw new UnsupportedOperationException();
	}

	public int getRow() {
		return this.row;
	}

	/**
	 * 
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return this.col;
	}

	/**
	 * 
	 * @param col
	 */
	public void setCol(int col) {
		this.col = col;
	}

}
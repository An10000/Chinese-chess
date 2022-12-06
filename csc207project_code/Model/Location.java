package Model;

public class Location {

	private int row;
	private int col;

	/**
	 * Create a Location object by the given row number and col number.
	 * @param row  An integer that represent the row;
	 * @param col  An integer that represent the col;
	 */
	public Location(int row, int col) {
		// TODO - implement Location.Location
		this.row = row;
		this.col = col;
		// throw new UnsupportedOperationException();
	}

	/**
	 * Create a Location object by String input. e.g. "0,0"
	 * @param location  A location coordinate that represents in string.
	 */
	public Location(String location) {
		String[] loc = location.split(",");
		this.row = Integer.parseInt(loc[0]);
		this.col = Integer.parseInt(loc[1]);
	}

	/**
	 * Return the row number that stored in this Location.
	 * @return  int
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * Set the given number as the new row number of the Location.
	 * @param row  An integer that represents row number of the Location
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Return the row number that stored in this Location.
	 * @return  int
	 */
	public int getCol() {
		return this.col;
	}

	/**
	 * Set the given number as the new column number of the Location.
	 * @param col  An integer that represents column number of the Location
	 */
	public void setCol(int col) {
		this.col = col;
	}


	/**
	 * Return a location by string representation.
	 * @return String
	 */
	public String toString(){
		return "(" + getRow() + ", " + getCol() + ")"; // print location
	}

	/**
	 * Return true if two Locations are equal.
	 * @param obj  Object that is compared
	 * @return  boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;}
		if (!(obj instanceof Location)){
			return false;
		}
		Location other = (Location) obj;
		if (this.row == other.row && this.col == other.col){
			return true;
		}
		return false;

	}
}
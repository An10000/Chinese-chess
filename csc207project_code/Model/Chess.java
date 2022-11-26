package Model;

import java.util.ArrayList;

public abstract class Chess {

	private Location location;
	private String faction;
	private boolean alive;
	private String type;

	/**
	 * @param location
	 * @param faction
	 * @param type
	 */
	public Chess(Location location, String faction, String type) {
		// TODO - implement Chess.Chess
//		throw new UnsupportedOperationException();
		this.location = location;
		this.faction = faction;
		this.type = type;
	}

	public void kill(Chess chess) {
		// TODO - implement Chess.kill
//		throw new UnsupportedOperationException();
		int new_col = chess.location.getCol();
		int new_row = chess.location.getRow();
		this.location.setCol(new_col);
		this.location.setRow(new_row);
		chess.alive = false;
	}

	public String getType() {
		return this.type;
	}

	public String getFaction(){ return this.faction;}

	public Location getLocation() {
		return this.location;
	}
}
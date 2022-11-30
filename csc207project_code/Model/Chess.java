package Model;

import Chesses.NullChess;

public abstract class Chess implements Moveable, getNextPosition{



	private Location location;// location of the chess
	private String faction;//faction of the chess
	private boolean alive;// if the chess is alive
	private String type;// what is the chess? type of chess

	/**
	 * Initializes the chess, so the chess has
	 * location, faction and type.
	 * @param location location on the board
	 * @param faction faction of the chess, which "side" does the chess stand.
	 * @param type the type of chess.
	 */
	public Chess(Location location, String faction, String type) {
		this.location = location;
		this.faction = faction;
		this.type = type;
		this.alive = true;
	}

	/**
	 * Kill the chess, and move to chess's position
	 * @param chess the chess to be killed
	 */
	public void kill(Chess chess) {
		Board board = Board.getInstance();
		Location oldLocation = this.location;
		Location newLocation = chess.location;
		board.setChessAt(this, newLocation);
		board.setChessAt(new NullChess(oldLocation, null, null), oldLocation);
		chess.alive = false;
	}

	/**
	 * getter method for type
	 * @return the type of the chess
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * getter method for faction
	 * @return the faction of the chess
	 */
	public String getFaction(){ return this.faction;}
	/**
	 * getter method for location
	 * @return the location of the chess
	 */
	public Location getLocation() {
		return this.location;
	}
	/**
	 * setter method for location
	 * @param location the location to be set on
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
}
package Model;

public abstract class Chess {

	private Location location;
	private String faction;
	private boolean alive;
	private String type;
	public Chess(){
		System.out.println("chess initialized");
	}

	public void kill() {
		// TODO - implement Chess.kill
		throw new UnsupportedOperationException();
	}

	public String getType() {
		return this.type;
	}

	/**
	 * 
	 * @param Location
	 * @param faction
	 * @param type
	 */
	public Chess(Location Location, String faction, String type) {
		// TODO - implement Chess.Chess
		throw new UnsupportedOperationException();
	}

	public Location[] getNextPosition() {
		// TODO - implement Chess.getNextPosition
		throw new UnsupportedOperationException();
	}

}
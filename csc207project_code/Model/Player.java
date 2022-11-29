package Model;

public class Player {

	private String faction;// the faction for the player

	/**
	 * Constructor of Player. A player has a faction.
	 * @param faction the faction of the player
	 */
	public Player(String faction){
		this.faction = faction;
	}

	/**
	 * getter method for faction of the player
	 * @return faction of player
	 */
	public String getFaction() {
		return this.faction;
	}

}
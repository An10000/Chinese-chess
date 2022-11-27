package Control;

import Model.*;

import java.util.HashMap;
import java.util.Objects;

public class Scorer {

	private HashMap<String, Integer> scoreBoard; // scoreBoard that stores score for both factions.

	/**
	 * Initializer of Scorer. Called at the beginning of Scored Mode game.
	 * Initializes the scoreBoard, and put the score for "Red" and "Black" faction 0.
	 */
	public Scorer(){
		this.scoreBoard = new HashMap<>();
		scoreBoard.put("Red", 0);
		scoreBoard.put("Black", 0);
	}

	/**
	 * return the score of current faction.
	 * if faction == Red then return score of the Red faction
	 * if faction == Black then return score of the Black faction
	 * @param faction The faction of interest, either "Red" or "Black", in String format.
	 */
	public int getFactionScore(String faction) {
		return scoreBoard.get(faction);
//		throw new UnsupportedOperationException();

	}

	/**
	 * add score to faction when a chess of the opposite faction is killed.
	 *
	 * @param killed the chess being killed.
	 */
	public void addScore(Chess killed) {
		if (Objects.equals(killed.getFaction(), "Black")){//if the chess is Black
			int originalScore = scoreBoard.get("Red");
			if (!Objects.equals(killed.getType(), "General")){
				scoreBoard.put("Red", originalScore + 1);//add 1 to Red
			} else{
				scoreBoard.put("Red", originalScore + 10);//add 10 to Red
			}
		} else if (Objects.equals(killed.getFaction(), "Red")) {//if the chess is Red
			int originalScore = scoreBoard.get("Black");
			if (!Objects.equals(killed.getType(), "General")){
				scoreBoard.put("Black", originalScore + 1);//add 1 to Black
			} else{
				scoreBoard.put("Black", originalScore + 10);//add 10 to Black
			}
		} else{
			throw new RuntimeException("faction is not Black nor Red!");// we cannot recognize the faction!
		}
		// throw new UnsupportedOperationException();
	}

}
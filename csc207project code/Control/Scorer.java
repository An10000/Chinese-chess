package Control;

import Model.*;
import View.Viewer;

import java.util.HashMap;

public class Scorer {

	private HashMap<String, Integer> scoreBoard;
	public Scorer(){
		this.scoreBoard = new HashMap<>();
	}

	/**
	 * 
	 * @param faction
	 */
	public int getFactionScore(String faction) {
		// TODO - implement Scorer.getFactionScore
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param faction
	 * @param killed
	 */
	public void addScore(String faction, Chess killed) {
		// TODO - implement Scorer.addScore
		throw new UnsupportedOperationException();
	}

}
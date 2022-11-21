package View;

import Model.*;
import Control.*;

public class Viewer {

	private String mode;
	private int time;
	private Controller controller;
	private String round;

	/**
	 * 
	 * @param mode
	 * @param board
	 */
	public Viewer(String mode, Board board) {
		// TODO - implement Viewer.Viewer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param mode
	 * @param board
	 * @param time
	 */
	public Viewer(String mode, Board board, int time) {
		// TODO - implement Viewer.Viewer
		throw new UnsupportedOperationException();
	}

	public void refresh() {
		// TODO - implement Viewer.refresh
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param scorer
	 */
	public void report(Scorer scorer) {
		// TODO - implement Viewer.report
		throw new UnsupportedOperationException();
	}

	public void report() {
		// TODO - implement Viewer.report
		throw new UnsupportedOperationException();
	}

	public void nextRound() {
		// TODO - implement Viewer.nextRound
		throw new UnsupportedOperationException();
	}

	public String getRound() {
		return this.round;
	}

	/**
	 * 
	 * @param timer
	 */
	public void drawTimer(Timer timer) {
		// TODO - implement Viewer.drawTimer
		throw new UnsupportedOperationException();
	}

}
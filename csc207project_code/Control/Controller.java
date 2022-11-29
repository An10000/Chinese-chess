package Control;

import Chesses.NullChess;
import Model.*;
import View.*;

import java.util.ArrayList;
import java.util.Objects;

public class Controller {

	private Board board;
	private Player[] players;
	private String mode;
	private Scorer scorer;

	/**
	 *
	 */
	private ArrayList<Location> clicks;

	public static final int OK = 0;
	public static final int MOVED = 1;
	public static final int INVALID = 2;
	/**
	 * request a move of a chess.
	 * if the chess can move to the destination,
	 * then move and kill the chess on that location(even null chess) return the chess being killed
	 * if not then return null.
	 * @param chess the chess of interest
	 * @param destination the target location
	 */
	public Chess moveRequest(Chess chess, Location destination) {
		ArrayList<Location> nextLoctions = chess.getNextPosition(board);
		if (nextLoctions.contains(destination)){
			Chess killedChess = board.getChessAt(destination);
			if (killedChess.getType() == null){
				chess.move(destination, board);
				return killedChess;
			}
			else{
				chess.kill(killedChess);
				return killedChess;
			}

		}else{
			return null;
		}
//		throw new UnsupportedOperationException();
	}

	/**
	 * handle a new click from the user.
	 * A user have to first click on a chess on his own faction, then click on a place the chess can go.
	 * if the click is on his own chess, then it is OK;
	 * if the click is on an empty space or an enemy chess, then
	 *     if he has already clicked on one of his own chesses, try if the movement is possible by calling moveRequest
	 *     if not, it is INVALID
	 * if the click is not on any chess, then INVALID
	 * @param location The location the user clicked
	 * @param faction The faction the user is currently at
	 * @return the type of the click, by int constant
	 */
	public int addClick(Location location, String faction){
		if (board.getChessList()[location.getRow()][location.getCol()].getFaction() == faction){
			clicks.clear();
			clicks.add(location);
			return OK;
		}
		else if (board.getChessList()[location.getRow()][location.getCol()].getFaction() == null || !Objects.equals(board.getChessList()[location.getRow()][location.getCol()].getFaction(), faction)){
			if (clicks.size() <= 1){//if not clicked previously
				clicks.clear();
				return INVALID;
			}
			else{
				Chess killed = moveRequest(board.getChessList()[clicks.get(1).getRow()][clicks.get(1).getCol()], clicks.get(0));
				if (mode == "Scored Mode" && killed != null){
					if (killed.getType() != "NullChess"){
						scorer.addScore(killed);
					}
				}
				else if (killed == null){
					return INVALID;
				}
				clicks.clear();
				return MOVED;
			}
		}
		else{
			clicks.clear();
			return INVALID;
		}
	}

	/**
	 * The initializer of controller,
	 * @param board the board the players are playing
	 * @param players the players of the game
	 * @param mode mode of the game
	 * @param scorer add scorer to the controller
	 */
	public Controller(Board board, Player[] players, String mode, Scorer scorer) {
		this.board = board;
		this.players = players;
		this.mode = mode;
		if (scorer != null){
			this.scorer = scorer;
		}
		else if (Objects.equals(mode, "Scored Mode")){
			throw new RuntimeException("scorer is not defined! ");
		}
		clicks = new ArrayList<>();
	}

	/**
	 * getter method for clicks
	 * @return clicks stored
	 */
	public ArrayList<Location> getClicks() {
		return clicks;
	}

}
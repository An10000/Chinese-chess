package Control;

import Chesses.NullChess;
import Model.*;
import View.*;

import java.util.ArrayList;
import java.util.Objects;

public class Controller {

	private Board board;// the board in the game.
	private Player[] players;//players of the game
	private String mode;//mode of the game
	private Scorer scorer;// Scorer of the game if it is "Scored Mode". Null otherwise.
	private ArrayList<Location> clicks;//record the clicks received.

	private boolean checkMate;

	public static final int OK = 0;//it is one of the chess of our faction, it is "ok" to click that
	public static final int MOVED = 1;//the chess has been moved. Now it is the opposite's turn!
	public static final int INVALID = 2;//It is not your chess/it is a NullChess! You can't do that, please click again.
	public static final int GAMEEND = 3;// Game ends! one of General is killed

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
//		System.out.println(nextLoctions);
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
	 *     if it killed general or get more than 10 in scored mode, then GAMEEND
	 * if the click is not on any chess, then INVALID
	 * @param location The location the user clicked
	 * @param faction The faction the user is currently at
	 * @return the type of the click, by int constant
	 */
	public int addClick(Location location, String faction){
		if (board.getChessList()[location.getRow()][location.getCol()].getFaction() == faction){
//			System.out.println(board.getChessList()[location.getRow()][location.getCol()]);
//			System.out.println(location);
//			System.out.println(faction);
			clicks.clear();
			clicks.add(location);
//			System.out.println("clicks: "+ clicks);
//			System.out.println("selected");
//			System.out.println(board);
			return OK;
		}
		else if (board.getChessList()[location.getRow()][location.getCol()].getFaction() == null || !Objects.equals(board.getChessList()[location.getRow()][location.getCol()].getFaction(), faction)){
			if (clicks.size() < 1){//if not clicked previously
				clicks.clear();
//				System.out.println("Invalid1");
//				System.out.println(board);
				return INVALID;
			}
			else{
				Chess killed = moveRequest(board.getChessList()[clicks.get(0).getRow()][clicks.get(0).getCol()], location);
				if (Objects.equals(mode, "Scored Mode") && killed != null){
					if (killed.getType() != null){
						scorer.addScore(killed);
						if (scorer.getFactionScore("Red") >= 10||scorer.getFactionScore("Black") >= 10){
//							System.out.println("gameend!");
//							System.out.println(board);
							return GAMEEND;
						}
					}
				}
				else if (killed == null){
					clicks.clear();
//					System.out.println("Invalid2");
//					System.out.println(board);
					return INVALID;
				}
				else if (Objects.equals(killed.getType(), "General")){
					if (!Objects.equals(mode, "Scored Mode")){
//						System.out.println(board);
						return GAMEEND;
					}
				}
				clicks.clear();
//				System.out.println("moved");
				checkMate = board.checkMate();
//				System.out.println(checkMate);
//				System.out.println(board);
				return MOVED;
			}
		}
		else{
			clicks.clear();
//			System.out.println("Invalid3");
//			System.out.println(board);
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
		this.checkMate = false;
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

	/**
	 * getter for checkmate. Get the status: if the game has checkmate?
	 * @return checkMate
	 */
	public boolean isCheckMate() {
		return checkMate;
	}

}
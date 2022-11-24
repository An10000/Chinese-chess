package Model;
import Chesses.NullChess;

import java.util.Arrays;

public class Board {

	private Chess[][] chessList;
	private static Board board;
	private int height = 10;
	private int width = 9;

	public boolean checkMate() {
		// TODO - implement Board.checkMate
		throw new UnsupportedOperationException();
	}

	public Chess[][] getChessList() {
		return this.chessList;
	}

	/**
	 * 
	 * @param chess
	 * @param location
	 */
	public void setChessAt(Chess chess, Location location) {
		// TODO - implement Board.setChessAt
		throw new UnsupportedOperationException();
	}
	/**
	 * 
	 * @param location
	 */
	public Chess getChessAt(Location location) {
		// TODO - implement Board.getChessAt
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param location
	 */
	public void removeChessAt(Location location) {
		// TODO - implement Board.removeChessAt
		throw new UnsupportedOperationException();
	}

	public static Board getInstance() {
		// TODO - implement Board.getInstance
		if (Board.board == null){
			Board.board = new Board();
			return Board.board;
		}
		else{
			return Board.board;
		}
		//throw new UnsupportedOperationException();
	}

	private Board() {
		// TODO - implement Board.Board
//		throw new UnsupportedOperationException();
		chessList = new Chess[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Location location = new Location(i, j);
				chessList[i][j] = new Chesses.NullChess(location, null, null);
			}
		}
	}


	public void setChess(Chess chess, Location location){
		int col = location.getCol();
		int row = location.getRow();
		chessList[row][col] = chess;
	}
	public int getheight(){
		return this.height;
	}



	public int getwidth(){
		return this.width;
	}
	public String toString(){
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < height; i++){
			for (int j = 0; j < width; j++){
				ans.append("(").append(chessList[i][j].getFaction()).append(" ").append(chessList[i][j].getType()).append(")");
			}
			ans.append("\n");
		}
		return ans.toString();
	}
}
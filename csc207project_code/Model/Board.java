package Model;
import Chesses.NullChess;

import java.util.Arrays;

public class Board {

	private Chess[][] chessList;
	private static Board board;
	private int height = 10;
	private int width = 9;

	public boolean checkMate() {
		for (Chess[] chessrow: chessList){
			for (Chess chess: chessrow){
				for (Location location: chess.getNextPosition(this)){
					if (this.getChessAt(location).getType().equals("General")){
						if (!this.getChessAt(location).getFaction().equals(chess.getFaction())){
							return true;
						}
					}
				}
			}
		}
		return false;
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
		int col = location.getCol();
		int row = location.getRow();
		chessList[row][col] = chess;
	}
	/**
	 * 
	 * @param location
	 */
	public Chess getChessAt(Location location) {
		int col = location.getCol();
		int row = location.getRow();
		return chessList[row][col];
	}

	/**
	 * 
	 * @param location
	 */
	public void removeChessAt(Location location) {
		int col = location.getCol();
		int row = location.getRow();
		Chess oldChess = chessList[row][col];
		chessList[row][col] = new NullChess(location, oldChess.getFaction(),oldChess.getType());
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
				String stringToAdd = "";
				stringToAdd = "(" + chessList[i][j].getFaction() + " " + chessList[i][j].getType() + ")";
				while (stringToAdd.length() < 17){
					stringToAdd += " ";
				}
				ans.append(stringToAdd);
			}
			ans.append("\n");
		}
		return ans.toString();
	}
}
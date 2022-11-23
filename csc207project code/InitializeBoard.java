import Model.*;
import Chesses.*;

public class InitializeBoard {

	private Board board;

	public InitializeBoard() {
		// TODO - implement InitializeBoard.InitializeBoard
//		throw new UnsupportedOperationException();
		Advisor red_advisor1 = new Advisor(new Location(9, 3), "Red", "Advisor");
		Advisor red_advisor2 = new Advisor(new Location(9, 5), "Red", "Advisor");
		Advisor black_advisor1 = new Advisor(new Location(0, 5), "Black", "Advisor");
		Advisor black_advisor2 = new Advisor(new Location(0, 3), "Black", "Advisor");

		Cannon red_cannon1 = new Cannon(new Location(7, 1), "Red", "Cannon");
		Cannon red_cannon2 = new Cannon(new Location(7, 7), "Red", "Cannon");
		Cannon black_cannon1 = new Cannon(new Location(2, 7), "Black", "Cannon");
		Cannon black_cannon2 = new Cannon(new Location(2, 1), "Black", "Cannon");

		Chariot red_chariot1 = new Chariot(new Location(9, 0), "Red", "Chariot");
		Chariot red_chariot2 = new Chariot(new Location(9, 8), "Red", "Chariot");
		Chariot black_chariot1 = new Chariot(new Location(0, 8), "Black", "Chariot");
		Chariot black_chariot2 = new Chariot(new Location(0, 0), "Black", "Chariot");

		Elephant red_elephant1 = new Elephant(new Location(9, 2), "Red", "Elephant");
		Elephant red_elephant2 = new Elephant(new Location(9, 6), "Red", "Elephant");
		Elephant black_elephant1 = new Elephant(new Location(0, 6), "Black", "Elephant");
		Elephant black_elephant2 = new Elephant(new Location(0, 2), "Black", "Elephant");

		General red_general1 = new General(new Location(9, 4), "Red", "General");
		General black_general1 = new General(new Location(0, 4), "Black", "General");

		Horse red_horse1 = new Horse(new Location(9, 1), "Red", "Horse");
		Horse red_horse2 = new Horse(new Location(9, 7), "Red", "Horse");
		Horse black_horse1 = new Horse(new Location(0, 7), "Black", "Horse");
		Horse black_horse2 = new Horse(new Location(0, 1), "Black", "Horse");

		Soldier red_soldier1 = new Soldier(new Location(6, 0), "Red", "Soldier");
		Soldier red_soldier2 = new Soldier(new Location(6, 2), "Red", "Soldier");
		Soldier red_soldier3 = new Soldier(new Location(6, 4), "Red", "Soldier");
		Soldier red_soldier4 = new Soldier(new Location(6, 6), "Red", "Soldier");
		Soldier red_soldier5 = new Soldier(new Location(6, 8), "Red", "Soldier");

		Soldier black_soldier1 = new Soldier(new Location(3, 0), "Black", "Soldier");
		Soldier black_soldier2 = new Soldier(new Location(3, 2), "Black", "Soldier");
		Soldier black_soldier3 = new Soldier(new Location(3, 4), "Black", "Soldier");
		Soldier black_soldier4 = new Soldier(new Location(3, 6), "Black", "Soldier");
		Soldier black_soldier5 = new Soldier(new Location(3, 8), "Black", "Soldier");


		(board.getChessList())[red_advisor1.getLocation().getRow()][red_advisor1.getLocation().getCol()] = red_advisor1;
		(board.getChessList())[red_advisor2.getLocation().getRow()][red_advisor2.getLocation().getCol()] = red_advisor2;
		(board.getChessList())[black_advisor1.getLocation().getRow()][black_advisor1.getLocation().getCol()] = black_advisor1;
		(board.getChessList())[black_advisor2.getLocation().getRow()][black_advisor2.getLocation().getCol()] = black_advisor2;

		(board.getChessList())[red_cannon1.getLocation().getRow()][red_cannon1.getLocation().getCol()] = red_cannon1;
		(board.getChessList())[red_cannon2.getLocation().getRow()][red_cannon2.getLocation().getCol()] = red_cannon2;
		(board.getChessList())[black_cannon1.getLocation().getRow()][black_cannon1.getLocation().getCol()] = black_cannon1;
		(board.getChessList())[black_cannon2.getLocation().getRow()][black_cannon2.getLocation().getCol()] = black_cannon2;

		(board.getChessList())[red_chariot1.getLocation().getRow()][red_chariot1.getLocation().getCol()] = red_chariot1;
		(board.getChessList())[red_chariot2.getLocation().getRow()][red_chariot2.getLocation().getCol()] = red_chariot2;
		(board.getChessList())[black_chariot1.getLocation().getRow()][black_chariot1.getLocation().getCol()] = black_chariot1;
		(board.getChessList())[black_chariot2.getLocation().getRow()][black_chariot2.getLocation().getCol()] = black_chariot2;

		(board.getChessList())[red_elephant1.getLocation().getRow()][red_elephant1.getLocation().getCol()] = red_elephant1;
		(board.getChessList())[red_elephant2.getLocation().getRow()][red_elephant2.getLocation().getCol()] = red_elephant2;
		(board.getChessList())[black_elephant1.getLocation().getRow()][black_elephant1.getLocation().getCol()] = black_elephant1;
		(board.getChessList())[black_elephant2.getLocation().getRow()][black_elephant2.getLocation().getCol()] = black_elephant2;

		(board.getChessList())[red_general1.getLocation().getRow()][red_general1.getLocation().getCol()] = red_general1;
		(board.getChessList())[black_general1.getLocation().getRow()][black_general1.getLocation().getCol()] = black_general1;

		(board.getChessList())[red_horse1.getLocation().getRow()][red_horse1.getLocation().getCol()] = red_horse1;
		(board.getChessList())[red_horse2.getLocation().getRow()][red_horse2.getLocation().getCol()] = red_horse2;
		(board.getChessList())[black_horse1.getLocation().getRow()][black_horse1.getLocation().getCol()] = black_horse1;
		(board.getChessList())[black_horse2.getLocation().getRow()][black_horse2.getLocation().getCol()] = black_horse2;


		(board.getChessList())[red_soldier1.getLocation().getRow()][red_soldier1.getLocation().getCol()] = red_soldier1;
		(board.getChessList())[red_soldier2.getLocation().getRow()][red_soldier2.getLocation().getCol()] = red_soldier2;
		(board.getChessList())[red_soldier3.getLocation().getRow()][red_soldier3.getLocation().getCol()] = red_soldier3;
		(board.getChessList())[red_soldier4.getLocation().getRow()][red_soldier4.getLocation().getCol()] = red_soldier4;
		(board.getChessList())[red_soldier5.getLocation().getRow()][red_soldier5.getLocation().getCol()] = red_soldier5;


		(board.getChessList())[black_soldier1.getLocation().getRow()][black_soldier1.getLocation().getCol()] = black_soldier1;
		(board.getChessList())[black_soldier2.getLocation().getRow()][black_soldier2.getLocation().getCol()] = black_soldier2;
		(board.getChessList())[black_soldier3.getLocation().getRow()][black_soldier3.getLocation().getCol()] = black_soldier3;
		(board.getChessList())[black_soldier4.getLocation().getRow()][black_soldier4.getLocation().getCol()] = black_soldier4;
		(board.getChessList())[black_soldier5.getLocation().getRow()][black_soldier5.getLocation().getCol()] = black_soldier5;





	}

	public Board getBoard() {
		return this.board;
	}

	public void addChess() {
		// TODO - implement InitializeBoard.addChess
		throw new UnsupportedOperationException();
	}

}
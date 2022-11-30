import javafx.application.Application;
import javafx.stage.Stage;

import View.*;

public class Main extends Application {

	private ChessGame chessGame;
	private Stage stage;

	/**
	 * Main method
	 *
	 * @param args argument, if any
	 */
	public static void main(String[] args) {
		// TODO - implement Main.main
		launch(args);
		//throw new UnsupportedOperationException();
	}
	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		InitializeBoard initializeBoard = new InitializeBoard();
		chessGame = new ChessGame(stage);

	}

}
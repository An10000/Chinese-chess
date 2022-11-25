package View;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	/**
	 * Main method
	 *
	 * @param args agument, if any
	 */
	public static void main(String[] args) {
		// TODO - implement Main.main
		launch(args);
		//throw new UnsupportedOperationException();
	}
	@Override
	public void start(Stage stage) throws Exception {
		ChessGame chessGame = new ChessGame(stage);
	}

}
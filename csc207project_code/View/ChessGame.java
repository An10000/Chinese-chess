package View;

import Control.Controller;
import Control.Scorer;
import Model.Board;
import Model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChessGame {

	private String mode;// mode of the game

//	/**
//	 *
//	 * @param mode
//	 */
//	public void startGame(String mode) {
//		// TODO - implement ChessGame.startGame
//		throw new UnsupportedOperationException();
//	}

	/**
	 * Initialize a ChessGame.
	 * It starts with a window asking the user which mode they want to play,
	 * and the user selects one mode, we start the game.
	 * @param stage the window which the mode selection will be happening.
	 */
	public ChessGame(Stage stage) {

		Board board = Board.getInstance();

		stage.setTitle("Chinese Chess");

		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-color: #121212;");

		//add canvas
		Canvas canvas = new Canvas(200, 300);
		canvas.setId("Canvas");

		//add buttons
		Button classicMode = new Button("Classic Mode");
		classicMode.setId("Classic Mode");
		classicMode.setPrefSize(300, 50);
		classicMode.setFont(new Font(20));
		classicMode.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

		Button timedMode = new Button("Timed Mode");
		timedMode.setId("Timed Mode");
		timedMode.setPrefSize(300, 50);
		timedMode.setFont(new Font(20));
		timedMode.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

		Button scoredMode = new Button("Scored Mode");
		scoredMode.setId("Scored Mode");
		scoredMode.setPrefSize(300, 50);
		scoredMode.setFont(new Font(20));
		scoredMode.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

		VBox controls = new VBox(20, classicMode, timedMode, scoredMode);
		controls.setPadding(new Insets(20, 20, 20, 20));
		controls.setAlignment(Pos.CENTER);

		classicMode.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Player[] players = new Player[2];
				Player playerRed = new Player("Red");
				Player playerBlack = new Player("Black");
				players[0] = playerRed;
				players[1] = playerBlack;
				Controller controller = new Controller(board, players, "Classic Mode", null);
				Viewer viewer1 = new Viewer("Classic Mode", board, controller, stage);
			}
		});

		timedMode.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				final Stage dialog = new Stage();
				dialog.setTitle("Please enter the time for each round (in seconds)");
				dialog.initModality(Modality.APPLICATION_MODAL);
				dialog.initOwner(stage);
				VBox dialogVbox = new VBox(20);
				dialogVbox.setPadding(new Insets(20, 20, 20, 20));
				dialogVbox.setStyle("-fx-background-color: #121212;");

				TextField textField = new TextField("");
				textField.setStyle("-fx-text-fill: #e8e6e3;");
				textField.setFont(new Font(16));
				textField.setText("30");
				Label numberFormatErrorLabel = new Label("");
				numberFormatErrorLabel.setStyle("-fx-text-fill: #e8e6e3;");
				numberFormatErrorLabel.setFont(new Font(16));

				Button setTime = new Button("Set Time");
				setTime.setId("Set Time"); // DO NOT MODIFY ID
				setTime.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");
				setTime.setPrefSize(200, 50);
				setTime.setFont(new Font(16));
				setTime.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						String time = textField.getText();
						try{
							int intTime = Integer.parseInt(time);
							if (intTime < 0){
								numberFormatErrorLabel.setText("Is not positive!");
							}
							else{
								Player[] players = new Player[2];
								Player playerRed = new Player("Red");
								Player playerBlack = new Player("Black");
								players[0] = playerRed;
								players[1] = playerBlack;
								Controller controller = new Controller(board, players, "Timed Mode", null);
								Viewer viewer1 = new Viewer("Timed Mode", board, controller, stage, intTime);
							}
						} catch (NumberFormatException e){
							numberFormatErrorLabel.setText("Not an integer!");
						}
					}
				});
				VBox saveBoardBox = new VBox(10, textField, setTime, numberFormatErrorLabel);

				dialogVbox.getChildren().add(saveBoardBox);
				Scene dialogScene = new Scene(dialogVbox, 300, 300);
				dialog.setScene(dialogScene);
				dialog.show();
			}
		});

		scoredMode.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Scorer scorer = new Scorer();
				Player[] players = new Player[2];
				Player playerRed = new Player("Red");
				Player playerBlack = new Player("Black");
				players[0] = playerRed;
				players[1] = playerBlack;
				Controller controller = new Controller(board, players, "Scored Mode", scorer);
				Viewer viewer1 = new Viewer("Scored Mode", board, controller, stage, scorer);

			}
		});
		borderPane.setTop(controls);
		borderPane.setCenter(canvas);

		var scene = new Scene(borderPane, 300, 300);
		stage.setScene(scene);
		stage.show();
	}

//		throw new UnsupportedOperationException();

}
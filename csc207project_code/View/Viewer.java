package View;

import Model.*;
import Control.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.TetrisModel;

public class Viewer {

	private String mode;
	private int time;

	private Timeline timeline;

	private Controller controller;
	private Timer timer;
	private Scorer scorer;
	private String round;
	private Stage stage;
	private Board board;
	private VBox vBox;

	private Label label;

	/**
	 * Initializer of Viewer with Classic Mode.
	 * @param mode 	A string that represent the game mode currently playing.
	 * @param board  The board that players are playing.
	 * @param controller The controller that control the game.
	 * @param stage	 The stage that is used to build visualization.
	 */
	public Viewer(String mode, Board board, Controller controller, Stage stage) {
		this.mode = mode;
		this.board = board;
		this.stage = stage;
		this.round = "Red";
		initUI();
	}

	/**
	 * Initializer of Viewer with Scored Mode.
	 * @param mode  A string that represent the game mode currently playing.
	 * @param board  The board that players are playing.
	 * @param controller  The controller that control the game.
	 * @param stage  The stage that is used to build visualization.
	 * @param scorer  The scorer that will record the score during the game.
	 */
	public Viewer(String mode, Board board, Controller controller, Stage stage, Scorer scorer) {
		this.mode = mode;
		this.board = board;
		this.stage = stage;
		this.round = "Red";
		this.scorer = scorer;
		initUI();
	}

	/**
	 * Initializer of Viewer with Timed Mode.
	 * @param mode  A string that represent the game mode currently playing.
	 * @param board  The board that players are playing.
	 * @param controller  The controller that control the game.
	 * @param stage  The stage that is used to build visualization.
	 * @param time  A int that represent the remaining time of each round in second.
	 */
	public Viewer(String mode, Board board, Controller controller, Stage stage, int time) {
		this.mode = mode;
		this.board = board;
		this.stage = stage;
		this.round = "Red";
		this.time = time;
		this.timer = new Timer(time, this, this.stage);
		initUI();
	}

	/**
	 * Initialize the UI to build the visualization of the game Chinese Chess.
	 */
	private void initUI() {
		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-color: #121212;");

		Image chessBoard = new Image("View/Graphics/chessBoard.png", 600, 750, true, true);

		BackgroundSize backgroundSize = new BackgroundSize(600, 750, true, true, true, false);

		BackgroundImage backgroundImage = new BackgroundImage(chessBoard,
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER,
				backgroundSize);

		AnchorPane anchorPane = new AnchorPane();
		anchorPane.setBackground(new Background(backgroundImage));

		ButtonFactory buttonFactory = new ButtonFactory(anchorPane, controller);

		switch (mode) {
			case "Timed Mode" -> {
				label = new Label("");
				label.setId("TimeLabel");
				label.setText(String.format("Round: %s" + "\nCountdown: %d", round, time));
				label.setFont(new Font(20));
				label.setStyle("-fx-text-fill: #e8e6e3");
				vBox = new VBox(20, label);
			}
			case "Scored Mode" -> {
				label = new Label("");
				label.setId("ScoreLabel");
				label.setText(String.format("Round: %s" + "\nRed Score: 0" + "\nBlack Score: 0", round));
				label.setFont(new Font(20));
				label.setStyle("-fx-text-fill: #e8e6e3");
				vBox = new VBox(20, label);
			}
			case "Classic Mode" -> {
				label = new Label("");
				label.setId("Classic Label");
				label.setText(String.format("Round: %s", round));
				label.setFont(new Font(20));
				label.setStyle("-fx-text-fill: #e8e6e3");
				vBox = new VBox(20, label);
			}
		}
		vBox.setPadding(new Insets(20, 20, 20, 20));
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.setMaxSize(200,100);
		vBox.setMinSize(200,100);

		timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e -> updateBoard()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

		borderPane.setRight(vBox);
		borderPane.setCenter(anchorPane);

		var scene = new Scene(borderPane);
		stage.setScene(scene);
		stage.setMaxHeight(800);
		stage.setMaxWidth(1250);
		stage.setMinHeight(800);
		stage.setMinWidth(1250);
		stage.show();
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
		switch (this.round) {
			case "Red" -> this.round = "Black";
			case "Black" -> this.round = "Red";
		}
	}

	public String getRound() {
		return this.round;
	}

	private void updateBoard() {
		switch (mode) {
			case "Timed Mode" -> drawTimer();
			case "Scored Mode" -> drawScorer();
			case "Classic Mode" -> update_classic();
		}
	}

	/**
	 * The method will return the mode of the game.
	 * @return this.mode
	 */
	public String getMode() {
		return this.mode;
	}
	/**
	 * The method drawTimer() will update the information displayed,
	 * and update the time information depends on the timer.
	 */
	public void drawTimer() {
		label.setText(String.format("Round: %s" + "\nCountdown: %d", round, timer.getCounter()));
	}

	/**
	 * The method drawScorer() will update the information displayed,
	 * and update the score information depends on the scorer.
	 */
	public void drawScorer() {
		label.setText(String.format("Red Score: %d" + "\nBlack Score: %d", scorer.getFactionScore("Red"), scorer.getFactionScore("Black")));
	}

	/**
	 * The method update_classic() will update the information displayed.
	 */
	public void update_classic(){
		label.setText(String.format("Round: %s", round));
	}

}
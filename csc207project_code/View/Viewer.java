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
	 * 
	 * @param mode
	 * @param board
	 */
	public Viewer(String mode, Board board, Stage stage) {
		this.mode = mode;
		this.board = board;
		this.stage = stage;
		this.round = "Red";
		initUI();
	}

	public Viewer(String mode, Board board, Stage stage, Scorer scorer) {
		this.mode = mode;
		this.board = board;
		this.stage = stage;
		this.round = "Red";
		this.scorer = scorer;
		initUI();
	}

	/**
	 * 
	 * @param mode
	 * @param board
	 * @param time
	 */
	public Viewer(String mode, Board board, Stage stage, int time) {
		this.mode = mode;
		this.board = board;
		this.stage = stage;
		this.round = "Red";
		this.timer = new Timer(time, this, this.stage);
		initUI();
	}

	private void initUI() {

		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-color: #121212;");

		Image chessBoard = new Image("View/chessBoard.png", 600, 750, true, true);

		BackgroundSize backgroundSize = new BackgroundSize(600, 750, true, true, true, false);

		BackgroundImage backgroundImage = new BackgroundImage(chessBoard,
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER,
				backgroundSize);

		AnchorPane anchorPane = new AnchorPane();
		anchorPane.setBackground(new Background(backgroundImage));

		Button bt = new Button();
		bt.setShape(new Circle(30));
		bt.setMaxSize(60,60);
		bt.setMinSize(60,60);
		Image chess = new Image("View/chess.jpeg",60,60,true,true);
		ImageView chessview = new ImageView(chess);
		bt.setGraphic(chessview);

		Button bt_2 = new Button();
		bt_2.setShape(new Circle(30));
		bt_2.setMaxSize(60, 60);
		bt_2.setMinSize(60,60);

		Button bt_3 = new Button();
		bt_3.setShape(new Circle(30));
		bt_3.setMaxSize(60, 60);
		bt_3.setMinSize(60,60);

		bt.setOnAction(e -> {
			nextRound();
		});

		anchorPane.getChildren().addAll(bt, bt_2, bt_3);
		AnchorPane.setTopAnchor(bt, 65.0);
		AnchorPane.setLeftAnchor(bt, 302.0);
		AnchorPane.setTopAnchor(bt_2, 65.0);
		AnchorPane.setLeftAnchor(bt_2, 237.0);
		AnchorPane.setTopAnchor(bt_3, 130.0);
		AnchorPane.setLeftAnchor(bt_3, 237.0);

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

	public String getMode() {
		return this.mode;
	}
	/**
	 * 
	 * @param
	 */
	public void drawTimer() {
		label.setText(String.format("Round: %s" + "\nCountdown: %d", round, timer.getCounter()));
	}

	public void drawScorer() {
		label.setText(String.format("Red Score: %d" + "\nBlack Score: %d", scorer.getFactionScore("Red"), scorer.getFactionScore("Black")));
	}

	public void update_classic(){
		label.setText(String.format("Round: %s", round));
	}

}
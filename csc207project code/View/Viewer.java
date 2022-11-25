package View;

import Model.*;
import Control.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Viewer {

	private String mode;
	private int time;
	private Controller controller;
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
		Timer timer = new Timer(time, this);
		initUI();
	}

	private void initUI() {

		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-color: #121212;");

		//add canvas
		Canvas canvas = new Canvas(200, 300);
		canvas.setId("Canvas");
		GraphicsContext gc = canvas.getGraphicsContext2D();

		HBox controls = new HBox(20);
		controls.setPadding(new Insets(20, 20, 20, 20));
		controls.setAlignment(Pos.CENTER);

		switch (mode) {
			case "Timed Mode" -> {
				label = new Label("");
				label.setId("TimeLabel");
				label.setText(String.format("Countdown: %d", time));
				label.setFont(new Font(20));
				label.setStyle("-fx-text-fill: #e8e6e3");
				vBox = new VBox(20, label);
			}
			case "Scored Mode" -> {
				label = new Label("");
				label.setId("ScoreLabel");
				label.setText("Red Score: 0" + "\nBlack Score: 0");
				label.setFont(new Font(20));
				label.setStyle("-fx-text-fill: #e8e6e3");
				vBox = new VBox(20, label);
			}
			case "Classic Mode" -> vBox = new VBox(20);
		}
		vBox.setPadding(new Insets(20, 20, 20, 20));
		vBox.setAlignment(Pos.TOP_CENTER);

		borderPane.setTop(controls);
		borderPane.setRight(vBox);
		borderPane.setCenter(canvas);

		var scene = new Scene(borderPane, 1250, 800);
		stage.setScene(scene);
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

	/**
	 * 
	 * @param timer
	 */
	public void drawTimer(Timer timer) {
		label.setText(String.format("Countdown: %d", timer.getCounter()));
	}

	public void drawScorer(Scorer scorer) {
		label.setText(String.format("Red Score: %d" + "\nBlack Score: %d", scorer.getFactionScore("Red"), scorer.getFactionScore("Black")));
	}

}
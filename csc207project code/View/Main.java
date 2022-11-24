package View;

import Model.Board;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

	Board board;
	Viewer viewer;

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
		this.board = Board.getInstance();

		stage.setTitle("Chinese Chess");

		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-color: #121212;");

		//add canvas
		Canvas canvas = new Canvas(200, 300);
		canvas.setId("Canvas");
		GraphicsContext gc = canvas.getGraphicsContext2D();

		final ToggleGroup toggleGroup = new ToggleGroup();

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
				Viewer viewer1 = new Viewer("Classic Mode", board, stage);
			}
		});

		scoredMode.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Viewer viewer1 = new Viewer("Scored Mode", board, stage);
			}
		});

		timedMode.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Viewer viewer1 = new Viewer("Timed Mode", board, stage);
			}
		});
		borderPane.setTop(controls);
		borderPane.setCenter(canvas);

		var scene = new Scene(borderPane, 300, 300);
		stage.setScene(scene);
		stage.show();
	}

}
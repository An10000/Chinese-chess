package Control;

import Model.Board;
import Model.Location;
import Model.Player;
import View.ChessGame;
import View.Viewer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestController extends Application {
    private Stage stage;
    private ChessGame chessGame;
    @Test
    void testController1(){
        Board board = Board.getInstance();
        Player[] players = new Player[2];
        Scorer scorer = new Scorer();
        Stage stage = this.stage;
        Controller controller = new Controller(board, players, "Classic Mode", scorer);
        Viewer viewer = new Viewer("Classic Mode", board, controller, stage, scorer);
        assertEquals(null, controller.getClicks());
    }
    @Test
    void testAddClick(){
        Board board = Board.getInstance();
        Player[] players = new Player[2];
        Scorer scorer = new Scorer();
        Stage stage = new Stage();
        Controller controller = new Controller(board, players, "Classic Mode", scorer);
        Viewer viewer = new Viewer("Classic Mode", board, controller, stage, scorer);
        controller.addClick(new Location(0, 0), "Red");
        assertEquals(null, controller.getClicks());
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.chessGame = new ChessGame(stage);
    }
}

package Control;

import Chesses.Advisor;
import Chesses.NullChess;
import Chesses.Soldier;
import Model.Board;
import Model.Location;
import Model.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestController{
    @Test
    void testController(){
        Board board = Board.getInstance();
        Player[] players = new Player[2];
        Scorer scorer = new Scorer();
        Controller controller = new Controller(board, players, "Classic Mode", scorer);
        assertEquals(new ArrayList<>(), controller.getClicks());
    }
    @Test
    void testAddClickOK(){
        Board board = Board.getInstance();
        Player[] players = new Player[2];
        Scorer scorer = new Scorer();
        Controller controller = new Controller(board, players, "Classic Mode", scorer);

        Advisor advisor = new Advisor(new Location(0, 0), "Red", "Advisor");
        board.setChessAt(advisor, new Location(0, 0));
        int returns = controller.addClick(new Location(0, 0), "Red");
        ArrayList<Location> expected = new ArrayList<>();
        expected.add(new Location(0, 0));
        assertEquals(expected, controller.getClicks());
        assertEquals(0, returns);

        board.setChessAt(new NullChess(new Location(0, 0), null, null), new Location(0, 0));
    }
    @Test
    void testAddClickInvalid(){
        Board board = Board.getInstance();
        Player[] players = new Player[2];
        Scorer scorer = new Scorer();
        Controller controller = new Controller(board, players, "Classic Mode", scorer);

        Advisor advisor = new Advisor(new Location(0, 0), "Red", "Advisor");
        board.setChessAt(advisor, new Location(0, 0));

        int returns1 = controller.addClick(new Location(1, 0), "Red");
        ArrayList<Location> expected1 = new ArrayList<>();
        assertEquals(expected1, controller.getClicks());
        assertEquals(2, returns1);

        board.setChessAt(new NullChess(new Location(0, 0), null, null), new Location(0, 0));
    }
    @Test
    void testAddClickMoved(){
        Board board = Board.getInstance();
        Player[] players = new Player[2];
        Scorer scorer = new Scorer();
        Controller controller = new Controller(board, players, "Classic Mode", scorer);

        Soldier soldier= new Soldier(new Location(1, 0), "Red", "Soldier");
        board.setChessAt(soldier, new Location(1, 0));

        int returns1 = controller.addClick(new Location(1, 0), "Red");
        ArrayList<Location> expected = new ArrayList<>();
        expected.add(new Location(1, 0));
        assertEquals(expected, controller.getClicks());
        assertEquals(0, returns1);

        int returns2 = controller.addClick(new Location(0, 0), "Red");
        ArrayList<Location> expected2 = new ArrayList<>();
        assertEquals(expected2, controller.getClicks());
        assertEquals(1, returns2);
        assertEquals("Soldier", board.getChessAt(new Location(0, 0)).getType());
    }
}

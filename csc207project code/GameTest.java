import Chesses.*;
import Control.*;
import Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class GameTest {
    @Test
    void testGetLocation() {
        Location expectedLocation = new Location(9, 3);
        Advisor advisor1 = new Advisor(expectedLocation, "Red", "Advisor");
        assertEquals(expectedLocation, advisor1.getLocation());
    }
    @Test
    void testInitializeBoard(){
        InitializeBoard initializeBoard = new InitializeBoard();
        System.out.println(initializeBoard.getBoard());
    }


}

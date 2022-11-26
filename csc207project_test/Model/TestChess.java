package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Chesses.Advisor;


public class TestChess {
    @Test
    void testGetLocation() {
        Location expectedLocation = new Location(9, 3);
        Advisor advisor1 = new Advisor(expectedLocation, "Red", "Advisor");
        assertEquals(expectedLocation, advisor1.getLocation());
    }
}

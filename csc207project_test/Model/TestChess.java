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
    @Test
    void testSetLocation(){
        Location oldLocation = new Location(3, 5);
        Location expectedLocation = new Location(9, 3);
        Advisor advisor1 = new Advisor(oldLocation, "Red", "Advisor");
        advisor1.setLocation(expectedLocation);
        assertEquals(expectedLocation, advisor1.getLocation());
    }
}

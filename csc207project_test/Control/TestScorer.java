package Control;
import Chesses.*;
import Model.Location;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestScorer {
    /**
     * Test the initializer of Scorer.
     * Uses getFactionScore at the same time, so it is also tested
     */
    @Test
    void testScorer(){
        Scorer newScorer = new Scorer();
        assertEquals(0, newScorer.getFactionScore("Red"));
        assertEquals(0, newScorer.getFactionScore("Black"));
    }
    /**
     * Test the addScore method of Scorer.
     * kills an Advisor and a General of faction "Red",
     * and check if the score are correctly added.
     */
    @Test
    void testAddScore(){
        Scorer newScorer = new Scorer();
        Advisor newAdvisor = new Advisor(new Location(0, 0), "Red", "Advisor");
        newScorer.addScore(newAdvisor);
        assertEquals(1, newScorer.getFactionScore("Black"));
        assertEquals(0, newScorer.getFactionScore("Red"));
        General newGeneral = new General(new Location(0, 0), "Red", "General");
        newScorer.addScore(newGeneral);
        assertEquals(11, newScorer.getFactionScore("Black"));
        assertEquals(0, newScorer.getFactionScore("Red"));
    }
}

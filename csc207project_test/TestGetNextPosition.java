import Chesses.Advisor;
import Model.Board;
import Model.Location;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGetNextPosition {

    public boolean isEqualIgnorOrder(ArrayList<Location> actual, ArrayList<Location> expect){
        if (actual.size() != expect.size()){
            return true;
        }
        else {
            for (Location location : actual) {
                if (!expect.contains(location)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    void testgetnextPosition_Advisor(){
        //"Red Advisor"
        Location chess_location = new Location(9, 3);
        Advisor advisor = new Advisor(chess_location, "Red", "Advisor");
        System.out.println(Board.getInstance());
        ArrayList<Location> legal_locations = new ArrayList<>();
        Location location1 = new Location(8, 4);
        legal_locations.add(location1);
        ArrayList<Location> res = advisor.getNextPosition(Board.getInstance());

        boolean f = isEqualIgnorOrder(res, legal_locations);
        assertTrue(f);


        //"Black Advisor"
        ArrayList<Location> legal_locations1 = new ArrayList<>();
        Location chess_location1 = new Location(0, 3);
        Advisor advisor1 = new Advisor(chess_location1, "Black", "Advisor");
        Location location2 = new Location(1, 4);
        legal_locations1.add(location2);
        ArrayList<Location> res1 = advisor1.getNextPosition(Board.getInstance());
        System.out.println(res1);
        boolean f1 = isEqualIgnorOrder(res1, legal_locations1);
        assertTrue(f1);
    }
}

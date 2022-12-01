import Chesses.Advisor;
import Chesses.Cannon;
import Chesses.General;
import Chesses.Horse;
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
            System.out.println(expect);
            return false;
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
//        System.out.println(Board.getInstance());
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
//        System.out.println(res1);
        boolean f1 = isEqualIgnorOrder(res1, legal_locations1);
        assertTrue(f1);
    }

    @Test
    void testgetnextPosition_Cannon(){
        InitializeBoard initializeBoard = new InitializeBoard();
        Location location = new Location(7, 1);
        Cannon cannon = new Cannon(location, "Red", "Cannon");
        Location location1 = new Location(7, 0);
        Location location2 = new Location(7, 2);
        Location location3 = new Location(7, 3);
        Location location4 = new Location(7, 4);
        Location location5 = new Location(7, 5);
        Location location6 = new Location(7, 6);
        Location location7 = new Location(0, 1);
        Location location8 = new Location(3,1);
        Location location9 = new Location(4,1);
        Location location10 = new Location(5,1);
        Location location11 = new Location(6,1);
        Location location12 = new Location(8,1);
        ArrayList<Location> legal_locations1 = new ArrayList<>();
        legal_locations1.add(location1);
        legal_locations1.add(location2);
        legal_locations1.add(location3);
        legal_locations1.add(location4);
        legal_locations1.add(location5);
        legal_locations1.add(location6);
        legal_locations1.add(location7);
        legal_locations1.add(location8);
        legal_locations1.add(location9);
        legal_locations1.add(location10);
        legal_locations1.add(location11);
        legal_locations1.add(location12);
        ArrayList<Location> res1 = cannon.getNextPosition(initializeBoard.getBoard());
//        System.out.println(res1);
        boolean f1 = isEqualIgnorOrder(res1, legal_locations1);
        assertTrue(f1);
    }

    @Test
    void testgetnextPosition_General(){
        Location location = new Location(9, 4);
        General general = new General(location, "Red", "General");
        Location location_move = new Location(8, 4);
        general.move(location_move,Board.getInstance());
        ArrayList<Location> legal_locations1 = new ArrayList<>();
        System.out.println(Board.getInstance());
        ArrayList<Location> res1 = general.getNextPosition(Board.getInstance());
        Location location1 = new Location(8, 3);
        Location location2 = new Location(8,5);
        Location location3 = new Location(7,4);
        Location location4 = new Location(9,4);
        legal_locations1.add(location1);
        legal_locations1.add(location2);
        legal_locations1.add(location3);
        legal_locations1.add(location4);
        boolean f1 = isEqualIgnorOrder(res1, legal_locations1);
        assertTrue(f1);
    }


    @Test
    void testgetnextPosition_Horse(){
        Location location = new Location(9,1);
        Horse horse = new Horse(location, "Red", "Horse");
        Location location1 = new Location(7, 0);
        Location location2 = new Location(7, 2);
        ArrayList<Location> legal_locations1 = new ArrayList<>();
        legal_locations1.add(location1);
        legal_locations1.add(location2);
        ArrayList<Location> res1 = horse.getNextPosition(Board.getInstance());
        boolean f1 = isEqualIgnorOrder(res1, legal_locations1);
        assertTrue(f1);
    }

}

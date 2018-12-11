package battleship.ship;

import battleship.board.Point;

import java.util.ArrayList;

public class CheckerShip {
    private int counter = 1;

    public boolean addNewShipPlayer(int length, Point point) {

        if (counter == length) {
            return true;
        }

        System.out.println(counter);

        counter++;

        return false;
    }

}

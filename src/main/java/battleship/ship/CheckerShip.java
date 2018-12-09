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

    public int checkerShip(Ship ship) {
        if (ship.getLength().equals("4")) {
            return 4;
        } else if (ship.getLength().equals("3")) {
            return 3;
        } else if (ship.getLength().equals("2")) {
            return 2;
        } else if (ship.getLength().equals("1")) {
            return 1;
        }
        return 0;
    }

}

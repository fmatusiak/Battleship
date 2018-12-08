package battleship.ship;

import battleship.board.Point;
import battleship.board.ServicePoint;

import java.util.ArrayList;

public class CheckerShip {
    private int counter = 1;
    private ServicePoint servicePoint = new ServicePoint();

    CounterShips counterShipsPlayer = new CounterShips();

    public boolean addNewShipPlayer(int length, Point point) {

        if (counter == length) {
            return true;
        }

        System.out.println(counter);

        servicePoint.addPointToList(point);
        counter++;

        return false;
    }

    public ArrayList getListPoints() {
        return servicePoint.getListPoints();
    }

    public void clearAllShipPlayer() {
        servicePoint.clearPointsList();
        counter = 1;
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

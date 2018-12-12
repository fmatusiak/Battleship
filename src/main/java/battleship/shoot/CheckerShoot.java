package battleship.shoot;

import battleship.board.Point;
import battleship.ship.ListShips;
import battleship.ship.Ship;

import java.util.ArrayList;

public class CheckerShoot {

    ListShips listShips;

    public CheckerShoot(ListShips listShips) {
        this.listShips = listShips;
    }

    public boolean checkShootPlayer(Point point) {

        for (Ship ship : listShips.getComputerListShips()) {
            if (ship.getShipPoints().contains(point)) {
                ship.getShipPoints().remove(point);
                if (checkHitOrSunk(ship)) {
                    listShips.getComputerListShips().remove(ship);
                }
                return true;
            }
            System.out.println("Pudłoooo");
        }

        return false;
    }

    public boolean checkHitOrSunk(Ship ship){
        return ship.getLength() == 0;
    }

}

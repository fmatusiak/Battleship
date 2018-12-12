package battleship.shoot;

import battleship.board.Point;
import battleship.ship.ListShips;
import battleship.ship.Ship;

public class CheckerShoot {

    ListShips listShips;

    public CheckerShoot(ListShips listShips) {
        this.listShips = listShips;
    }

    public boolean checkShoot(Point point) {

        for (Ship ship : listShips.getComputerListShips()) {
            if (ship.getShipPoints().contains(point)) {
                ship.getShipPoints().remove(point);
                System.out.println("Trafiony");
                if (checkHitOrSunk(ship)) {
                    listShips.getComputerListShips().remove(ship);
                    System.out.println("Zatopiony");
                }
                return true;
            }
        }
        return false;
    }

    public boolean checkHitOrSunk(Ship ship) {
        return ship.getShipPoints().size() == 0;
    }

}

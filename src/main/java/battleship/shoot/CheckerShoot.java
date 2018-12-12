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

    public int checkShoot(Point point) {
        for (Ship ship : listShips.getComputerListShips()) {
            if (ship.getShipPoints().contains(point)) {
                if (ship.removeShipPoint(point)) {
                    if (checkHitOrSunk(ship)) {
                       // listShips.removeShipComputer(ship);
                            System.out.println("Zatopiony");
                    } else {
                        System.out.println("Trafiony");
                    }

                }

            }

        }
        return 0;
    }




    public boolean checkHitOrSunk(Ship ship) {
        return ship.getShipPoints().size() == 0;
    }

}

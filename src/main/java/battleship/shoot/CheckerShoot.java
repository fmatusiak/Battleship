package battleship.shoot;

import battleship.players.Player;
import battleship.point.Point;
import battleship.ship.ListShips;
import battleship.ship.Ship;

import java.util.ArrayList;

public class CheckerShoot {

    ListShips listShips;

    public CheckerShoot(ListShips listShips) {
        this.listShips = listShips;
    }

    private int attackPoint(Point point, ArrayList<Ship> listPlayerShips) {
        for (Ship ship : listPlayerShips) {
            if (ship.getShipPoints().contains(point)) {
                if (ship.removeShipPoint(point)) {
                    if (checkHitOrSunk(ship)) {
                        listPlayerShips.remove(ship);
                        return 2;
                    } else {
                        return 1;
                    }

                }

            }

        }
        return 0;
    }

    public int checkAttackPoint(Point point, Player player) {
        if (player.getPlayerId().equals("computer")) {
            return attackPoint(point, listShips.getPlayerListShips());
        } else {
            return attackPoint(point, listShips.getComputerListShips());
        }
    }

    public boolean checkHitOrSunk(Ship ship) {
        return ship.getShipPoints().size() == 0;
    }

}

package battleship.shoot;

import battleship.players.Player;
import battleship.point.Point;
import battleship.ship.ListShips;
import battleship.ship.Ship;

public class CheckerShoot {

    ListShips listShips;

    public CheckerShoot(ListShips listShips) {
        this.listShips = listShips;
    }

    public int checkAttackPoint(Point point, Player player) {

        if (player.getPlayerId().equals("computer")) {
            for (Ship ship : listShips.getPlayerListShips()) {
                if (ship.getShipPoints().contains(point)) {
                    if (ship.removeShipPoint(point)) {
                        if (checkHitOrSunk(ship)) {
                            listShips.removeShipPlayer(ship);
                            return 2;
                        } else {
                            return 1;
                        }

                    }

                }

            }
            return 0;
        } else {
            for (Ship ship : listShips.getComputerListShips()) {
                if (ship.getShipPoints().contains(point)) {
                    if (ship.removeShipPoint(point)) {
                        if (checkHitOrSunk(ship)) {
                            listShips.removeShipComputer(ship);
                            return 2;
                        } else {
                            return 1;
                        }

                    }

                }

            }
            return 0;
        }

    }

    public boolean checkHitOrSunk(Ship ship) {
        return ship.getShipPoints().size() == 0;
    }

}

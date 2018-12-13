package battleship.shoot;

import battleship.board.Point;
import battleship.players.Player;
import battleship.ship.ListShips;

public class Shoot {

    Point point;
    ListShips listShips;
    CheckerShoot checkerShoot;

    public Shoot(ListShips listShips) {
        this.listShips = listShips;
        checkerShoot = new CheckerShoot(listShips);
    }

    public int shootArea(Point point, Player enemyPlayer) {
        int hitOrSunkShip = checkerShoot.checkAttackPoint(point, enemyPlayer);

        if (hitOrSunkShip == 1) {
            System.out.println("Trafiony");
            return 1;
        } else if (hitOrSunkShip == 2) {
            System.out.println("Zatopiony");
            return 2;
        } else if (hitOrSunkShip == 0) {
            System.out.println("Pudło");
            return 0;
        }

        return -1;
    }
}

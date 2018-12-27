package battleship.shoot;

import battleship.point.Point;
import battleship.players.Player;
import battleship.ship.ListShips;

public class Shoot {

    ListShips listShips;
    CheckerShoot checkerShoot;

    public Shoot(ListShips listShips) {
        this.listShips = listShips;
        checkerShoot = new CheckerShoot(listShips);
    }

    public int shootArea(Point point, Player player) {
        int hitOrSunkShip = checkerShoot.checkAttackPoint(point, player);

        if (hitOrSunkShip == 1) {
            System.out.println("Hit");
            player.addCounterHitPlayer();
            return 1;
        } else if (hitOrSunkShip == 2) {
            System.out.println("Sunk");
            player.addCounterSunkPlayer();
            return 2;
        } else if (hitOrSunkShip == 0) {
            System.out.println("Miss");
            player.addCounterMissPlayer();
            return 0;
        }
        return -1;
    }
}

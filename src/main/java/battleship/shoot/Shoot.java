package battleship.shoot;

import battleship.board.Point;
import battleship.ship.ListShips;
import battleship.ship.Ship;

import java.util.ArrayList;

public class Shoot {


    Point point;
    ListShips listShips;
    CheckerShoot checkerShoot;



    public Shoot(ListShips listShips){
        this.listShips = listShips;
        checkerShoot = new CheckerShoot(listShips);
    }

    public void shootArea(Point point) {
       checkerShoot.checkShoot(point);

    }
}

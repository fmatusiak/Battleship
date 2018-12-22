package battleship.ship;

import battleship.point.CheckerPoint;
import battleship.point.Point;

public class CheckerShip {

    CheckerPoint checkerPoint;

    private int counter = 1;

    public CheckerShip(CheckerPoint checkerPoint) {
        this.checkerPoint = checkerPoint;
    }

    public boolean checkNewShipPlayer(int length, Point point) {
        if (checkerPoint.checkPlayerPoint(point)) {
            if (counter == length) {
                return true;
            }
            counter++;
        }
        return false;
    }

    public void counterShipPoints(){
        counter = 1;
    }



}
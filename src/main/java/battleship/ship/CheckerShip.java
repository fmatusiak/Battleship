package battleship.ship;

import battleship.board.CheckerPoint;
import battleship.board.ListPlayerPoints;
import battleship.board.Point;

public class CheckerShip {

    public CheckerShip(CheckerPoint checkerPoint){
        this.checkerPoint = checkerPoint;
    }

    CheckerPoint checkerPoint;
    private int counter = 1;

    public boolean checkNewShipPlayer(int length, Point point) {

        if (checkerPoint.checkPlayerPoint(point)) {
            if (counter == length) {
                return true;
            }
            counter++;
        }
        return false;
    }


}
package battleship.board;

import battleship.ship.CheckerShip;
import battleship.ship.Ship;

import java.util.ArrayList;

public class CheckerPoint {

    public ArrayList getListPointsNoDuplicate(Ship ship) {
        ArrayList<Point> points = new ArrayList<>();
        RandomPoint randomPoint = new RandomPoint(ship);
        CheckerShip checkerShip = new CheckerShip();
        Point point;

        int length = checkerShip.checkerShip(ship);

        while (points.size() != length) {
            point = randomPoint.generatePoint();

            if (points.contains(point)) {
                points.remove(point);
            } else {
                points.add(point);
            }

        }
        return points;
    }

}

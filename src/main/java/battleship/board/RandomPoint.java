package battleship.board;

import battleship.ship.CheckerShip;
import battleship.ship.Ship;

import java.util.ArrayList;
import java.util.Random;

public class RandomPoint {
    private Ship ship;
    private Random random = new Random();


    public RandomPoint(Ship ship) {
        this.ship = ship;
    }

    public int generateNumber() {
        return random.nextInt(10);
    }

    public Point generatePoint() {
        return new Point(generateNumber(), generateNumber());
    }

    public ArrayList getListPointsShipsNoDuplicate(Ship ship) {
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

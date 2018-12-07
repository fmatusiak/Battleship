package battleship.board;

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

    public ArrayList randomListPoints() {

        CheckerPoint checkerPoint = new CheckerPoint();

        return checkerPoint.getListPointsNoDuplicate(ship);
    }

}

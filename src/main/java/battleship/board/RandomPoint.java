package battleship.board;

import battleship.ship.CheckerShip;
import battleship.ship.Ship;

import java.util.ArrayList;
import java.util.Random;

public class RandomPoint {
    private Ship ship;
    private Random random = new Random();

    public int generateNumber() {
        return random.nextInt(10);
    }

    public Point generateRandomPoint() {
        return new Point(generateNumber(), generateNumber());
    }

}

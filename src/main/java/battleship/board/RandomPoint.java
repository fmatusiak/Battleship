package battleship.board;

import java.util.Random;

public class RandomPoint {
    private Random random = new Random();

    public int generateNumber() {
        return random.nextInt(10);
    }

    public Point generateRandomPoint() {
        return new Point(generateNumber(), generateNumber());
    }

}

package battleship.ship;

public class CheckerShip {

    public int checkerShip(Ship ship) {
        if (ship.getLength().equals("4")) {
            return 4;
        } else if (ship.getLength().equals("3")) {
            return 6;
        } else if (ship.getLength().equals("2")) {
            return 6;
        } else if (ship.getLength().equals("1")) {
            return 4;
        }
        return 0;
    }

}

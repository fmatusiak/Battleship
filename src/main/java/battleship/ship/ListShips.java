package battleship.ship;

import battleship.board.Point;

import java.util.ArrayList;
import java.util.Objects;

public class ListShips {
    private Ship ship;
    private ArrayList<Point> pointsShip = new ArrayList<>();

    public ListShips() {

    }

    public ListShips(Ship ship, ArrayList<Point> pointsShip) {
        this.ship = ship;
        this.pointsShip = pointsShip;
    }

    public Ship getShip() {
        return ship;
    }

    public ArrayList<Point> getPointsShip() {
        return pointsShip;
    }

    public void addPointToList(Point point) {
        pointsShip.add(point);
    }

    public void addShip(Ship ship) {
        this.ship = ship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListShips listShips = (ListShips) o;
        return Objects.equals(ship, listShips.ship) &&
                Objects.equals(pointsShip, listShips.pointsShip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ship, pointsShip);
    }
}

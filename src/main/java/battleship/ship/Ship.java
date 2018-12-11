package battleship.ship;

import battleship.board.Point;

import java.util.ArrayList;
import java.util.Objects;

public class Ship {

    private int length;
    private ArrayList<Point> shipPoints;

    public Ship(int length, ArrayList<Point> shipPoints) {
        this.length = length;
        this.shipPoints = shipPoints;
    }
    
    public int getLength() {
        return length;
    }

    public ArrayList<Point> getShipPoints() {
        return shipPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return length == ship.length &&
                Objects.equals(shipPoints, ship.shipPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, shipPoints);
    }
}


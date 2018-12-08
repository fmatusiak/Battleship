package battleship.ship;

import java.util.Objects;

public class Ship {

    private int length;

    public Ship(int length) {
        this.length = length;
    }

    public String getLength() {
        return String.valueOf(length);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return length == ship.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }
}


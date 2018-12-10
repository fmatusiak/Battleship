package battleship.ship;

import java.util.ArrayList;
import java.util.Objects;

public class ServiceShip {
    ArrayList<ListShips> ships = new ArrayList<>();

    public void addShip(ListShips ship){
        ships.add(ship);
    }


    public ArrayList<ListShips> ships() {
        return ships;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceShip that = (ServiceShip) o;
        return Objects.equals(ships, that.ships);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ships);
    }
}

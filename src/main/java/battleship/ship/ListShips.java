package battleship.ship;

import java.util.ArrayList;

public class ListShips {

    private ArrayList<Ship> computerListShips = new ArrayList<>();
    private ArrayList<Ship> playerListShips = new ArrayList<>();

    public void addShipComputer(Ship computerShip) {
        computerListShips.add(computerShip);
    }

    public boolean addShipPlayer(Ship playerShip) {
        return playerListShips.add(playerShip);
    }

    public void removeShipComputer(Ship computerShip) {
        computerListShips.remove(computerShip);
    }

    public boolean removeShipPlayer(Ship ship) {
        return playerListShips.remove(ship);
    }

    public ArrayList<Ship> getComputerListShips() {
        return computerListShips;
    }

    public ArrayList<Ship> getPlayerListShips() {
        return playerListShips;
    }

}

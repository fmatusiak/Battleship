package battleship.ship;

import battleship.board.Point;

import java.util.ArrayList;

public class ListShips {

    private ArrayList<Ship> computerListShips = new ArrayList<>();
    private ArrayList<Ship> playerListShips = new ArrayList<>();

    public void addShipComputer(Ship computerShip){
        computerListShips.add(computerShip);
    }

    public void addShipPlayer(Ship playerShip){
        playerListShips.add(playerShip);
    }

    public boolean removeShipComputer(Ship ship){
        return computerListShips.remove(ship);
    }

    public boolean removeShipPlayer(Ship ship){
        return playerListShips.remove(ship);
    }

    public ArrayList<Ship> getComputerListShips() {
        return computerListShips;
    }

    public ArrayList<Ship> getPlayerListShips() {
        return playerListShips;
    }

}

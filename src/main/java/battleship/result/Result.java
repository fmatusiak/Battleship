package battleship.result;

import battleship.ship.ListShips;

public class Result {
    ListShips listShips;

    int shipsPlayer = 0;
    int shipsComputer = 0;

    public Result(ListShips listShips) {
        this.listShips = listShips;
    }

    public boolean updateCountShipsPlayer() {
        shipsPlayer = listShips.getPlayerListShips().size();
        shipsComputer = listShips.getComputerListShips().size();
        return true;
    }

    public int getShipsPlayer() {
        return shipsPlayer;
    }

    public int getShipsComputer() {
        return shipsComputer;
    }
}

package battleship.result;

import battleship.ship.ListShips;

public class Result {
    ListShips listShips;

    int shipsPlayer;
    int shipsComputer;

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

    @Override
    public String toString() {
        return "Result{" +
                "shipsPlayer=" + shipsPlayer +
                ", shipsComputer=" + shipsComputer +
                '}';
    }
}

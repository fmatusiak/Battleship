package battleship.result;

import battleship.ship.ListShips;

public class Result {
    ListShips listShips;

    public Result(ListShips listShips) {
        this.listShips = listShips;
    }

    public int getCountShipsComputer() {
        return listShips.getComputerListShips().size();
    }

    public int getCountShipsUser() {
        return listShips.getPlayerListShips().size();
    }


}

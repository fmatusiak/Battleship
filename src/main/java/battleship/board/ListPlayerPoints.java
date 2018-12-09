package battleship.board;

import java.util.ArrayList;

public class ListPlayerPoints {
    private ArrayList<Point> computerListPoints = new ArrayList<>();
    private ArrayList<Point> playerListPoints = new ArrayList<>();

    public ArrayList<Point> getComputerListPoints() {
        return computerListPoints;
    }

    public ArrayList<Point> getPlayerListPoints() {
        return playerListPoints;
    }

    public void addPointsToComputerList(ArrayList points){
        playerListPoints.addAll(points);
    }

}

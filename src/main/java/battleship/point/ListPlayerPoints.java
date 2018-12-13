package battleship.point;

import java.util.ArrayList;

public class ListPlayerPoints {
    private ArrayList<Point> computerListPoint = new ArrayList<>();
    private ArrayList<Point> computerListPoints = new ArrayList<>();

    private ArrayList<Point> playerListPoints = new ArrayList<>();

    public ArrayList<Point> getComputerListPoints() {
        return computerListPoints;
    }

    public ArrayList<Point> getPlayerListPoints() {
        return playerListPoints;
    }

    public void addPointToPlayerList(Point playerPoint) {
        playerListPoints.add(playerPoint);
    }

    public void addPointsToComputerList(Point computerPoint) {
        computerListPoint.add(computerPoint);
    }

    public void addPointsToComputerList(ArrayList computerPoints) {
        computerListPoints.addAll(computerPoints);
    }

}

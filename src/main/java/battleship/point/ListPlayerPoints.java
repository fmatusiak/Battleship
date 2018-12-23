package battleship.point;

import java.util.ArrayList;

public class ListPlayerPoints {
    private ArrayList<Point> computerListPoint = new ArrayList<>();
    private ArrayList<Point> computerListPoints = new ArrayList<>();
    private ArrayList<Point> playerTmpListPoints = new ArrayList<>();
    private ArrayList<Point> playerListPoints = new ArrayList<>();

    public ArrayList<Point> getPlayerTmpListPoints() {
        return playerTmpListPoints;
    }

    public ArrayList<Point> getComputerListPoints() {
        return computerListPoints;
    }

    public ArrayList<Point> getPlayerListPoints() {
        return playerListPoints;
    }

    public boolean addPointToPlayerList(Point playerPoint) {
        playerTmpListPoints.add(playerPoint);
        return playerListPoints.add(playerPoint);
    }

    public boolean addPointsToComputerList(Point computerPoint) {
        return computerListPoint.add(computerPoint);
    }

    public boolean addPointsToComputerList(ArrayList computerPoints) {
        return computerListPoints.addAll(computerPoints);
    }

    public void clearPointsToTmpListPoints() {
        playerTmpListPoints.clear();
    }


}

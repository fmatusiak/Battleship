package battleship.point;

import java.util.ArrayList;

public class ListPlayerPoints {
    private ArrayList<Point> computerListPoint = new ArrayList<>();
    private ArrayList<Point> computerListPoints = new ArrayList<>();

    public ArrayList<Point> getPlayerTmpListPoints() {
        return playerTmpListPoints;
    }

    private ArrayList<Point> playerTmpListPoints = new ArrayList<>();
    private ArrayList<Point> playerListPoints = new ArrayList<>();

    public ArrayList<Point> getComputerListPoints() {
        return computerListPoints;
    }

    public boolean addPointsTmpPlayerList(Point tmpPoint){
        return playerTmpListPoints.add(tmpPoint);
    }

    public ArrayList<Point> getPlayerListPoints() {
        playerTmpListPoints.addAll(playerListPoints);
        return playerListPoints;
    }

    public boolean addPointToPlayerList(Point playerPoint) {
        return playerListPoints.add(playerPoint);
    }

    public boolean addPointsToComputerList(Point computerPoint) {
        return computerListPoint.add(computerPoint);
    }

    public boolean addPointsToComputerList(ArrayList computerPoints) {
        return computerListPoints.addAll(computerPoints);
    }

    public void clearPointsToTmpListPoints() {
        playerListPoints.clear();
    }


}

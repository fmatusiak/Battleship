package battleship.point;

import java.util.ArrayList;

public class CheckerPoint {

    ListPlayerPoints listPlayerPoints;
    ArrayList<Point> tmpPoints = new ArrayList();

    public CheckerPoint(ListPlayerPoints listPlayerPoints) {
        this.listPlayerPoints = listPlayerPoints;
    }

    public boolean checkPointNotBusy(Point point, ArrayList listPlayerPoints) {
        return listPlayerPoints.contains(point);
    }

    public boolean checkPlayerPoint(Point point) {
        if (listPlayerPoints.getPlayerListPoints().contains(point)) {
            return false;
        }
        listPlayerPoints.addPointToPlayerList(point);
        return true;
    }

    public boolean checkComputerPoints(Point point, int howPoints) {
        if (checkPointsUp(point, howPoints)) {
            return listPlayerPoints.addPointsToComputerList(tmpPoints);
        } else if (checkPointsDown(point, howPoints)) {
            return listPlayerPoints.addPointsToComputerList(tmpPoints);
        } else if (checkPointsLeft(point, howPoints)) {
            return listPlayerPoints.addPointsToComputerList(tmpPoints);
        } else if (checkPointsRight(point, howPoints)) {
            return listPlayerPoints.addPointsToComputerList(tmpPoints);
        }
        tmpPoints.clear();
        return false;
    }

    @SuppressWarnings("Duplicates")
    public boolean checkPointsDown(Point point, int howPoints) {

        //CHECK DOWN
        for (int i = 0; i < howPoints; i++) {
            Point tmpPointDown = new Point(point.getX(), point.getY() - i);

            if (!checkPointNotBusy(tmpPointDown, listPlayerPoints.getComputerListPoints())) {
                if (tmpPointDown.getY() >= 1 && tmpPointDown.getY() <= 9) {
                    tmpPoints.add(tmpPointDown);
                    listPlayerPoints.addPointsToComputerList(tmpPointDown);

                    if (tmpPoints.size() == howPoints) {
                        return true;
                    }
                }

            }
        }
        tmpPoints.clear();
        return false;
    }

    @SuppressWarnings("Duplicates")
    public boolean checkPointsUp(Point point, int howPoints) {
        //CHECK UP
        for (int i = 0; i < howPoints; i++) {
            Point tmpPointUp = new Point(point.getX(), point.getY() + i);

            if (!checkPointNotBusy(tmpPointUp, listPlayerPoints.getComputerListPoints())) {
                if (tmpPointUp.getY() >= 1 && tmpPointUp.getY() <= 9) {
                    tmpPoints.add(tmpPointUp);
                    listPlayerPoints.addPointsToComputerList(tmpPointUp);

                    if (tmpPoints.size() == howPoints) {
                        return true;
                    }
                }

            }
        }
        tmpPoints.clear();
        return false;
    }

    @SuppressWarnings("Duplicates")
    public boolean checkPointsLeft(Point point, int howPoints) {
        //CHECK LEFT
        for (int i = 0; i < howPoints; i++) {
            Point tmpPointLeft = new Point(point.getX() - i, point.getY());

            if (!checkPointNotBusy(tmpPointLeft, listPlayerPoints.getComputerListPoints())) {
                if (tmpPointLeft.getX() >= 1 && tmpPointLeft.getX() <= 9) {
                    tmpPoints.add(tmpPointLeft);
                    listPlayerPoints.addPointsToComputerList(tmpPointLeft);

                    if (tmpPoints.size() == howPoints) {
                        return true;
                    }
                }
            }
        }
        tmpPoints.clear();
        return false;
    }

    @SuppressWarnings("Duplicates")
    public boolean checkPointsRight(Point point, int howPoints) {
        //CHECK RIGHT
        for (int i = 0; i < howPoints; i++) {
            Point tmpPointRight = new Point(point.getX() + i, point.getY());

            if (!checkPointNotBusy(tmpPointRight, listPlayerPoints.getComputerListPoints())) {
                if (tmpPointRight.getX() >= 1 && tmpPointRight.getX() <= 9) {
                    tmpPoints.add(tmpPointRight);
                    listPlayerPoints.addPointsToComputerList(tmpPointRight);

                    if (tmpPoints.size() == howPoints) {
                        return true;
                    }
                }

            }
        }
        tmpPoints.clear();
        return false;
    }

    public ArrayList<Point> getTmpPoints() {
        return tmpPoints;
    }

    public void clearTmpPoints() {
        tmpPoints.clear();
    }
}

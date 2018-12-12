package battleship.board;

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

    public boolean checkComputerPoints(Point point, int howPoints) {

        if (checkPointsUp(point, howPoints)) {
            listPlayerPoints.addPointsToComputerList(tmpPoints);
            return true;
        } else if (checkPointsDown(point, howPoints)) {
            listPlayerPoints.addPointsToComputerList(tmpPoints);
            return true;
        } else if (checkPointsLeft(point, howPoints)) {
            listPlayerPoints.addPointsToComputerList(tmpPoints);
            return true;
        } else if (checkPointsRight(point, howPoints)) {
            listPlayerPoints.addPointsToComputerList(tmpPoints);
            return true;
        }
        tmpPoints.clear();
        return false;
    }

    public boolean checkPointsDown(Point point, int howPoints) {

        //CHECK DOWN
        for (int i = 0; i < howPoints; i++) {
            Point tmpPointDown = new Point(point.getX(), point.getY() - i);

            if (!checkPointNotBusy(tmpPointDown, listPlayerPoints.getComputerListPoints())) {
                if (tmpPointDown.getY() >= 0 && tmpPointDown.getY() <= 10) {
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

    public boolean checkPointsUp(Point point, int howPoints) {
        //CHECK UP
        for (int i = 0; i < howPoints; i++) {
            Point tmpPointUp = new Point(point.getX(), point.getY() + i);

            if (!checkPointNotBusy(tmpPointUp, listPlayerPoints.getComputerListPoints())) {
                if (tmpPointUp.getY() >= 0 && tmpPointUp.getY() <= 10) {
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

    public boolean checkPointsLeft(Point point, int howPoints) {
        //CHECK LEFT
        for (int i = 0; i < howPoints; i++) {
            Point tmpPointLeft = new Point(point.getX() - i, point.getY());

            if (!checkPointNotBusy(tmpPointLeft, listPlayerPoints.getComputerListPoints())) {
                if (tmpPointLeft.getX() >= 0 && tmpPointLeft.getX() <= 10) {
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

    public boolean checkPointsRight(Point point, int howPoints) {
        //CHECK RIGHT
        for (int i = 0; i < howPoints; i++) {
            Point tmpPointRight = new Point(point.getX() + i, point.getY());

            if (!checkPointNotBusy(tmpPointRight, listPlayerPoints.getComputerListPoints())) {
                if (tmpPointRight.getX() >= 0 && tmpPointRight.getX() <= 10) {
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

package battleship.point;

import java.util.ArrayList;

public class CheckerPoint {

    private ListPlayerPoints listPlayerPoints;
    private ArrayList<Point> tmpPoints = new ArrayList();
    private int tmpMoveCountPoint = 0;

    public CheckerPoint(ListPlayerPoints listPlayerPoints) {
        this.listPlayerPoints = listPlayerPoints;
    }

    public void clearTmpMoveCountPoint() {
        tmpMoveCountPoint = 0;
    }

    private boolean checkPointNotBusy(Point point, ArrayList listPlayerPoints) {
        return listPlayerPoints.contains(point);
    }

    public boolean checkPlayerPoint(Point point) {
        if (checkPointNotBusy(point, listPlayerPoints.getPlayerListPoints())) {
            tmpMoveCountPoint = 0;
            return false;
        } else if (checkFirstPlayerPoint(point)) {
            return true;
        } else if (checkSetPointPlayerInPositionX(point)) {
            return true;
        } else if (checkSetPointPlayerInPositionY(point)) {
            return true;
        }
        return false;
    }

    private boolean checkFirstPlayerPoint(Point point) {
        if (listPlayerPoints.getPlayerTmpListPoints().size() == 0) {
            listPlayerPoints.addPointToPlayerList(point);
            tmpMoveCountPoint++;
            return true;
        }
        return false;
    }

    private boolean checkSetPointPlayerInPositionX(Point point) {
        Point tmpMovePointBackPlayer = listPlayerPoints.getPlayerTmpListPoints().get(tmpMoveCountPoint - 1);
        int tmpMovePointPlayerX = tmpMovePointBackPlayer.getX();
        int tmpMovePointPlayerY = tmpMovePointBackPlayer.getY();

        if ((point.getX() == tmpMovePointPlayerX + 1) && (point.getY() == tmpMovePointPlayerY)) {
            listPlayerPoints.addPointToPlayerList(point);
            tmpMoveCountPoint++;
            return true;
        } else if (point.getX() == (tmpMovePointPlayerX - 1) && (point.getY() == tmpMovePointPlayerY)) {
            listPlayerPoints.addPointToPlayerList(point);
            tmpMoveCountPoint++;
            return true;
        }
        return false;
    }

    private boolean checkSetPointPlayerInPositionY(Point point) {
        Point tmpMovePointBackPlayer = listPlayerPoints.getPlayerTmpListPoints().get(tmpMoveCountPoint - 1);
        int tmpMovePointPlayerX = tmpMovePointBackPlayer.getX();
        int tmpMovePointPlayerY = tmpMovePointBackPlayer.getY();

        if (point.getY() == (tmpMovePointPlayerY + 1) && (point.getX() == tmpMovePointPlayerX)) {
            listPlayerPoints.addPointToPlayerList(point);
            tmpMoveCountPoint++;
            return true;
        } else if (point.getY() == (tmpMovePointPlayerY - 1) && (point.getX() == tmpMovePointPlayerX)) {
            listPlayerPoints.addPointToPlayerList(point);
            tmpMoveCountPoint++;
            return true;
        }
        return false;
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
    private boolean checkPointsDown(Point point, int howPoints) {
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
    private boolean checkPointsUp(Point point, int howPoints) {
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
    private boolean checkPointsLeft(Point point, int howPoints) {
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
    private boolean checkPointsRight(Point point, int howPoints) {
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

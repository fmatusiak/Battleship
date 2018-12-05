package battleship.ships;

import battleship.board.Point;

public class Ships {

    private Point firstPoint;
    private Point secondPoint;

    public Ships(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public int getSize(){
        return (Math.abs(firstPoint.getX()) - secondPoint.getX() + 1) * (Math.abs(secondPoint.getY() - secondPoint.getY() + 1));
    }
}


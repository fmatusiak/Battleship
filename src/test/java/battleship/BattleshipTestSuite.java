package battleship;

import battleship.players.Player;
import battleship.point.CheckerPoint;
import battleship.point.ListPlayerPoints;
import battleship.point.Point;
import battleship.ship.ListShips;
import battleship.ship.Ship;
import battleship.shoot.Shoot;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BattleshipTestSuite {

    @Test
    public void testAddShipComputer() {
        //Given
        Point point = new Point(1, 1);
        Point twoPoint = new Point(1, 2);
        Point thirdPoint = new Point(1, 3);

        ListPlayerPoints listPlayerPoints = new ListPlayerPoints();

        CheckerPoint checkerPoint = new CheckerPoint(listPlayerPoints);
        checkerPoint.checkComputerPoints(point, 3);
        checkerPoint.checkComputerPoints(twoPoint, 3);
        checkerPoint.checkComputerPoints(thirdPoint, 3);


        ArrayList<Point> goodPoints = new ArrayList<>();
        goodPoints.add(new Point(1, 1));
        goodPoints.add(new Point(1, 2));
        goodPoints.add(new Point(1, 3));

        //When
        boolean result = listPlayerPoints.getComputerListPoints().containsAll(goodPoints);

        //then
        Assert.assertEquals(result, true);

    }

    @Test
    public void testAddShipWrongComputer() {
        //Given
        Point point = new Point(1, 1);
        Point twoPoint = new Point(1, 3);
        Point thirdPoint = new Point(1, 4);

        ListPlayerPoints listPlayerPoints = new ListPlayerPoints();

        CheckerPoint checkerPoint = new CheckerPoint(listPlayerPoints);
        checkerPoint.checkComputerPoints(point, 3);
        checkerPoint.checkComputerPoints(twoPoint, 3);
        checkerPoint.checkComputerPoints(thirdPoint, 3);


        ArrayList<Point> goodPoints = new ArrayList<>();
        goodPoints.add(new Point(1, 1));
        goodPoints.add(new Point(1, 3));
        goodPoints.add(new Point(1, 4));

        //When
        boolean result = listPlayerPoints.getPlayerTmpListPoints().containsAll(goodPoints);

        //then
        Assert.assertEquals(result, false);

    }

    @Test
    public void testShootSunkShipComputer() {
        //Given
        Point point = new Point(1, 1);
        ArrayList<Point> pointsShip = new ArrayList<>();
        ListShips listShips = new ListShips();
        Player player = new Player("computer");

        pointsShip.add(point);

        listShips.addShipPlayer(new Ship(1, pointsShip));
        Shoot shoot = new Shoot(listShips);

        //When
        int result = shoot.shootArea(new Point(1, 1), player);

        //Then
        Assert.assertEquals(result, 2);
    }

    @Test
    public void testShootHitLengthShipComputer() {
        //Given
        Point point = new Point(1, 1);
        Point twoPoint = new Point(1, 2);

        ArrayList<Point> pointsShip = new ArrayList<>();
        ListShips listShips = new ListShips();
        Player player = new Player("computer");

        pointsShip.add(point);
        pointsShip.add(twoPoint);

        listShips.addShipPlayer(new Ship(2, pointsShip));
        Shoot shoot = new Shoot(listShips);

        //When
        int result = shoot.shootArea(new Point(1, 2), player);

        //Then
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testShootMissLengthShipComputer() {
        //Given
        Point point = new Point(1, 1);
        Point twoPoint = new Point(1, 2);

        ArrayList<Point> pointsShip = new ArrayList<>();
        ListShips listShips = new ListShips();
        Player player = new Player("computer");

        pointsShip.add(point);
        pointsShip.add(twoPoint);

        listShips.addShipPlayer(new Ship(2, pointsShip));
        Shoot shoot = new Shoot(listShips);

        //When
        int result = shoot.shootArea(new Point(0, 0), player);

        //Then
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testAddShipPlayer() {
        //Given
        Point point = new Point(1, 1);
        Point twoPoint = new Point(1, 2);
        Point thirdPoint = new Point(1, 3);

        ListPlayerPoints listPlayerPoints = new ListPlayerPoints();

        CheckerPoint checkerPoint = new CheckerPoint(listPlayerPoints);
        checkerPoint.checkPlayerPoint(point);
        checkerPoint.checkPlayerPoint(twoPoint);
        checkerPoint.checkPlayerPoint(thirdPoint);

        ArrayList<Point> goodPoints = new ArrayList<>();
        goodPoints.add(new Point(1, 1));
        goodPoints.add(new Point(1, 2));
        goodPoints.add(new Point(1, 3));

        //When
        boolean result = listPlayerPoints.getPlayerListPoints().containsAll(goodPoints);

        //then
        Assert.assertEquals(result, true);

    }

    @Test
    public void testAddShipWrongPlayer() {
        //Given
        Point point = new Point(5, 1);
        Point twoPoint = new Point(7, 2);
        Point thirdPoint = new Point(9, 3);

        ListPlayerPoints listPlayerPoints = new ListPlayerPoints();

        CheckerPoint checkerPoint = new CheckerPoint(listPlayerPoints);
        checkerPoint.checkPlayerPoint(point);
        checkerPoint.checkPlayerPoint(twoPoint);
        checkerPoint.checkPlayerPoint(thirdPoint);

        ArrayList<Point> goodPoints = new ArrayList<>();
        goodPoints.add(new Point(5, 1));
        goodPoints.add(new Point(7, 2));
        goodPoints.add(new Point(9, 3));

        //When
        boolean result = listPlayerPoints.getPlayerListPoints().containsAll(goodPoints);

        //then
        Assert.assertEquals(result, false);

    }

    @Test
    public void testShootSunkShipPlayer() {
        //Given
        Point point = new Point(1, 1);

        ArrayList<Point> pointsShip = new ArrayList<>();
        ListShips listShips = new ListShips();
        Player player = new Player("player");

        pointsShip.add(point);

        listShips.addShipComputer(new Ship(1, pointsShip));
        Shoot shoot = new Shoot(listShips);

        //When
        int result = shoot.shootArea(new Point(1, 1), player);

        //Then
        Assert.assertEquals(result, 2);
    }

    @Test
    public void testShootHitShipPlayer() {
        //Given
        Point point = new Point(1, 1);
        Point twoPoint = new Point(1, 2);

        ArrayList<Point> pointsShip = new ArrayList<>();
        ListShips listShips = new ListShips();
        Player player = new Player("player");

        pointsShip.add(point);
        pointsShip.add(twoPoint);

        listShips.addShipComputer(new Ship(2, pointsShip));
        Shoot shoot = new Shoot(listShips);

        //When
        int result = shoot.shootArea(new Point(1, 2), player);

        //Then
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testShootMissShipPlayer() {
        //Given
        Point point = new Point(1, 1);
        Point twoPoint = new Point(1, 2);

        ArrayList<Point> pointsShip = new ArrayList<>();
        ListShips listShips = new ListShips();
        Player player = new Player("player");

        pointsShip.add(point);
        pointsShip.add(twoPoint);

        listShips.addShipComputer(new Ship(2, pointsShip));
        Shoot shoot = new Shoot(listShips);

        //When
        int result = shoot.shootArea(new Point(0, 0), player);

        //Then
        Assert.assertEquals(result, 0);
    }

}

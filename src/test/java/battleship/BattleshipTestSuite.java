package battleship;

import battleship.players.Player;
import battleship.point.Point;
import battleship.ship.ListShips;
import battleship.ship.Ship;
import battleship.shoot.Shoot;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BattleshipTestSuite {

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

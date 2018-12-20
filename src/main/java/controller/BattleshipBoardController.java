package controller;

import battleship.players.Player;
import battleship.point.CheckerPoint;
import battleship.point.ListPlayerPoints;
import battleship.point.Point;
import battleship.point.RandomPoint;
import battleship.ship.CheckerShip;
import battleship.ship.ListShips;
import battleship.ship.Ship;
import battleship.shoot.Shoot;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class BattleshipBoardController implements Initializable {

    ListPlayerPoints listPlayerPoints = new ListPlayerPoints();
    CheckerPoint checkerPoint = new CheckerPoint(listPlayerPoints);
    CheckerShip checkerShip = new CheckerShip(checkerPoint);
    ListShips listShips = new ListShips();
    Shoot shoot = new Shoot(listShips);

    Player user = new Player("user");
    Player computer = new Player("computer");

    @FXML
    private Pane mainMenuPane;

    @FXML
    private GridPane playerBoard;

    @FXML
    private GridPane playerAttackBoard;

    @FXML
    private GridPane computerBoard;

    @FXML
    private Label playerTitle;

    @FXML
    private Label computerTitle;

    @FXML
    private VBox shipsModel;

    @FXML
    private Label shipsTitle;

    public void addPaneToGridPanePlayerAttack(GridPane gridPane) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Pane pane = new Pane();
                pane.setOnMouseClicked(e -> shootUser(e));
                gridPane.add(pane, i, j);
            }
        }
    }

    public void addPaneToGridPanePlayer(GridPane gridPane) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Pane pane = new Pane();
                pane.setOnMouseClicked(e -> addShipsPlayerBoardClick(e));
                gridPane.add(pane, i, j);
            }
        }
    }


    public void shootUser(MouseEvent e) {
        Node source = (Node) e.getSource();
        Integer x = GridPane.getColumnIndex(source);
        Integer y = GridPane.getRowIndex(source);

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: SILVER");

        Point point = new Point(x, y);

        playerAttackBoard.add(pane, point.getX(), point.getY());

        shoot.shootArea(point, user);
    }

    public void addShipsPlayerBoardClick(MouseEvent e) {

        Node source = (Node) e.getSource();
        Integer x = GridPane.getColumnIndex(source);
        Integer y = GridPane.getRowIndex(source);

        addShipsPlayer(4, x, y);

    }

    public void addShipsPlayer(int length, Integer x, Integer y) {
        if (checkerShip.checkNewShipPlayer(length, new Point(x, y))) {
            if (listShips.addShipPlayer(new Ship(length, listPlayerPoints.getPlayerListPoints()))) {
                System.out.println("Dodano " + length + " dlugosciowy statek");
            }
            listPlayerPoints.clearPointsToTmpListPoints();
        }

    }


    public void randomShipsComputer(int lengthShips, int howShips) {
        RandomPoint randomPoint = new RandomPoint();
        int i = 0;
        while (i < howShips) {
            if (checkerPoint.checkComputerPoints(randomPoint.generateRandomPoint(), lengthShips)) {
                if (checkerPoint.getTmpPoints().size() == lengthShips) {
                    listShips.addShipComputer(new Ship(lengthShips, checkerPoint.getTmpPoints()));
                    checkerPoint.clearTmpPoints();
                    i++;
                }

            }

        }

    }

    public void showPlayerPoints() {
        for (Ship ship : listShips.getPlayerListShips()) {
            for (Point point : ship.getShipPoints()) {
                System.out.println(point);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addPaneToGridPanePlayerAttack(playerAttackBoard);
        addPaneToGridPanePlayer(playerBoard);

        randomShipsComputer(1, 4);
        randomShipsComputer(2, 3);
        randomShipsComputer(3, 2);
        randomShipsComputer(4, 1);

        listShips.getComputerListShips();

        for (Ship ship : listShips.getComputerListShips()) {
            for (Point point : ship.getShipPoints()) {
                Pane pane = new Pane();
                pane.setStyle("-fx-background-color: RED;");
                computerBoard.add(pane, point.getX(), point.getY());
            }
        }

    }

}

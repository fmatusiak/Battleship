package controller;

import battleship.board.CheckerPoint;
import battleship.board.ListPlayerPoints;
import battleship.board.Point;
import battleship.board.RandomPoint;
import battleship.ship.CheckerShip;
import battleship.ship.ListShips;
import battleship.ship.Ship;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BattleshipBoardController implements Initializable {

    ListPlayerPoints listPlayerPoints = new ListPlayerPoints();
    CheckerPoint checkerPoint = new CheckerPoint(listPlayerPoints);
    CheckerShip checkerShip = new CheckerShip();
    ListShips listShips = new ListShips();


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

    public void addPaneToGridPane(GridPane gridPane) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Pane pane = new Pane();
                pane.setOnMouseClicked(e -> mouseClickOnGridPane(e));
                gridPane.add(pane, i, j);
            }
        }
    }

    public void mouseClickOnGridPane(MouseEvent e) {
        Node source = (Node) e.getSource();
        Integer x = GridPane.getColumnIndex(source);
        Integer y = GridPane.getRowIndex(source);

    }

    public void addShipsPlayer(int lenght, Point point) {

        checkerShip.addNewShipPlayer(lenght, point);
    }

    public void randomShipComputer() {

        RandomPoint randomPoint = new RandomPoint();

        int i = 0;

        while (i < 4) {
            if (checkerPoint.checkComputerPoints(randomPoint.generateRandomPoint(), 1)) {
                i++;
            }

            for (Point point : checkerPoint.getTmpPoints()) {

                Pane pane = new Pane();
                pane.setStyle("-fx-background-color: RED;");
                computerBoard.add(pane, point.getX(), point.getY());
            }
            checkerPoint.clearTmpPoints();
        }

        i = 0;

        while (i < 3) {
            if (checkerPoint.checkComputerPoints(randomPoint.generateRandomPoint(), 2)) {
                i++;
            }
            for (Point point : checkerPoint.getTmpPoints()) {
                Pane pane = new Pane();
                pane.setStyle("-fx-background-color: GREEN;");
                computerBoard.add(pane, point.getX(), point.getY());
            }
            checkerPoint.clearTmpPoints();
        }

        i = 0;
        listShips.addShip(new Ship(3));
        while (i < 2) {

            if (checkerPoint.checkComputerPoints(randomPoint.generateRandomPoint(), 3)) {
                i++;
            }
            for (Point point : checkerPoint.getTmpPoints()) {
                Pane pane = new Pane();
                pane.setStyle("-fx-background-color: BLACK;");
                computerBoard.add(pane, point.getX(), point.getY());
            }
            checkerPoint.clearTmpPoints();
        }

        i = 0;

        while (i < 1) {
            if (checkerPoint.checkComputerPoints(randomPoint.generateRandomPoint(), 4)) {
                i++;
            }
            for (Point point : checkerPoint.getTmpPoints()) {
                Pane pane = new Pane();
                pane.setStyle("-fx-background-color: SILVER;");
                computerBoard.add(pane, point.getX(), point.getY());

            }
            checkerPoint.clearTmpPoints();
        }



        for (Point point : checkerPoint.getComputerPoints()) {




        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addPaneToGridPane(playerBoard);
        randomShipComputer();


    }


}

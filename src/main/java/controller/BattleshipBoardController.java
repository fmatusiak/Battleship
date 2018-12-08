package controller;

import battleship.board.Point;
import battleship.board.RandomPoint;
import battleship.ship.CheckerShip;
import battleship.ship.CounterShips;
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

    CheckerShip checkerShip = new CheckerShip();
    CounterShips counterShipsPlayer = new CounterShips();

    private ArrayList<ListShips> playerListShips = new ArrayList<>();
    private ArrayList<ListShips> playerAttackListShips = new ArrayList<>();
    private ArrayList<ListShips> computerListShips = new ArrayList<>();


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

        if (counterShipsPlayer.getOneShips() > 0) {
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: RED");
            playerBoard.add(pane, x, y);

            if (checkerShip.addNewShipPlayer(1, new Point(x, y))) {
                ListShips listShips = new ListShips(new Ship(1), checkerShip.getListPoints());
                playerListShips.add(listShips);
                checkerShip.clearAllShipPlayer();

                System.out.println("Stworzono nowy okret");

                counterShipsPlayer.substractOneShips();

            }

        } else if (counterShipsPlayer.getOneShips() == 0 && counterShipsPlayer.getTwoShips() > 0) {


            System.out.println("Counter two: " + counterShipsPlayer.getTwoShips());
            System.out.println("Counter one: " + counterShipsPlayer.getOneShips());

            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: GREEN");
            playerBoard.add(pane, x, y);

            if (checkerShip.addNewShipPlayer(2, new Point(x, y))) {
                ListShips listShips = new ListShips(new Ship(2), checkerShip.getListPoints());
                playerListShips.add(listShips);
                checkerShip.clearAllShipPlayer();

                System.out.println("Stworzono nowy okret");

                counterShipsPlayer.substractTwoShips();
            }

        } else if (counterShipsPlayer.getOneShips() == 0 && counterShipsPlayer.getTwoShips() == 0 && counterShipsPlayer.getThreeShips() > 0) {

            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: BLACK");
            playerBoard.add(pane, x, y);

            if (checkerShip.addNewShipPlayer(3, new Point(x, y))) {
                ListShips listShips = new ListShips(new Ship(3), checkerShip.getListPoints());
                playerListShips.add(listShips);
                checkerShip.clearAllShipPlayer();

                System.out.println("Stworzono nowy okret");

                counterShipsPlayer.substractThreeShips();
            }

        }


    }

    public void getPlayerListShips() {
        for (ListShips ships : playerListShips) {
            System.out.println(ships.getShip());
        }
    }

    public void addShipsPlayer(int lenght, Point point) {

        checkerShip.addNewShipPlayer(lenght, point);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addPaneToGridPane(playerBoard);

        for (int i = 0; i < 4; i++) {
            Ship ship = new Ship(1);
            RandomPoint randomPoint = new RandomPoint(ship);

            ArrayList<Point> points = new ArrayList<>();

            points = randomPoint.getListPointsShipsNoDuplicate(ship);


            ListShips listShipsComputer = new ListShips(ship, points);

            computerListShips.add(listShipsComputer);
        }

        for (ListShips point : computerListShips) {
            System.out.println(point);

        }


    }
}

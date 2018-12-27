package controller;

import battleship.message.Message;
import battleship.players.Player;
import battleship.point.CheckerPoint;
import battleship.point.ListPlayerPoints;
import battleship.point.Point;
import battleship.point.RandomPoint;
import battleship.result.CheckerResult;
import battleship.result.Result;
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
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;

public class BattleshipBoardController implements Initializable {

    ListPlayerPoints listPlayerPoints = new ListPlayerPoints();
    CheckerPoint checkerPoint = new CheckerPoint(listPlayerPoints);
    CheckerShip checkerShip = new CheckerShip(checkerPoint);
    ListShips listShips = new ListShips();
    Shoot shoot = new Shoot(listShips);
    Result result = new Result(listShips);
    CheckerResult checkerResult = new CheckerResult(result);
    Message message = new Message(checkerResult);

    Player user = new Player("user");
    Player computer = new Player("computer");

    Queue<Integer> listLengthShips = new LinkedList<>();

    private boolean moveUser = true;

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

    public boolean newGame() {
        playerBoard.setManaged(false);
        addRandomShipsComputer();
        showComputerShipsOnComputerBoard();
        addPaneToGridPanePlayerAttack(playerAttackBoard);
        return true;
    }

    public void addLengthShipsToQueue() {
        listLengthShips.add(4);
        listLengthShips.add(3);
        listLengthShips.add(3);
        listLengthShips.add(2);
        listLengthShips.add(2);
        listLengthShips.add(2);
        listLengthShips.add(1);
        listLengthShips.add(1);
        listLengthShips.add(1);
        listLengthShips.add(1);
    }

    public boolean addPaneToGridPanePlayerAttack(GridPane gridPane) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Pane pane = new Pane();
                pane.setOnMouseClicked(e -> shootUser(e));
                gridPane.add(pane, i, j);
            }
        }
        return true;
    }

    public boolean addPaneToGridPanePlayer(GridPane gridPane) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Pane pane = new Pane();
                pane.setOnMouseClicked(e -> addShipsPlayerBoardClick(e));
                gridPane.add(pane, i, j);
            }
        }
        return true;
    }


    public boolean shootUser(MouseEvent e) {
        showPlayerShipsOnPlayerBoard();


        Node source = (Node) e.getSource();
        Integer x = GridPane.getColumnIndex(source);
        Integer y = GridPane.getRowIndex(source);

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: SILVER");

        Point point = new Point(x, y);

        playerAttackBoard.add(pane, point.getX(), point.getY());

        int scoreShoot = shoot.shootArea(point, user);

        if (scoreShoot == 1 || scoreShoot == 2) {
            System.out.println(result);
            showComputerShipsHitOrSunk(point);
        } else {
            System.out.println(result);
            showComputerShipsMissed(point);
        }

        message.showMessageWinner();

        shootComputer();

        return true;
}

    public boolean shootComputer() {
        RandomPoint randomPoint = new RandomPoint();
        Point point = randomPoint.generateRandomPoint();
        int scoreShootComputer = shoot.shootArea(point, computer);

        if (scoreShootComputer == 2 || scoreShootComputer == 1) {
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: BLACK;");
            playerBoard.add(pane, point.getX(), point.getY());
        } else {
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: BLUE;");
            playerBoard.add(pane, point.getX(), point.getY());
        }
        return true;
    }


    public boolean addShipsPlayerBoardClick(MouseEvent e) {
        Node source = (Node) e.getSource();
        Integer x = GridPane.getColumnIndex(source);
        Integer y = GridPane.getRowIndex(source);
        return addShipsPlayer(x, y);
    }

    public boolean addShipsPlayer(Integer x, Integer y) {
        if (listLengthShips.size() > 0) {
            int length = listLengthShips.peek();
            if (checkerShip.checkNewShipPlayer(length, new Point(x, y))) {
                if (listShips.addShipPlayer(new Ship(length, listPlayerPoints.getPlayerTmpListPoints()))) {
                    showPlayerShipsOnPlayerBoard();
                    System.out.println("Add " + length + " lengths ship");
                }
                listPlayerPoints.clearPointsToTmpListPoints();
                checkerShip.counterShipPoints();
                listLengthShips.remove();

                if (listLengthShips.size() == 0) {
                    newGame();
                    return true;
                }
            }

        }
        return false;
    }

    public boolean randomShipsComputer(int lengthShips, int howShips) {
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
        return true;
    }

    public boolean addRandomShipsComputer() {
        return randomShipsComputer(1, 4) && randomShipsComputer(2, 3) &&
                randomShipsComputer(3, 2) && randomShipsComputer(4, 1);
    }

    public void showPlayerShipsOnPlayerBoard() {
        for (Ship ship : listShips.getPlayerListShips()) {
            for (Point point : ship.getShipPoints()) {
                Pane pane = new Pane();
                pane.setStyle("-fx-background-color: SILVER;");
                playerBoard.add(pane, point.getX(), point.getY());
            }
        }
    }


    public void showComputerShipsOnComputerBoard() {
        for (Ship ship : listShips.getComputerListShips()) {
            for (Point point : ship.getShipPoints()) {
                Pane pane = new Pane();
                pane.setStyle("-fx-background-color: RED;");
                computerBoard.add(pane, point.getX(), point.getY());
            }
        }
    }

    public void showComputerShipsHitOrSunk(Point point) {
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color:BLACK;");
        computerBoard.add(pane, point.getX(), point.getY());
    }

    public void showComputerShipsMissed(Point point) {
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color:BLUE;");
        computerBoard.add(pane, point.getX(), point.getY());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addPaneToGridPanePlayer(playerBoard);
        addLengthShipsToQueue();


    }

}


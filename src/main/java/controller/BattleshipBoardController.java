package controller;

import battleship.board.CheckerPoint;
import battleship.board.ListPlayerPoints;
import battleship.board.Point;
import battleship.board.RandomPoint;
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
    CheckerShip checkerShip = new CheckerShip();
    ListShips listShips = new ListShips();
    Shoot shoot = new Shoot(listShips);


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

    public void addPaneToGridPanePlayerAttack(GridPane gridPane) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Pane pane = new Pane();
                pane.setOnMouseClicked(e -> shootComputer(e));
                gridPane.add(pane, i, j);
            }
        }
    }

    public void shootComputer(MouseEvent e){
        Node source = (Node) e.getSource();
        Integer x = GridPane.getColumnIndex(source);
        Integer y = GridPane.getRowIndex(source);

        shoot.shoot(new Point(x,y));

    }


    public void mouseClickOnGridPane(MouseEvent e) {
        Node source = (Node) e.getSource();
        Integer x = GridPane.getColumnIndex(source);
        Integer y = GridPane.getRowIndex(source);

    }

    public void addShipsPlayer(int lenght, Point point) {

        checkerShip.addNewShipPlayer(lenght, point);
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addPaneToGridPane(playerBoard);
        addPaneToGridPanePlayerAttack(playerAttackBoard);


        randomShipsComputer(1, 4);
        randomShipsComputer(2, 3);
        randomShipsComputer(3, 2);
        randomShipsComputer(4, 1);


        for(Ship ship : listShips.getComputerListShips()){
            for(Point point : ship.getShipPoints()){
                Pane pane = new Pane();
                pane.setStyle("-fx-background-color: RED;");
                computerBoard.add(pane,point.getX(),point.getY());
            }
        }

    }


}

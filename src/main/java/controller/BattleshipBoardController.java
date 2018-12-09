package controller;

import battleship.board.CheckerPoint;
import battleship.board.Point;
import battleship.board.RandomPoint;
import battleship.ship.CheckerShip;
import battleship.ship.CounterShips;
import battleship.ship.ListShips;
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

    CheckerShip checkerShip = new CheckerShip();
    CounterShips counterShipsPlayer = new CounterShips();
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


    public void addShipsComputer() {
        CheckerPoint checkerPoint = new CheckerPoint();
        RandomPoint randomPoint = new RandomPoint();

        Pane ship1 = new Pane();
        ship1.setStyle("-fx-background-color: RED;");

        Pane ship2 = new Pane();
        ship1.setStyle("-fx-background-color: GREEN;");

        Pane ship3 = new Pane();
        ship1.setStyle("-fx-background-color: BLACK;");

        Pane ship4 = new Pane();
        ship1.setStyle("-fx-background-color: SILVER;");

        int i = 0;

        while(i < 2){
              if(checkerPoint.checkComputerPoints(randomPoint.generateRandomPoint(),3))  {
                  i++;
              }
        }

        for(Point point : checkerPoint.getTmpPoints()){
           //  computerBoard.add(ship1,point.getX(),point.getY());
        }





    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {


        addPaneToGridPane(playerBoard);
        addShipsComputer();

    }


}

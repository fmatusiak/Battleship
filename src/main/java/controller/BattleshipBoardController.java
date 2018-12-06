package controller;

import battleship.board.Point;
import battleship.board.RandomPoint;
import battleship.board.ServicePoint;
import battleship.ship.Ship;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BattleshipBoardController implements Initializable {

    ServicePoint servicePoint = new ServicePoint();

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

    public void addPaneToGridPane(GridPane gridPane){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                Pane pane = new Pane();
                pane.setOnMouseClicked(e-> mouseClickOnGridPane(e));
                gridPane.add(pane,i,j);
            }
        }
    }

    public void mouseClickOnGridPane(MouseEvent e) {

        Node source = (Node)e.getSource() ;
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        Point point= new Point(colIndex,rowIndex);
        servicePoint.addPointToList(point);

        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());

        servicePoint.showList();



    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addPaneToGridPane(playerBoard);

        Ship ship = new Ship(1);


        RandomPoint randomPoint = new RandomPoint(ship);

        ArrayList<Point> points = new ArrayList<>();
        points = randomPoint.randomListPoints();


        for(Point point: points){
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: RED");
            computerBoard.add(pane,point.getX(),point.getY());

        }



    }
}

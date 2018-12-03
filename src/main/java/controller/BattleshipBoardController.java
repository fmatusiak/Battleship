package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class BattleshipBoardController implements Initializable {
    @FXML
    private Pane mainPane;
    private GridPane playerShipsAttackBoard;
    private GridPane computerShipsBoard;


    @FXML
    private void mouseClick(MouseEvent e){
       Node source = (Node) e.getSource();
       Integer colIndex = GridPane.getColumnIndex(source);
       Integer rowIndex = GridPane.getRowIndex(source);
        System.out.print(colIndex.intValue() + " : " + rowIndex.intValue());
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}

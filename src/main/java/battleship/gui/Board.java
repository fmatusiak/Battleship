package battleship.gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Board extends Application {

    private GridPane playerShipsBoard;

    //  private Image backgroundBoard = new Image("file:src/main/resources/img/images.jpeg");

    public static void main(String[] args) {
        Application.launch(Board.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        /*Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/battleshipBoard.fxml"));
        primaryStage.setTitle("Battleship");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();*/


       /* BackgroundSize backgroundSize = new BackgroundSize(1200, 800, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(backgroundBoard, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);


        Background background = new Background(backgroundImage);

        Parent root= FXMLLoader.load(getClass().getResource("battleshipBoard.fxml"));


        GridPane grid = new GridPane();
        grid.setBackground(background);

        Scene scene = new Scene(grid, 1200, 900);





        primaryStage.setTitle("Battleship");
        primaryStage.setScene(scene);
        primaryStage.show();
*/




       /* BackgroundSize backgroundSize = new BackgroundSize(800,800,true,true,true,false);
        BackgroundImage backgroundImage = new BackgroundImage(backgroundBoard, BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setBackground(background);

        Scene scene = new Scene(grid, 800,800, Color.SILVER);




        primaryStage.setTitle("Battleship");
        primaryStage.setScene(scene);
        primaryStage.show();*/

        Pane mainPane = new Pane();
        GridPane playerShipsAttackBoard = new GridPane();

        mainPane.prefHeight(877);
        mainPane.prefWidth(1341.0);

        playerShipsAttackBoard.setLayoutX(705.0);
        playerShipsAttackBoard.setLayoutY(384.0);
        playerShipsAttackBoard.prefHeight(437.0);
        playerShipsAttackBoard.prefWidth(491.0);
        playerShipsAttackBoard.gridLinesVisibleProperty().setValue(true);
       // playerShipsAttackBoard.setAlignment(Pos.BASELINE_LEFT);
        playerShipsAttackBoard.setHgap(10);
        playerShipsAttackBoard.setVgap(10);
        playerShipsAttackBoard.setStyle("-fx-background-color: GREEN;");


        for(int i=0;i< 10;i++){
            for(int j=0;j<10;j++){
                Pane pane = new Pane();
                pane.setMinWidth(10);
                pane.setMaxHeight(100);
                playerShipsAttackBoard.add(pane,i,j);
            }
        }

        //playerShipsAttackBoard.setPadding(new Insets(250,250,250,250));
        mainPane.getChildren().add(playerShipsAttackBoard);
        Scene scene = new Scene(mainPane, 1200,800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

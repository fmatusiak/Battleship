package battleship.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Cell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Board extends Application {

    private Image backgroundBoard = new Image("file:src/main/resources/img/background.jpg");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BackgroundSize backgroundSize = new BackgroundSize(1200, 800, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(backgroundBoard, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setBackground(background);

        Scene scene = new Scene(grid, 1200, 900);

        primaryStage.setTitle("Battleship");
        primaryStage.setScene(scene);
        primaryStage.show();





       /* BackgroundSize backgroundSize = new BackgroundSize(800,800,true,true,true,false);
        BackgroundImage backgroundImage = new BackgroundImage(backgroundBoard, BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setBackground(background);

        Scene scene = new Scene(grid, 800,800, Color.SILVER);




        primaryStage.setTitle("Battleship");
        primaryStage.setScene(scene);
        primaryStage.show();*/





       /* GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(1000);
        grid.setVgap(1000);
        grid.setPadding(new Insets(250,250,250,250));

        Scene scene = new Scene(grid, 1200,800);
        primaryStage.setScene(scene);*/
    }
}

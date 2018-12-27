package battleship.message;

import battleship.result.CheckerResult;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

public class Message {
    static final String WINNER_USER = "WINNER USER";
    static final String WINNER_COMPUTER = "WINNER COMPUTER";
    static final String NEW_GAME_INFORMATION = "Select your ships on the Player panel.\n" +
            "Start with one 4-point ship,\n then add 2 x 3-point ships, \n then 3 x 2-point ships , \n  finally 4 x 1-point ships.";

    CheckerResult checkerResult;

    public Message(){

    }

    public Message(CheckerResult checkerResult) {
        this.checkerResult = checkerResult;
    }

    public void showMessageNewGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("NEW GAME");
        alert.setHeaderText("INSTRUCTION");
        alert.setContentText(NEW_GAME_INFORMATION);
        alert.showAndWait();
    }


    public boolean showMessageWinner() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("END THE GAME");
        alert.setHeaderText("RESULTS");
        if (checkerResult.checkWhoIsWin() == 1) {
            alert.setContentText(WINNER_USER);
            alert.showAndWait();
            return true;
        } else if (checkerResult.checkWhoIsWin() == 2) {
            alert.setContentText(WINNER_COMPUTER);
            alert.showAndWait();
            return true;
        }
        return false;
    }

}

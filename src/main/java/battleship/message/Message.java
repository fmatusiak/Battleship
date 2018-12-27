package battleship.message;

import battleship.result.CheckerResult;
import javafx.scene.control.Alert;

public class Message {
    static final String WINNER_USER = "WINNER USER";
    static final String WINNER_COMPUTER = "WINNER COMPUTER";
    CheckerResult checkerResult;

    public Message(CheckerResult checkerResult) {
        this.checkerResult = checkerResult;
    }

    public void showMessageWinner() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("END THE GAME");
        alert.setHeaderText("RESULTS");
        if (checkerResult.checkWhoIsWin() == 1) {
            alert.setContentText(WINNER_USER);
            alert.showAndWait();
        } else if (checkerResult.checkWhoIsWin() == 2) {
            alert.setContentText(WINNER_COMPUTER);
            alert.showAndWait();
        }

    }

}

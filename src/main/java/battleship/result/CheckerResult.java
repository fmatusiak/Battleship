package battleship.result;

public class CheckerResult {
    Result result;

    public CheckerResult(Result result) {
        this.result = result;
    }

    public int checkWhoIsWin() {
        if (result.getShipsComputer() == 0) {
            return 1;
        } else if (result.getShipsPlayer() == 0) {
            return 2;
        }
        return 0;
    }

}

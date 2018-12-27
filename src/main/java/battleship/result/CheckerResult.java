package battleship.result;

public class CheckerResult {
    Result result;

    public CheckerResult(Result result) {
        this.result = result;
    }

    public int checkWhoIsWin() {
        if (result.getCountShipsComputer() == 0) {
            System.out.println("Winner User");
            return 1;
        } else if (result.getCountShipsUser() == 0) {
            System.out.println("Winner Computer");
            return 2;
        }
        return 0;
    }

}

package battleship.ship;

public class CounterShips {
    private int oneShips = 4;
    private int twoShips = 3;
    private int threeShips = 2;
    private int fourShips = 1;

    public int substractOneShips() {
        if (fourShips <= 0) {
            return 0;
        }
        return oneShips--;
    }

    public int substractTwoShips() {
        if (fourShips <= 0) {
            return 0;
        }
        return twoShips--;
    }

    public int substractThreeShips() {
        if (fourShips <= 0) {
            return 0;
        }
        return threeShips--;
    }

    public int substractFourShips() {
        if (fourShips <= 0) {
            return 0;
        }
        return fourShips--;
    }

    public int getOneShips() {
        return oneShips;
    }

    public int getTwoShips() {
        return twoShips;
    }

    public int getThreeShips() {
        return threeShips;
    }

    public int getFourShips() {
        return fourShips;
    }

    public boolean checkCounterShips() {
        int sum = oneShips + twoShips + threeShips + fourShips;
        if (sum == 0) {
            return true;
        }

        return false;
    }
}

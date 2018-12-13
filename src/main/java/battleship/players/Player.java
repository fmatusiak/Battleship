package battleship.players;

public class Player {
    private String playerId;

    private int counterSunkenShips = 0;
    private int counterHitShips = 0;

    public Player(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public int getSunkenShips() {
        return counterSunkenShips;
    }

    public int getHitShips() {
        return counterHitShips;
    }

    public void addCounterSunkenShips() {
        counterSunkenShips++;
    }

    public void addCounterHitShips() {
        counterHitShips++;
    }

}

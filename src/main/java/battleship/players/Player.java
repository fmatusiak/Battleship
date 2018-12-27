package battleship.players;

public class Player {
    private String playerId;

    private int counterHitPlayer = 0;
    private int counterSunkPlayer = 0;
    private int counterMissPlayer = 0;

    public Player(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void addCounterHitPlayer() {
        counterHitPlayer++;
    }

    public void addCounterSunkPlayer() {
        counterSunkPlayer++;
    }

    public void addCounterMissPlayer() {
        counterMissPlayer++;
    }

    public int getCounterHitPlayer() {
        return counterHitPlayer;
    }

    public int getCounterSunkPlayer() {
        return counterSunkPlayer;
    }

    public int getCounterMissPlayer() {
        return counterMissPlayer;
    }
}

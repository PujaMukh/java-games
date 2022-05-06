package game.connect4oop;

public class TurnManager {

    private int maxPlayers;
    private int turn;

    public TurnManager(int numPlayers) {
        this.maxPlayers = numPlayers;
        this.turn = 0;
    }

    public int getTurn() {
        return turn;
    }

    public void nextTurn() {
        turn = (turn+1)%maxPlayers;
    }
}

package game.connect4oop;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    List<Player> players;

    public PlayerManager(int numPlayers) {
        this.players = createPlayers(numPlayers);
    }

    public Player getPlayer(int turn) {
        return players.get(turn);
    }

    private List<Player> createPlayers(int numPlayers) {
        List<Player> players = new ArrayList<>();
        for(int i=1; i<=numPlayers; i++) {
            players.add(new Player(i));
        }
        return players;
    }
}

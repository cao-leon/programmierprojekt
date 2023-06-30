package app;

import model.Magician;

public class MagicGame {
    private final Magician player;

    public MagicGame(Magician player) {
        this.player = player;
    }

    public void run() {
        System.out.println("The game has started. Or not?");
    }

    public Magician getPlayer() {
        return player;
    }
}
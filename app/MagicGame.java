package app;

import model.Magician;

public class MagicGame {
    private final Magician player;

    public MagicGame(Magician player) {
        this.player = player;
    }

    public void run() {
  System.out.println("The game has started.");

  boolean gameEnded = false;
  
  while (!gameEnded) {
    if (/* Bedingung für Spielende */) {
      gameEnded = true;
    }
  }
  
  System.out.println("The game has ended.");
}



    public Magician getPlayer() {
        return player;
    }
}
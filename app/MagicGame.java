package app;

import model.Magician;

// 1. Commit
public class MagicGame {

  private final Magician magician;

  public MagicGame(Magician magician) {
    this.magician = magician;
  }

  public void run(){
    System.out.println("The game has started. Or not?");
  }

  public Magician getMagician() {
    return magician;
  }
}

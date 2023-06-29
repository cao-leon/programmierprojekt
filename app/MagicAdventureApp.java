package app;

import static java.util.Objects.nonNull;

import model.Magician;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

// @author Leon Cao, Amir Naderi
public class MagicAdventureApp {

  public static final String SAVE_FILE_NAME = "save";
  private MagicGame game;
  private boolean gameRunning = true;

  public static void main(String[] args) {
    System.out.println("Welcome to the Magic Adventure game");
    System.out.println("========================================\n");

    MagicAdventureApp app = new MagicAdventureApp();

    while (true) {
      app.showMainMenu();
      String choice = app.readUserInput();
      app.handleUserInput(choice);
      System.out.println("====================");
    }
  }

  private void showMainMenu() {
    System.out.println("You're in the main menu");
    System.out.println("What do you want to do next?");
    System.out.println("(1) Start new game");

    if (hasRunningGame()) {
      System.out.println("(2) resume game");
      System.out.println("(4) Save game");
      System.out.println("(5) Delete game");
    }

    if (hasSavedGame()) {
      System.out.println("(3) Load game");
    }

    System.out.println("(6) Quit");
    System.out.println("");
    System.out.println("Please choose a number between 1 and 6");
  }

  private String readUserInput() {
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();
    return userInput;

  }

  private void handleUserInput(String input) {
    switch (input) {
      case "1":
        startNewGame();
        break;
      case "2":
        if (hasRunningGame()) {
          continueGame();
        } else {
          System.out.println("There is no running game.");
        }
        break;
      case "3":
        if (hasSavedGame()) {
          loadGame();
        } else {
          System.out.println("There is no saved game.");
        }
        break;
      case "4":
        if (hasRunningGame()) {
          saveGame();
        } else {
          System.out.println("There is no running game.");
        }
        break;
      case "5":
        if (hasSavedGame()) {
          deleteGame();
        } else {
          System.out.println("There is no saved game.");
        }
        break;
      case "6":
        gameRunning = false;
        System.out.println("This game will end now.");
        break;
      default:
        System.out.println("Invalid input. Please choose a correct number between 1 and 6");
        break;
    }
  }

  private void startNewGame() {
    System.out.println("New Game started.");
    Magician magician = new Magician();
    MagicGame game = new MagicGame(magician); 
    game.run(); 
}

  private void continueGame() {
    this.game.run();
  }

  private void deleteGame() {
    if (new File(SAVE_FILE_NAME).delete()) {
      System.out.println("Game deleted!");
    }
  }

  private void saveGame() {
    try (FileOutputStream fos = new FileOutputStream(SAVE_FILE_NAME);
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      oos.writeObject(game.getMagician());
      oos.flush();
    } catch (Exception ex) {
      System.err.println("Something went wrong!" + ex);
      return;
    }
    System.out.println("Game saved!");

  }

  private void loadGame() {
    try (FileInputStream fis = new FileInputStream(SAVE_FILE_NAME);
         ObjectInputStream ois = new ObjectInputStream(fis)) {
      this.game = new MagicGame((Magician) ois.readObject());
    } catch (Exception ex) {
      System.err.println("Something went wrong!" + ex);
    }
  }

  private Boolean hasRunningGame() {
    return nonNull(game);
  }

  private Boolean hasSavedGame() {
    return new File(SAVE_FILE_NAME).exists();
  }


}
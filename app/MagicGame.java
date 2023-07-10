package app;

import model.Magician;
import model.Monster;
import model.MasterWizard;
import model.Spell;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Spells.ArcaneSpell;
import Spells.DarknessSpell;
import Spells.Fireball;
import Spells.IceSpell;
import Spells.ToxicSpell;

import java.util.Random;

public class MagicGame {
    private final Magician player;
    private boolean gameEnded;
    private Scanner scanner = new Scanner(System.in);

    public MagicGame(Magician player) {
        this.player = player;
        this.gameEnded = false;
    }

    public void run() {
        System.out.println("The game has started.");

        while (!gameEnded) {
            showGameMenu();
            String choice = readUserInput();
            handleGameMenuInput(choice);
            System.out.println("====================");
        }

        System.out.println("The game has ended.");
    }

    private void showGameMenu() {
        System.out.println("===== Game Menu =====");
        System.out.println("1. Start adventure: Go on a journey");
        System.out.println("2. Learn new spell: Learn a new spell");
        System.out.println("3. Improve spell: Improve a spell");
        System.out.println("4. Show stats: Display current statistics");
        System.out.println("5. Take a rest: Take a rest");
        System.out.println("6. Back to main menu: Main menu");
        System.out.println("");
        System.out.println("Please choose a number between 1 and 6");
    }

    private String readUserInput() {
        String userInput = scanner.nextLine();
        return userInput;
    }

    private void handleGameMenuInput(String input) {
        switch (input) {
            case "1":
                startAdventure();
                break;
            case "2":
                learnNewSpell();
                break;
            case "3":
                improveSpell();
                break;
            case "4":
                showStats();
                break;
            case "5":
                takeRest();
                break;
            case "6":
                gameEnded = true;
                System.out.println("Returning to main menu.");
                break;
            default:
                System.out.println("Invalid input. Please choose a number between 1 and 6");
                break;
        }
    }

    private void startAdventure() {
        int levelDifference;
        if (player.getLevel() == 1) {
            levelDifference = (int) (Math.random() * 2) + 1; // Generate a value between 1 and 2
        } else {
            levelDifference = (int) (Math.random() * 3) - 1; // Generate a value between -1 and 2
        }
        int monsterLevel = Math.max(player.getLevel() + levelDifference, 1); // Ensure monster level is at least 1

        Monster monster = new Monster("Monster", monsterLevel);

        System.out.println("Encountered a level " + monsterLevel + " monster!");

        // Battle logic
        while (true) {
            System.out.println("Choose a spell to attack the monster:");
            Spell spell = selectSpellToCast();
            int damage = spell.cast();

            monster.takeDamage(damage);
            System.out.println("You dealt " + damage + " damage to the monster!");

            if (monster.isDefeated()) {
                System.out.println("You defeated the monster!");
                int expGained = monsterLevel; // Gain experience equal to the defeated monster's level
                player.gainExperience(expGained);
                System.out.println("Gained " + expGained + " experience points.");

                if (player.getLevel() >= 5) {
                    System.out.println("Congratulations! You have reached Level 5 and won the game!");
                    gameEnded = true;
                }

                break;
            }

            int monsterDamage = monster.getAttackDamage();
            player.takeDamage(monsterDamage);
            System.out.println("The monster dealt " + monsterDamage + " damage to you.");

            if (player.isDefeated()) {
                System.out.println("Game Over. You were defeated by the monster.");
                gameEnded = true;
                break;
            }
        }
    }

    private Spell selectSpellToCast() {
        List<Spell> availableSpells = new ArrayList<>();
        availableSpells.add(new DarknessSpell(player.getLevel()));
        availableSpells.add(new ArcaneSpell(player.getLevel()));
        availableSpells.add(new Fireball(player.getLevel()));
        availableSpells.add(new IceSpell(player.getLevel()));
        availableSpells.add(new ToxicSpell(player.getLevel()));

        // Select a spell to cast (you can customize the selection logic here)
        int randomIndex = new Random().nextInt(availableSpells.size());
        return availableSpells.get(randomIndex);
    }

    private void learnNewSpell() {
        if (player.getLevel() > player.getKnownSpells().size()) {
            Spell newSpell = MasterWizard.learnSpell(player.getLevel());
            player.addSpell(newSpell);
            System.out.println("You have learned a new spell: " + newSpell.getName());
        } else {
            System.out.println("You cannot learn a new spell at the moment.");
}
}

private void improveSpell() {
    List<Spell> knownSpells = player.getKnownSpells();

    if (knownSpells.isEmpty()) {
        System.out.println("You don't have any spells to improve.");
        return;
    }

    System.out.println("Select a spell to improve:");
    for (int i = 0; i < knownSpells.size(); i++) {
        Spell spell = knownSpells.get(i);
        System.out.println((i + 1) + ". " + spell.getName());
    }

    int choice = Integer.parseInt(readUserInput());

    if (choice >= 1 && choice <= knownSpells.size()) {
        Spell selectedSpell = knownSpells.get(choice - 1);
        if (selectedSpell.getLevel() < player.getLevel()) {
            System.out.println("Training " + selectedSpell.getName() + "...");
            player.train(selectedSpell);

            if (selectedSpell.getLevel() > 1) {
                System.out.println(selectedSpell.getName() + " has been improved to Level " + selectedSpell.getLevel() + "!");
            } else {
                System.out.println(selectedSpell.getName() + " has been improved!");
            }
        } else {
            System.out.println("You cannot improve the selected spell at the moment. The spell level cannot exceed your current level.");
        }
    } else {
        System.out.println("Invalid choice. Please select a valid spell number.");
    }
}

private void showStats() {
    System.out.println(player);
}

private void takeRest() {
    int currentExp = player.getExperience();
    if (currentExp > 0) {
        player.decreaseExperience(1);
        player.increaseHealth(100);
        System.out.println("You took a rest. Experience points decreased by 1, health increased by 100.");
    } else {
        System.out.println("You cannot take a rest. Experience points are already 0.");
    }
}

public Magician getPlayer() {
    return player;
}

}
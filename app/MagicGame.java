package app;

import model.Magician;
import model.Monster;
import model.MasterWizard;
import model.Spell;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
        int monsterLevel = player.getLevel() + (int) (Math.random() * 3); // Generate a monster level between Magician's level - 1 and Magician's level + 1
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
                int expGained = monster.getLevel();
                player.gainExperience(expGained);
                System.out.println("Gained " + expGained + " experience points.");
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
        availableSpells.add(new ElectroschockSpell(player.getLevel()));
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

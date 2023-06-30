package model;

import java.io.Serializable;
import java.util.Scanner;

import utils.StopWatch;

public class Spell implements Serializable {
    private static final long serialVersionUID = 1L;
    private String incantation;
    private int damage;
    private int hitProbability;
    private int level;

    public Spell(String incantation, int damage, int hitProbability, int level) {
        this.incantation = incantation;
        this.damage = damage;
        this.hitProbability = hitProbability;
        this.level = level;
    }

    public String getIncantation() {
        return incantation;
    }

    public void setIncantation(String incantation) {
        this.incantation = incantation;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHitProbability() {
        return hitProbability;
    }

    public void setHitProbability(int hitProbability) {
        this.hitProbability = hitProbability;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void train() {
        System.out.println("Spell: " + incantation);
        System.out.println("Press enter when ready.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Wait for player's input
        System.out.println("Enter the spell: ");
        String input = scanner.nextLine();

        StopWatch stopWatch = new StopWatch(); // Create an instance of StopWatch
        stopWatch.start(); // Start the timer

        // Code for checking if the input is correct
        if (input.equals(incantation)) {
            // Code for improving the spell
            long timeAllowed = (incantation.length() / (level + 1)) * 1000;
            if (stopWatch.isWithin(timeAllowed)) {
                System.out.println("Spell successfully casted!");
                // Code for improving the spell
            } else {
                System.out.println("Spell casting failed. Time exceeded.");
                // Code for failed action
            }
        } else {
            System.out.println("Spell casting failed. Incorrect input.");
            // Code for failed action
        }

        stopWatch.stop(); // Stop the timer
        System.out.println("Elapsed time: " + stopWatch.getElapsedTime() + " milliseconds.");

        scanner.close();
    }
}

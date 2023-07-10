package model;

import java.io.Serializable;
import java.util.Scanner;

import utils.StopWatch;

public class Spell implements Serializable {
    private static final long serialVersionUID = 1L;
    private String incantation;
    private String name;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBaseValue() {
        return damage;
    }
    
    public void train() {
        System.out.println("Spell: " + incantation);
        System.out.println("Press enter when ready.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
    
        long timeAllowed = (incantation.length() / (level + 1)) * 1000;
        if (stopWatch.isWithin(timeAllowed)) {
            System.out.println("Spell successfully casted!");
        } else {
            System.out.println("Spell casting failed. Time exceeded.");
        }
    
        stopWatch.stop(); // Stop the timer
        System.out.println("Elapsed time: " + stopWatch.getElapsedTime() + " milliseconds.");
    
        scanner.close();
    }
    


    public int cast() {
        train(); // Call the train() method to cast the spell
        return damage; // Return the damage of the spell
    }
}
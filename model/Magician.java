package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Magician implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  private List<Spell> spells;
  private int experiencePoints;
  private int lifePoints;

  public Magician(String name) {
    this.name = name;
    this.spells = new ArrayList<>();
    this.experiencePoints = 0;
    this.lifePoints = 1000;
  }

  public Magician() {
    this.name = "Default Name";
    this.spells = new ArrayList<>();
    this.experiencePoints = 0;
    this.lifePoints = 1000;
  }

  public int getLevel() {
    return (int) Math.sqrt(experiencePoints);
  }

  public String getName() {
    return name;
  }

  public void gainExperience(int experience) {
    this.experiencePoints += experience;
  }

  public void takeDamage(int damage) {
    this.lifePoints -= damage;
  }

  public boolean isDefeated() {
    return lifePoints <= 0;
  }

  public List<Spell> getKnownSpells() {
    return spells;
  }

  public void addSpell(Spell spell) {
    spells.add(spell);
  }

  public int getExperience() {
    return experiencePoints;
  }

  public void decreaseExperience(int amount) {
    experiencePoints -= amount;
  }

  public void increaseHealth(int amount) {
    lifePoints += amount;
  }

  public void learnSpell(Spell spell) {
    if (spells.size() < 5) {
      spells.add(spell);
      System.out.println("Magician " + name + " has learned the spell: " + spell.getName());
    } else {
      System.out.println("Magician " + name + " cannot learn more than 5 spells.");
    }
  }

  @Override
  public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Name: ").append(name).append("\n");
      sb.append("Health Points: ").append(lifePoints).append("\n");
      sb.append("Level: ").append(getLevel()).append("\n");
      sb.append("Spells:").append("\n");
      for (Spell spell : spells) {
          sb.append("- ").append(spell.getName()).append(" (Level ").append(spell.getLevel()).append(") - ").append(spell.getBaseValue()).append("\n");
      }
      return sb.toString();
  }
  
}
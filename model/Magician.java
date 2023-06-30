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

  public void learnSpell(Spell spell) {
    if (spells.size() < 5) {
      spells.add(spell);
      System.out.println("Magician " + name + " has learned the spell: " + spell.getName());
    } else {
      System.out.println("Magician " + name + " cannot learn more than 5 spells.");
    }
  }
  
}

package Spells;

import model.Spell;

public class Fireball extends Spell {
    public Fireball(int currentLevel) {
        super("Fireball", getSpellDamage(currentLevel), getSpellHitProbability(currentLevel), 2);
    }

    private static int getSpellDamage(int currentLevel) {
        if (currentLevel >= 1) {
            return 50;
        }
        return 0; // or a default value
    }

    private static int getSpellHitProbability(int currentLevel) {
        if (currentLevel >= 1) {
            return 80;
        }
        return 0; // or a default value
    }
}

package Spells;

import model.Spell;

public class ToxicSpell extends Spell {
    public ToxicSpell(int currentLevel) {
        super("ToxicSpell", getSpellDamage(currentLevel), getSpellHitProbability(currentLevel), 5);
    }

    private static int getSpellDamage(int currentLevel) {
        if (currentLevel >= 5) {
            return 70;
        }
        return 0; // or a default value
    }

    private static int getSpellHitProbability(int currentLevel) {
        if (currentLevel >= 5) {
            return 75;
        }
        return 0; // or a default value
    }
}

package Spells;

import model.Spell;

public class DarknessSpell extends Spell {
    public DarknessSpell(int currentLevel) {
        super("DarknessSpell", getSpellDamage(currentLevel), getSpellHitProbability(currentLevel), 3);
    }

    private static int getSpellDamage(int currentLevel) {
        if (currentLevel >= 2) {
            return 40;
        }
        return 0; // or a default value
    }

    private static int getSpellHitProbability(int currentLevel) {
        if (currentLevel >= 2) {
            return 70;
        }
        return 0; // or a default value
    }
}
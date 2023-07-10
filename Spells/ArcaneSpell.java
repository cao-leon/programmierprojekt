package Spells;

import model.Spell;

public class ArcaneSpell extends Spell {
    public ArcaneSpell(int currentLevel) {
        super("ArcaneSpell", getSpellDamage(currentLevel), getSpellHitProbability(currentLevel), 3);
    }

    private static int getSpellDamage(int currentLevel) {
        if (currentLevel >= 3) {
            return 60;
        }
        return 0; // or a default value
    }

    private static int getSpellHitProbability(int currentLevel) {
        if (currentLevel >= 3) {
            return 90;
        }
        return 0; // or a default value
    }
}

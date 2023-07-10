package Spells;

import model.Spell;

public class IceSpell extends Spell {
    public IceSpell(int currentLevel) {
        super("IceSpell", getSpellDamage(currentLevel), getSpellHitProbability(currentLevel), 2);
    }

    private static int getSpellDamage(int currentLevel) {
        if (currentLevel >= 4) {
            return 55;
        }
        return 0; // or a default value
    }

    private static int getSpellHitProbability(int currentLevel) {
        if (currentLevel >= 4) {
            return 80;
        }
        return 0; // or a default value
    }
}

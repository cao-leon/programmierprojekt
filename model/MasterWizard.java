package model;

public class MasterWizard {
    public static Magician createMagician(String name) {
        return new Magician(name);
    }

    public static Spell learnSpell(int currentLevel) {
        // Implement the logic to learn a new spell here
        String spellName;
        int spellDamage;
        int spellHitProbability;
        int spellLevel;

        if (currentLevel >= 2) {
            spellName = "DarnessSpell";
            spellDamage = 40;
            spellHitProbability = 70;
            spellLevel = 2;
        } else if (currentLevel >= 3) {
            spellName = "ArcaneSpell";
            spellDamage = 60;
            spellHitProbability = 90;
            spellLevel = 3;
        } else if (currentLevel >= 4) {
            spellName = "IceSpell";
            spellDamage = 55;
            spellHitProbability = 80;
            spellLevel = 4;
        } else if (currentLevel >= 5) {
            spellName = "ToxicSpell";
            spellDamage = 70;
            spellHitProbability = 75;
            spellLevel = 5;
        } else {
            spellName = "Fireball";
            spellDamage = 50;
            spellHitProbability = 80;
            spellLevel = 1;
        }

        return new Spell(spellName, spellDamage, spellHitProbability, spellLevel);
    }

    public static void teachSpell(Magician magician) {
        Spell newSpell = generateSpell();
        magician.learnSpell(newSpell);
        System.out.println("Magician " + magician.getName() + " has learned a new spell: " + newSpell.getName());
    }

    private static Spell generateSpell() {
        // Generate a new spell here
        String spellName = "Fireball";
        int spellDamage = 50;
        int spellHitProbability = 80;
        int spellLevel = 1;

        return new Spell(spellName, spellDamage, spellHitProbability, spellLevel);
    }
}

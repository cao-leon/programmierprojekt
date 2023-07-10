package model;

public class Monster {
    private String name;
    private int level;
    private int lifePoints;
    private int attackDamage;

    public Monster(String name, int level) {
        this.name = name;
        this.level = level;
        this.lifePoints = level * 100;
        this.attackDamage = level * 50;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void takeDamage(int damage) {
        lifePoints -= damage;
        
    }

    public boolean isDefeated() {
        return lifePoints <= 0;
    }
}




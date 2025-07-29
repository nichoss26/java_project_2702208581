package character;

import java.util.Random;

public class StrengthMonster extends Monster {
    protected int armor;

    public StrengthMonster(String name, int baseDamage, int health, int armor) {
        super(name, baseDamage, health);
        this.armor = armor;
    }

    @Override
    public void attack(Karakter karakter) {
        int totalDamage = Math.max(0, baseDamage - karakter.getArmor());
        karakter.receiveDamage(totalDamage);
    }
}


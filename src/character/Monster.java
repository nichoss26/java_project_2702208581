package character;

import java.util.Scanner;

public class Monster {
    protected String name;
    protected int baseDamage;
    protected int health;

    public Monster(String name, int baseDamage, int health) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getHealth() {
        return health;
    }

    public void receiveDamage(int damage) {
        health -= damage;
    }

    public void attack(Karakter karakter) {
        int totalDamage = baseDamage;
        karakter.receiveDamage(totalDamage);
    }
    
    public void monsterInformation() {
        System.out.println("Monster Information");
        System.out.println("===================================");
        System.out.println("|Name            : " + getName());
        System.out.println("|Health          : " + getHealth());
        System.out.println("|Damage          : " + getBaseDamage());
        System.out.println("===================================");
    }

}



package model;

import java.util.Random;
import java.util.Scanner;

public class StrenghtType {

    private int armor;
    Scanner scan = new Scanner(System.in);
    
    public StrenghtType(String name) {
        super();
        this.name = name;
        Random rand = new Random();
        damage = rand.nextInt(11) + 20;
        health = rand.nextInt(11)+200-damage;
        armor = rand.nextInt(21)+20;
    }
    
    
    public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int health;
    private int damage;
    private String name;
    
    public void monsterInformation() {
        System.out.println("Monster Information");
        System.out.println("===================================");
        System.out.println("|Name            : " + getName());
        System.out.println("|Health          : " + getHealth());
        System.out.println("|Damage          : " + getDamage());
        System.out.println("===================================");
    }



    public void attackPlayer(UserTurn player) {
        int newHealth = player.getHealth() - damage;
        player.setHealth(newHealth);
        
        System.out.println("   __  ___              __              ______");
        System.out.println("  /  |/  /__  ___  ___ / /____ ____    /_  __/_ _________");
        System.out.println(" / /|_/ / _ \\/ _ \\(_-</ __/ -_) __/     / / / // / __/ _ \\");
        System.out.println("/_/  /_/\\___/_//_/___/\\__/\\__/_/       /_/  \\_,_/_/ /_//_/");
        System.out.println("\nMonster is going to attack\n");
        System.out.println(getName() + " is attacking with a base damage of " + getDamage());
        System.out.println(getName() + " is a Strength hero, using skill gave bonus damage " + getArmor());
        System.out.println("\nReceive Damage " + (player.getDamage() + getDamage() - getArmor()));
        System.out.println("\nEnter To Continue....");
        scan.nextLine();
    }

}


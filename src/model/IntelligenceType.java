package model;

import java.util.Random;
import java.util.Scanner;

public class IntelligenceType  {

	private String name;
	private int health;
	private int damage;
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	
    public IntelligenceType(String name) {
		super();
		this.name = name;
		// 30 -49
		damage=rand.nextInt(10)+10 + rand.nextInt(20)+30;
		health=rand.nextInt(11)+100;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
        System.out.println(getName() + " is attacking with a base damage of " + String.format("%d", getDamage()));
        System.out.println(getName() + " is an Intelligence hero, using skill gave bonus damage " + String.format("%d", getDamage()));
        System.out.println("\nReceive Damage " + String.format("%d", player.getDamage() + getDamage()));
        System.out.println("\nEnter To Continue....");
        scan.nextLine();
    }


}

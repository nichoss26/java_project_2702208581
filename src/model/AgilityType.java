package model;

import java.util.Random;
import java.util.Scanner;

public class AgilityType  {

	private int critical;
	private int damage;
	private int health;
	private String name;
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	
	public AgilityType(String name) {
		super();
		this.name = name;
		critical=rand.nextInt(3)+1;
		damage = rand.nextInt(11)+40;
		health=rand.nextInt(11)+100-damage;
	}

	
	public int getCritical() {
		return critical;
	}

	public void setCritical(int critical) {
		this.critical = critical;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}



	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
        int totalDamage = damage * (1 + critical / 10);
        
        int newHealth = player.getHealth() - (int)totalDamage;
        player.setHealth(newHealth);
        
        System.out.println("\n   __  ___              __              ______");
        System.out.println("  /  |/  /__  ___  ___ / /____ ____    /_  __/_ _________");
        System.out.println(" / /|_/ / _ \\/ _ \\(_-</ __/ -_) __/     / / / // / __/ _ \\");
        System.out.println("/_/  /_/\\___/_//_/___/\\__/\\__/_/       /_/  \\_,_/_/ /_//_/");
        System.out.println("\nMonster is going to attack\n");
        System.out.printf("%s is attacking with a base damage of %d\n", name, totalDamage);
        System.out.printf("%s is an Agility hero, using skill gave bonus damage %d", name, (totalDamage - damage));
        System.out.println("\nReceive Damage " + totalDamage + "\n");
        System.out.println("Enter To Continue....");
        scan.nextLine();
    }



}

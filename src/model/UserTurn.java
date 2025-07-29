package model;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import models.BoughtList;
import models.DefensiveItem;
import models.Item;
import models.ItemReader;
import models.OffensiveItem;
import models.SpellItem;

public class UserTurn  {

	private int mana;
	private int health;
	private int damage;

	
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	
	public UserTurn(int mana, int health, int damage) {
		super();
		this.mana = mana;
		this.health = health;
		this.damage = damage;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
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
	
    public void storeMana() {
        mana += 10;
        System.out.println("\nStoring mana......");
        System.out.println("Added 10.00 mana");
        System.out.println("Enter To Continue....");
        scan.nextLine();
    }
	
	public void menu() {
        System.out.println("\nYour Choice Turn\n");
        System.out.println("1. Pure Attack");
        System.out.println("2. Attack With Item");
        System.out.println("3. Store Mana");
        System.out.print(">> ");	
        }
	
    public void monsterInformation(String email, int money) {
        System.out.println("User Information " + email);
        System.out.println("===================================");
        System.out.println("|Health            : " + getHealth());
        System.out.println("|Money             : " + money);
        System.out.println("|Mana              : " + getMana());
        System.out.println("|Damage            : " + getDamage());
        System.out.println("===================================");
        System.out.println("Press enter to continue...");
        scan.nextLine();
        System.out.println("");
    }
    
    public void itemAttack(List<Item> items, String itemType, String id) {

        for (Item item : items) {
            if (itemType.equals("Offensive")) {
                if (item instanceof OffensiveItem) {
                    OffensiveItem offensiveItem = (OffensiveItem) item;
                    if (offensiveItem.getId().equals(id)) {
                        damage += offensiveItem.getDamage();
                        offensiveItem.setMaxUse(offensiveItem.getMaxUse() - 1);
                        
                        
                        
                        
                        
                    }
                }
            } else if (itemType.equals("Defensive")) {
                if (item instanceof DefensiveItem) {
                    DefensiveItem defensiveItem = (DefensiveItem) item;
                    if (defensiveItem.getId().equals(id)) {
                        health += defensiveItem.getDeflect();
                        defensiveItem.setMaxUse(defensiveItem.getMaxUse() - 1);
                    }
                }
            } else if (itemType.equals("Spell")) {
                if (item instanceof SpellItem) {
                    SpellItem spellItem = (SpellItem) item;
                    if (spellItem.getId().equals(id)) {
                        damage += spellItem.getDamage();
                        mana += spellItem.getMana();
                    }
                }
            } 
        }
    }

	
    public void attackIntellegence(IntelligenceType enemy, ItemReader itemReader, List<BoughtList> boughtList, List<Item> items) {
    	int choice=0;
    	do {
    		menu();
    		choice=scan.nextInt();scan.nextLine();
    	}while(choice<1 && choice>3);
    	
    	if(choice==1) {
    		 int newHealth = enemy.getHealth() - getDamage();
	        enemy.setHealth(newHealth);
	
	        System.out.println("   ___  __  __           __    _");
	        System.out.println("  / _ |/ /_/ /____ _____/ /__ (_)__  ___ _");
	        System.out.println(" / __ / __/ __/ _ `/ __/  '_// / _ \\/ _ `/");
	        System.out.println("/_/ |_/\\__/\\__/\\_,_/\\__/_/\\_\\/\\_\\/_/\\_, /");
	        System.out.println("                                   /___/\n");
	        System.out.println("Attacking " + enemy.getName());
	        System.out.println(enemy.getName() + " got damage " + String.format("%d", getDamage()));
	        System.out.println("\nEnter To Continue....\n");
	        scan.nextLine();
    	}else if(choice==2) {
    		itemReader.printBoughtList(boughtList);
    		System.out.print("Input ID : ");
    		String masukan;
    		masukan=scan.nextLine();
    		itemAttack(items, "Spell", masukan);
    		itemAttack(items, "Offensive", masukan);
    		itemAttack(items, "Defensive", masukan);
    		
    		int newHealth = enemy.getHealth() - getDamage();
	        enemy.setHealth(newHealth);
	        
	        System.out.println("   ___  __  __           __    _");
	        System.out.println("  / _ |/ /_/ /____ _____/ /__ (_)__  ___ _");
	        System.out.println(" / __ / __/ __/ _ `/ __/  '_// / _ \\/ _ `/");
	        System.out.println("/_/ |_/\\__/\\__/\\_,_/\\__/_/\\_\\/\\_\\/_/\\_, /");
	        System.out.println("                                   /___/\n");
	        System.out.println("Attacking " + enemy.getName() + " Using Items !");
	        System.out.println(enemy.getName() + " got damage " + String.format("%d", getDamage()));
	        System.out.println("\nEnter To Continue....\n");
	        scan.nextLine();
    		
    		
    	}else if(choice==3) {
    		storeMana();
    	}else {
    		System.out.println("Invalid Input, Please Input Between 1-3!");
    	}
    	
    	
    	
       
    }

    public void attackAgility(AgilityType enemy, ItemReader itemReader, List<BoughtList> boughtList ,List<Item> items ) {
    	int choice=0;
    	do {
    		menu();
    		choice=scan.nextInt();scan.nextLine();
    	}while(choice<1 && choice>3);
    	
        

        	if(choice==1) {
        		int newHealth = enemy.getHealth() - getDamage();
                enemy.setHealth(newHealth);
		        System.out.println("   ___  __  __           __    _");
		        System.out.println("  / _ |/ /_/ /____ _____/ /__ (_)__  ___ _");
		        System.out.println(" / __ / __/ __/ _ `/ __/  '_// / _ \\/ _ `/");
		        System.out.println("/_/ |_/\\__/\\__/\\_,_/\\__/_/\\_\\/\\_\\/_/\\_, /");
		        System.out.println("                                   /___/\n");
		        System.out.println("Attacking " + enemy.getName());
		        System.out.println(enemy.getName() + " got damage " + String.format("%d", getDamage()));
		        System.out.println("\nEnter To Continue....\n");
		        scan.nextLine();
        	} else if(choice==2) {
        		itemReader.printBoughtList(boughtList);
        		String masukan;
        		System.out.print("Input ID : ");
        		masukan=scan.nextLine();
        		itemAttack(items, "Spell", masukan);
        		itemAttack(items, "Offensive", masukan);
        		itemAttack(items, "Defensive", masukan);
        		
        		int newHealth = enemy.getHealth() - getDamage();
                enemy.setHealth(newHealth);
                System.out.println("   ___  __  __           __    _");
		        System.out.println("  / _ |/ /_/ /____ _____/ /__ (_)__  ___ _");
		        System.out.println(" / __ / __/ __/ _ `/ __/  '_// / _ \\/ _ `/");
		        System.out.println("/_/ |_/\\__/\\__/\\_,_/\\__/_/\\_\\/\\_\\/_/\\_, /");
		        System.out.println("                                   /___/\n");
		        System.out.println("Attacking " + enemy.getName() + " Using Items !");
		        System.out.println(enemy.getName() + " got damage " + String.format("%d", getDamage()));
		        System.out.println("\nEnter To Continue....\n");
		        scan.nextLine();
        	}else if(choice==3) {
        		storeMana();
        	}else {
        		System.out.println("Invalid Input, Please Input Between 1-3!");
        	}
        
    }

    
    public void attackStrenght(StrenghtType enemy, ItemReader itemReader, List<BoughtList> boughtList,  List<Item> items) {
    	int choice=0;
    	do {
    		menu();
    		choice=scan.nextInt();scan.nextLine();
    	}while(choice<1 && choice>3);
    	
    	

        
		if(choice==1) {
	        int armorDifference = getDamage() - enemy.getArmor();
	        int newHealth;

	        if (armorDifference < 0) {
	            enemy.setHealth(enemy.getHealth());
	            newHealth = enemy.getHealth();
	        } else {
	            newHealth = enemy.getHealth() - getDamage() + enemy.getArmor();
	            enemy.setHealth(newHealth);
	        }
			System.out.println("   ___  __  __           __    _");
	        System.out.println("  / _ |/ /_/ /____ _____/ /__ (_)__  ___ _");
	        System.out.println(" / __ / __/ __/ _ `/ __/  '_// / _ \\/ _ `/");
	        System.out.println("/_/ |_/\\__/\\__/\\_,_/\\__/_/\\_\\/\\_\\/_/\\_, /");
	        System.out.println("                                   /___/\n");
	        System.out.println("Attacking " + enemy.getName());
	        System.out.println(enemy.getName() + " got damage " + String.format("%d", getDamage()));
	        System.out.println("\nEnter To Continue....\n");
	        scan.nextLine();
		    	} else if(choice==2) {
		    		itemReader.printBoughtList(boughtList);
		    		String masukan;
		    		System.out.print("Input ID :");
		    		masukan=scan.nextLine();
		    		itemAttack(items, "Spell", masukan);
		    		itemAttack(items, "Offensive", masukan);
		    		itemAttack(items, "Defensive", masukan);
		    		
		    		  int armorDifference = getDamage() - enemy.getArmor();
		  	        int newHealth;

		  	        if (armorDifference < 0) {
		  	            enemy.setHealth(enemy.getHealth());
		  	            newHealth = enemy.getHealth();
		  	        } else {
		  	            newHealth = enemy.getHealth() - getDamage() + enemy.getArmor();
		  	            enemy.setHealth(newHealth);
		  	        }
		  			System.out.println("   ___  __  __           __    _");
		  	        System.out.println("  / _ |/ /_/ /____ _____/ /__ (_)__  ___ _");
		  	        System.out.println(" / __ / __/ __/ _ `/ __/  '_// / _ \\/ _ `/");
		  	        System.out.println("/_/ |_/\\__/\\__/\\_,_/\\__/_/\\_\\/\\_\\/_/\\_, /");
		  	        System.out.println("                                   /___/\n");
		  	        System.out.println("Attacking " + enemy.getName() + " Using Item !");
		  	        System.out.println(enemy.getName() + " got damage " + String.format("%d", getDamage()));
		  	        System.out.println("\nEnter To Continue....\n");
		  	        scan.nextLine();
		    		
		    		
		    	}else if(choice==3) {
		    		storeMana();
		    	}else {
		    		System.out.println("Invalid Input, Please Input Between 1-3!");
		    	}

        
    }


	
}

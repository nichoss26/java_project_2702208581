package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemReader {

	
	public List<Item> readItemsFromFile(String filename) throws IOException {
	    List<Item> items = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split("#");
	            String id = parts[0];
	            String name = parts[1];
	            String type = parts[2];
	            int price = Integer.parseInt(parts[3]);

	            switch (type.toLowerCase()) {
	                case "spell":
	                    int damage = Integer.parseInt(parts[4]);
	                    int mana = Integer.parseInt(parts[5]);
	                    items.add(new SpellItem(id, name, price, damage, mana));
	                    break;
	                case "offensive":
	                    int damageOffensive = Integer.parseInt(parts[4]);
	                    int maxUseOffensive = Integer.parseInt(parts[5]);
	                    items.add(new OffensiveItem(id, name, price, damageOffensive, maxUseOffensive));
	                    break;
	                case "defensive":
	                    int deflect = Integer.parseInt(parts[4]);
	                    int maxUseDefensive = Integer.parseInt(parts[5]);
	                    items.add(new DefensiveItem(id, name, price, deflect, maxUseDefensive));
	     
	                    break;
	                default:
	                    System.err.println("Invalid item type: " + type);
	            }
	        }
	    }

	    return items;
	}


    public void printItems(List<Item> items, int money, String itemType) {
        System.out.println("Your money is " + money);

      if (itemType.equals("Offensive")) {
      System.out.println("============================================================================================");
      System.out.printf("|%-10s|%-30s|%-15s|%-10s|%-10s|%-10s|\n", "ID", "Name", "Type", "Price", "Damage", "Max Use");
      System.out.println("============================================================================================");
      for (Item item : items) {
          if (item instanceof OffensiveItem) {
              OffensiveItem offensiveItem = (OffensiveItem) item;
              System.out.printf("|%-10s|%-30s|%-15s|%-10d|%-10d|%-10d|\n",
                      item.getId(), item.getName(), "Offensive", item.getPrice(), offensiveItem.getDamage(), offensiveItem.getMaxUse());
          }
      }
  } else if (itemType.equals("Defensive")) {
      System.out.println("============================================================================================");
      System.out.printf("|%-10s|%-30s|%-15s|%-10s|%-10s|%-10s|\n", "ID", "Name", "Type", "Price", "Deflect", "Max Use");
      System.out.println("============================================================================================");
      for (Item item : items) {
          if (item instanceof DefensiveItem) {
              DefensiveItem defensiveItem = (DefensiveItem) item;
              System.out.printf("|%-10s|%-30s|%-15s|%-10d|%-10d|%-10d|\n",
                      item.getId(), item.getName(), "Defensive", item.getPrice(), defensiveItem.getDeflect(), defensiveItem.getMaxUse());
          }
      }
  } else if (itemType.equals("Spell")) {
      System.out.println("============================================================================================");
      System.out.printf("|%-10s|%-30s|%-15s|%-10s|%-10s|%-10s|\n", "ID", "Name", "Type", "Price", "Damage", "Mana");
      System.out.println("============================================================================================");
      for (Item item : items) {
          if (item instanceof SpellItem) {
              SpellItem spellItem = (SpellItem) item;
              System.out.printf("|%-10s|%-30s|%-15s|%-10d|%-10d|%-10d|\n",
                      item.getId(), item.getName(), "Spell", item.getPrice(),  spellItem.getDamage(),spellItem.getMana());
          }
      }
  } else {
      System.out.println("Invalid item type.");
  }

  System.out.println("============================================================================================");
    }







    List<BoughtList> boughtList = new ArrayList<>();
public List<BoughtList> shopView(String filename, String input) throws IOException {
 

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("#");
            String id = parts[0];
            String name = parts[1];
            String type = parts[2];
            int price = Integer.parseInt(parts[3]);
            
            if (input.equals(id)) {
                boolean isAlreadyBought = false;
                
                for (BoughtList item : boughtList) {
                    if (item.getId().equals(id)) {
                        System.out.println("YOU HAVE ALREADY BOUGHT THIS ITEM!");
                        isAlreadyBought = true;
                        break;
                    }
                }
                
                if (!isAlreadyBought) {
                    switch (type.toLowerCase()) {
                        case "spell":
                            int damage = Integer.parseInt(parts[4]);
                            int mana = Integer.parseInt(parts[5]);
                            int useLeft = 0;
                            boughtList.add(new BoughtList(id, name, type, price, damage, mana, useLeft));
                            break;
                        case "offensive":
                            int damageOffensive = Integer.parseInt(parts[4]);
                            int maxUseOffensive = Integer.parseInt(parts[5]);
                            int useLeft2 = maxUseOffensive;
                            boughtList.add(new BoughtList(id, name, type, price, damageOffensive, maxUseOffensive, useLeft2));
                            break;
                        case "defensive":
                            int deflect = Integer.parseInt(parts[4]);
                            int maxUseDefensive = Integer.parseInt(parts[5]);
                            int useLeft3 = maxUseDefensive;
                            boughtList.add(new BoughtList(id, name, type, price, deflect, maxUseDefensive, useLeft3));
                            break;
                        default:
                            System.err.println("Invalid item type: " + type);
                    }
                }
            }
        }
    }

    return boughtList;
}


public void printBoughtList(List<BoughtList> boughtList) {
    System.out.println("============================================================================================");
    System.out.printf("|%-10s|%-30s|%-15s|%-10s|%-10s|%-10s|\n", "ID", "Name", "Type", "Price", "Damage", "Max Use");
    System.out.println("============================================================================================");
    for (BoughtList item : boughtList) {
        System.out.printf("|%-10s|%-30s|%-15s|%-10d|%-10d|%-10d|\n",
                item.getId(), item.getName(), item.getType(), item.getPrice(), item.getDamage(), item.getMaxUseMana(), item.getUseLeft());
    }
    System.out.println("============================================================================================");
}




}



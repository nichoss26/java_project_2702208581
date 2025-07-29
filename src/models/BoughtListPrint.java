package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoughtListPrint {
    private Scanner scanner;

    public BoughtListPrint(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<BoughtList> penentuan() throws IOException {
        List<BoughtList> items = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("item.txt"))) {
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
                        int useLeft = 0;
                        items.add(new BoughtList(id, name, type, price, damage, mana, useLeft));
                        break;
                    case "offensive":
                        int damageOffensive = Integer.parseInt(parts[4]);
                        int maxUseOffensive = Integer.parseInt(parts[5]);
                        int useLeft2 = maxUseOffensive;
                        items.add(new BoughtList(id, name, type, price, damageOffensive, maxUseOffensive, useLeft2));
                        break;
                    case "defensive":
                        int deflect = Integer.parseInt(parts[4]);
                        int maxUseDefensive = Integer.parseInt(parts[5]);
                        int useLeft3 = maxUseDefensive;
                        items.add(new BoughtList(id, name, type, price, deflect, maxUseDefensive, useLeft3));
                        break;
                    default:
                        System.err.println("Invalid item type: " + type);
                }
            }
        }

        return items;
    }

    public void printItems(List<BoughtList> items) {
        System.out.println("============================================================================================");
        System.out.printf("|%-10s|%-30s|%-15s|%-10s|%-10s|%-10s|\n", "ID", "Name", "Type", "Price", "Damage", "Max Use");
        System.out.println("============================================================================================");
        for (BoughtList boughtList : items) {
            System.out.printf("|%-10s|%-30s|%-15s|%-10d|%-10d|%-10d|\n",
                    boughtList.getId(), boughtList.getName(), boughtList.getType(), boughtList.getPrice(), boughtList.getDamage(), boughtList.getMaxUseMana(), boughtList.getUseLeft());
        }
        System.out.println("============================================================================================");
    }

    public void showAndBuyItems(List<BoughtList> items) {
        while (true) {
            System.out.println("Character Items:");
            printItems(items);
            System.out.print("Enter the ID of the item you want to buy (type 'Exit' to cancel): ");
            String inputID = scanner.nextLine();

            if (inputID.equalsIgnoreCase("Exit")) {
                break;
            }

            boolean found = false;
            for (BoughtList item : items) {
                if (item.getId().equals(inputID)) {
                    found = true;
                    System.out.println("You already have this item.");
                    break;
                }
            }

            if (found) {

                System.out.println("Item with ID " + inputID + " is not in the list.");
               
                printItems(items);
            }
        }
    }
}



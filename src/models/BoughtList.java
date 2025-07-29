package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoughtList {
    private List<Item> items;
    private String id;
    private String name;
    private String type;
    private int damage;
    private int maxUseMana;
	private int useLeft;
	private int price;
	
	

	public List<Item> getItems() {
		return items;
	}

	public BoughtList(String id, String name, String type, int damage, int maxUseMana, int useLeft, int price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.damage = damage;
		this.maxUseMana = maxUseMana;
		this.useLeft = useLeft;
		this.price = price;
	}
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMaxUseMana() {
		return maxUseMana;
	}

	public void setMaxUseMana(int maxUseMana) {
		this.maxUseMana = maxUseMana;
	}

	public int getUseLeft() {
		return useLeft;
	}

	public void setUseLeft(int useLeft) {
		this.useLeft = useLeft;
	}


    public boolean contains(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
   
    
    

}

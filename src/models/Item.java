package models;

public class Item {

	private String id;
    private String name;
    private int price;
    
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Item(String id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
        return "ID: " + id + ", Name: " + name + ", Price: " + price;
	}
}

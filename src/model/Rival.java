package model;

public class Rival {

	private int damage;
	private int health;
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
	public Rival(int damage, int health) {
		super();
		this.damage = damage;
		this.health = health;
	}
}

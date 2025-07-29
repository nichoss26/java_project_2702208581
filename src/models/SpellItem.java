package models;

public class SpellItem extends Item {
 private int damage;
 private int mana;



 public SpellItem(String id, String name, int price, int damage, int mana) {
	super(id, name, price);
	this.damage = damage;
	this.mana = mana;
}

public int getDamage() {
     return damage;
 }

 public int getMana() {
     return mana;
 }

 @Override
 public String toString() {
     return super.toString() + ", Type: Spell, Damage: " + damage + ", Mana: " + mana;
 }
}


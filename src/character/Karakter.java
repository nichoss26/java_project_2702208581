package character;

public class Karakter {
    protected String name;
    protected int health;
    protected int mana;
    protected int money;
    protected int baseDamage;
    protected int armor;

    public Karakter(String name, int health, int mana, int money, int baseDamage, int armor) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.money = money;
        this.baseDamage = baseDamage;
        this.armor = armor;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getMoney() {
        return money;
    }

    public int getArmor() {
        return armor;
    }

    public void receiveDamage(int damage) {
        health -= damage;
    }

    public void storeMana() {
        mana += 10;
    }
}
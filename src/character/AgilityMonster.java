package character;

public class AgilityMonster extends Monster {
    protected int critical;

    public AgilityMonster(String name, int baseDamage, int health, int critical) {
        super(name, baseDamage, health);
        this.critical = critical;
    }

    @Override
    public void attack(Karakter karakter) {
        int totalDamage = baseDamage * critical;
        karakter.receiveDamage(totalDamage);
    }
}



package character;

import java.util.Random;
import java.util.Scanner;

public class IntelligenceMonster extends Monster {
    public IntelligenceMonster(String name, int baseDamage, int health) {
        super(name, baseDamage, health);
    }
    
    Scanner scan = new Scanner(System.in);

    @Override
    public void attack(Karakter karakter) {
        int skillDamage = new Random().nextInt(20) + 30; // Random damage between 30 - 49
        int totalDamage = baseDamage + skillDamage;
        System.out.println();
        System.out.println("Monster is going to attack");
        System.out.println();
        System.out.println("   __  ___              __              ______");
        System.out.println("  /  |/  /__  ___  ___ / /____ ____    /_  __/_ _________");
        System.out.println(" / /|_/ / _ \\/ _ \\(_-</ __/ -_) __/     / / / // / __/ _ \\");
        System.out.println("/_/  /_/\\___/_//_/___/\\__/\\__/_/       /_/  \\_,_/_/ /_//_/");
        System.out.println();
        System.out.println(name + " is attacking with a base damage of " + baseDamage);
        System.out.println(name + " is an Intelligence monster, using skill gave bonus damage: " + skillDamage);
        karakter.receiveDamage(totalDamage);
        System.out.println("Receive Damage " + totalDamage);
        System.out.println();
        System.out.println("Enter To Continue....");
        scan.nextLine();
    }
}

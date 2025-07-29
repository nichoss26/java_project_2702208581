package character;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterGenerator {
    public static List<Monster> generateMonsters() {
        List<Monster> monsters = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("monster.txt"))) {
            String line;
            int monsterType = 0; 
            Random random = new Random();
            while ((line = br.readLine()) != null) {
                String[] monsterNames = line.split("#");
                for (String name : monsterNames) {
                    int baseDamage, health, armorOrCritical;
                    switch (monsterType) {
                        case 0: // Strength
                            baseDamage = random.nextInt(11) + 20; 
                            health = random.nextInt(11) + 200; 
                            int armor = random.nextInt(21) + 20; 
                            monsters.add(new StrengthMonster(name, baseDamage, health, armor));
                            break;
                        case 1: // Intelligence
                            baseDamage = random.nextInt(11) + 10; 
                            health = random.nextInt(11) + 100; 
                            monsters.add(new IntelligenceMonster(name, baseDamage, health));
                            break;
                        case 2: // Agility
                            baseDamage = random.nextInt(11) + 40;
                            health = random.nextInt(11) + 100;
                            armorOrCritical = random.nextInt(3) + 1; 
                            monsters.add(new AgilityMonster(name, baseDamage, health, armorOrCritical));
                            break;
                    }
                }
                monsterType++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return monsters;
    }
}

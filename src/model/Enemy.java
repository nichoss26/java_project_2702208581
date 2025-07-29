package model;

public class Enemy extends Rival {
private String monsterName;
private String monsterType;
public Enemy(int damage, int health, String monsterName, String monsterType) {
	super(damage, health);
	this.monsterName = monsterName;
	this.monsterType = monsterType;
}
public String getMonsterName() {
	return monsterName;
}
public void setMonsterName(String monsterName) {
	this.monsterName = monsterName;
}
public String getMonsterType() {
	return monsterType;
}
public void setMonsterType(String monsterType) {
	this.monsterType = monsterType;
}

	

}

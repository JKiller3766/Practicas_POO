package domain;

public class Warrior extends Character {
	private int strength;
	
	public Warrior(String name, int health, int strength) {
		super(name, health);
		this.strength = strength;
	}
	
	public boolean attack(Character enemy) {
		return takeDamage(this.strength);
	}
	
	public String toString() {
		return "WARRIOR " + super.toString();
	}
	
	public String getCharactersClass() {
		return "Class: WARRIOR";
	}
}

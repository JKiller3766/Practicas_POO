package domain;

public class Warrior extends Character {
	private int strengh;
	
	public Warrior(String name, int health, int strengh) {
		super(name, health);
		this.strengh = strengh;
	}
	
	public boolean attack(Character enemy) {
		return takeDamage(this.strengh);
	}
	
	public String toString() {
		return "WARRIOR " + super.toString();
	}
	
	public String getCharactersClass() {
		return "Class: WARRIOR";
	}
}

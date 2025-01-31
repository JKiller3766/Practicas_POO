package domain;
import java.util.Random;

public class Archer extends Character {
	private int accuracy;
	private int arrowDamage;
	
	public Archer(String name, int health, int accuracy, int arrowDamage) {
		super(name, health);
		this.accuracy = accuracy;
		this.arrowDamage = arrowDamage;
		
	}
	
	public boolean attack(Character enemy) {
		Random alea = new Random();	
		int shot = alea.nextInt(0, 100);
		
		if (shot <= accuracy) {
			return false;
		}
		return takeDamage(arrowDamage);
	}
	
	public String toString() {
		return "ARCHER | Name: " + getName() + " | Health " + getHealth() + " | Dodge = " + super.dodge + " | Accuracy: " + accuracy + " | Arrow damage: " + arrowDamage;
	}
	
}
package domain;
import java.util.Random;

public abstract class Character {
	
	private String name;
	private int health;
	private int dodge;
	private static final int MAX_HEALTH = 100;
	
	public Character(String name, int health) {
		Random alea = new Random();	
		
		this.name = name;
		if (health < MAX_HEALTH) {
			this.health = health;
		} else {
			this.health = MAX_HEALTH;
		} 
		
		dodge = alea.nextInt(30, 61);
	}
	
	public abstract boolean attack(Character enemy);
	
	public boolean takeDamage(int damage) {
		Random alea = new Random();	
		int dodgeValue = alea.nextInt(0, 100);
		
		if (dodgeValue <= dodge) {
			health -= damage;
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

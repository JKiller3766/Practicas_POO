package domain;

public class Mage extends Character {
	private int mana;
	private int magicPower;
	private static final int SPELLCOST = 10;
	
	public Mage(String name, int health, int mana, int magicPower) {
		super(name, health);
		this.mana = mana;
		this.magicPower = magicPower;
	}
	
	public boolean attack(Character enemy) {
		if(mana < SPELLCOST) {
			return false;
		}
		else {
		mana -= SPELLCOST;
		return takeDamage(magicPower);
		}
	}
		
		public String toString() {
			return "MAGE " + super.toString();
		}
		
		public String getCharactersClass() {
			return "Class: MAGE";
		}
}

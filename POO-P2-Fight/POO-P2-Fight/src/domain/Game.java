package domain;

public class Game {
	protected Character [] characters;
	protected int nextAvailableSlot;
	protected Character currentAttacker;
	protected Character currentDefender;
	protected Character winner;
	
	public Game(int numberOfCharacters) {
		characters = new Character[numberOfCharacters];
		nextAvailableSlot = 0;
	}
	
	public boolean hasBattleEnded() {
		if (currentDefender.isAlive() && currentAttacker.isAlive()) {
			return false;
		}
		return true;
	}
	
	protected void checkAndSetWinner() {
		int aliveCharacters = 0;
		
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] != null)
				aliveCharacters++;
		}
		if (aliveCharacters == 1) {
			winner = currentAttacker;
		}
			
	}
	
	public boolean createWarrior(String name, int health, int strength) {
		Character warrior = new Warrior(name, health, strength);
		
		return addCharacter(warrior);
	}
	
	public boolean createArcher(String name, int health, int accuracy, int arrowDamage) {
		Character archer = new Archer(name, health, accuracy, arrowDamage);
		return addCharacter(archer);
	}

	public boolean createMage(String name, int health, int mana, int magicPower) {
		Character mage = new Mage(name, health, mana, magicPower);
		return addCharacter(mage);
	}
	
	private boolean addCharacter(Character character) {
		if (nextAvailableSlot < characters.length) {
			characters[nextAvailableSlot] = character;
			nextAvailableSlot++;
			return true;
		}
		return false;
	}
}

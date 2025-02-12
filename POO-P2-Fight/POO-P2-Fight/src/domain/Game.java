package domain;

public class Game {
	protected Character[] characters;
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

	public boolean selectFighters(int fighterOne, int fighterTwo) {
		if (!(characters[fighterOne].isAlive()) || !(characters[fighterTwo].isAlive())) {
			return false;
		} else {
			currentAttacker = characters[fighterOne];
			currentDefender = characters[fighterTwo];
			return true;
		}
	}

	public boolean performAttack() {
		boolean attack = currentAttacker.attack(currentDefender);

		if (attack) {
			if (hasBattleEnded()) {
				checkAndSetWinner();
			}
		}
		return attack;
	}

	public String charactersAndStatus() {
		String charactersInfo = "";
		for (int idx = 0; idx < nextAvailableSlot; idx++) {
			charactersInfo += "(" + idx + ")" + characters[idx].toString() + "\n-------\n";
		}
		return charactersInfo;
	}

	public String fightersStatus() {
		return currentAttacker.toString() + "\n-------\n" + currentDefender.toString();
	}

	public String getWinnerInfo() {
		if (winner == null) {
			return "";
		} else {
			return winner.getNameAndClass();
		}
	}

	public boolean hasGameEnded() {
		if (winner != null) {
			return true;
		}
		return false;
	}

	protected void checkAndSetWinner() {
		int aliveCharacters = 0;

		for (int i = 0; i < characters.length && aliveCharacters <= 1; i++) {
			if (characters[i].isAlive()) {
				aliveCharacters++;
			}

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

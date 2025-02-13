package domain;

public class SurvivorGame extends Game {
	public SurvivorGame(int numberOfCharacters) {
		super(numberOfCharacters);
	}

	public boolean selectFighters(int fighterOne, int fighterTwo) {
		if (fighterOne < nextAvailableSlot && fighterTwo < nextAvailableSlot) {
			return super.selectFighters(fighterOne, fighterTwo);
		} else {
			return false;
		}
	}

	protected void checkAndSetWinner() {
		int defenderPosition;
		if (!currentDefender.isAlive()) {
			nextAvailableSlot--;
			defenderPosition = findCharactersPosition(currentDefender);
			if (nextAvailableSlot > 0) {
				if (!(defenderPosition == nextAvailableSlot)) {
					if (defenderPosition != -1) {
						characters[defenderPosition] = characters[nextAvailableSlot];
						characters[nextAvailableSlot] = currentDefender;
					}
				}
				if (nextAvailableSlot == 1) {
					winner = currentAttacker;
				}
			}

		}
	}

	protected int findCharactersPosition(Character character) {
		int characterIndex = -1;

		for (int i = 0; i < characters.length && characterIndex == -1; i++) {
			if (character.equals(characters[i])) {
				characterIndex = i;
			}
		}

		return characterIndex;
	}
}

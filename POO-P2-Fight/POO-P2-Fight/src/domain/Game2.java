package domain;

public class Game2 {
	protected Character [] characters;
	protected int nextAvailableSlot;
	protected Character currentAttacker;
	protected Character currentDefender;
	protected Character winner;
	
	
	
	public boolean selectFighter(int x, int y) {
		if ( !( characters[x].isAlive() )  ||  !( characters[y].isAlive() ) ) {
			return false;
		}
		else{
			currentAttacker = characters[x];
			currentDefender = characters[y];
			return true;
		}
	}
	
	public boolean performAttack() {
		if (currentAttacker.attack(currentDefender)) {
			if (hasBattleEnded()) {
				checkAndSetWinner()
			}
		}
	}
	
	public String charactersAndStatus() {
		String charactersInfo = "";
		for(int idx = 0; idx<nextAvailableSlot;idx++) {
			if( !( characters[idx].isAlive() ) ) {
				if(characters[characters.length-1].isAlive()){
				characters[idx] = characters[characters.length-1];
				nextAvailableSlot--;
				}
			}
			charactersInfo += "(" + idx + ")" + characters[idx].getCharactersClass() + characters[idx].toString() + characters[idx].;
		}
	}
	
	public String fightersStatus() {
		
	}
	
	public String getWinnerInfo() {
		if(winner == null) {
			return "";
		}
		else {
			return winner.getNameAndClass();
		}
	}
	
	public boolean hasGameEnded() {
		if(winner != null) {
			return true;
		}
		return false;
	}
}

package domain;

public class Game {
	private Board gameBoard;
	private Ship [] sunkenShips;
	private int numSunkenShips;
	
	public Game() {
		ShipType.createShipTypes();
		
	}
}

package domain;

public class OccupiedCell extends Cell {
	private Ship ship;
	
	public OccupiedCell(Ship ship) {
		this.ship = ship;
	}
	public boolean isEmpty() {
		return false;
	}
	public boolean hasShipSunk() {
		if(ship.hasSunk()) {
			return true;
		}
		return false;
	}
	public Ship getShip() {
		return ship;
	}
	public String getShipTypeName() {
		return ship.getShipTypeName();
	}
	protected void increaseNumShots() {
		ship.increasHits();
	}
}

package domain;

public abstract class Cell {
	private boolean hit;
	
	protected Cell() {
		hit = false;
	}
	protected void increaseNumShots() {}
	public boolean getHit() {
		return hit;
	}
	public abstract boolean isEmpty();
	public boolean hasShipSunk() {
		return false;
	}
	public String getShipTypeName() {
		return "";
	}
	public Ship getShip() {
		return null;
	}
	public boolean shoot() {
		
	}
}

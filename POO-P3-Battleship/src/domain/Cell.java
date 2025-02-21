package domain;

public abstract class Cell {
	private boolean hit;
	
	protected Cell() {
		hit = false;
	}
	protected void increaseNumShots() {}
	public boolean hasBeenHit() {
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
		if (hit) {
			return false;
		}
		else {
			if(isEmpty()){
				hit = true;
				return false;
			}
			else {
				increaseNumShots();
				hit = true;
				return true;
				
			}
		}
	}
}

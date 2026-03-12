package domain;

import exceptions.NoShipException;

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
	public String getShipTypeName() throws NoShipException {
		throw new NoShipException("No hi ha cap vaixell disponible");
	}
	public Ship getShip() throws NoShipException{
		throw new NoShipException("No hi ha cap vaixell disponible");
	}
	public boolean shoot() {
		if (hit) {
			return false;
		}
		else {
			hit = true;
			if(isEmpty()){
				return false;
			}
			else {
				increaseNumShots();
				return true;
				
			}
		}
	}
}

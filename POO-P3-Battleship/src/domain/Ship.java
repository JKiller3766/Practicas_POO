package domain;

public class Ship implements Comparable {
	private ShipType shipType;
	private int id;
	private int numHits;
	private static int usedIds = 0;
	
	public Ship(ShipType ship) {
		shipType = ship;
		numHits = 0;
		id = usedIds;
		usedIds++;
	}
	public int getId() {
		return id;
	}
	public String getShipTypeId() {
		return shipType.getId();
	}
	public String getShipTypeName() {
		return shipType.getName();
	}
	public int getSize() {
		return shipType.getSize();
	}
	public boolean hasSunk() {
		if(numHits == getSize()) {
			return true;
		}
		else {
			return false;
		}
	}
	public void increasHits() {
		numHits++;
	}
	public String toString() {
		String ShipInfo = "";
		ShipInfo += "Id: " + getId() + "| Ship Type: " + getShipTypeId() + "| Size: " + getSize();
		return ShipInfo;
	}
	public boolean equals(Object ship) {
		if (ship instanceof Ship) {
			if(ship.equals(shipType)) { // posible error de ejecucion
				return true;
			}
		}
		return false;
	}
	public int compareTo(Object possibleShip) {
		if(possibleShip instanceof Ship) {
			if(shipType.getSize() == ((Ship)possibleShip).getSize()) {
				return 0;
			}
			else if(shipType.getSize() > ((Ship)possibleShip).getSize()) {
				return -1;
			}
			else {
				return 1;
			}
		}
		throw new ClassCastException(); // editar mas adelante
	}
	

}

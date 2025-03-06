package domain;

import exceptions.IncompatibleVectorsException;

public class ShipType {
	private String name;
	private int size;
	private String id;
	private static ShipType[] availableShipTypes;

	private ShipType(String id, String name, int size) {
		this.name = name;
		this.size = size;
		this.id = id;
	}

	public static void createShipTypes(String[] id, String[] name, int[] size) {
		if (id.length == name.length && id.length == size.length) {
			availableShipTypes = new ShipType[id.length];
			for (int idx = 0; idx < availableShipTypes.length; idx++) {
				ShipType ship = new ShipType(id[idx], name[idx], size[idx]);
				availableShipTypes[idx] = ship;
			}
		}
		throw new IncompatibleVectorsException ("Vectors amb diferent mida. ");
	}

	public static void createShipTypes() {
		String[] id = new String[5];
		String[] name = new String[5];
		int[] size = new int[5];
		for (int i = 0; i < id.length; i++) {
			switch (i) {
			case 0:
				size[i] = 2;
				id[i] = "DE";
				name[i] = "DESTROYER";
				break;
			case 1:
				size[i] = 3;
				id[i] = "SU";
				name[i] = "SUBMARINE";
				break;
			case 2:
				size[i] = 3;
				id[i] = "CR";
				name[i] = "CRUISER";
				break;
			case 3:
				size[i] = 4;
				id[i] = "BA";
				name[i] = "BATTLESHIP";
				break;
			default:
				size[i] = 5;
				id[i] = "CA";
				name[i] = "CARRIER";
			}
			createShipTypes(id, name, size);
		}
	}

	public static ShipType[] getAvailableShipTypes() {
		return availableShipTypes;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

}

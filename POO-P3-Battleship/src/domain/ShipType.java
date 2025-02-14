package domain;

public class ShipType {
	private String name;
	private int size;
	private String id;
	private static ShipType [] availableShipTypes;
	
	private ShipType(String id, String name, int size) {
		this.name = name;
		this.size = size;
		this.id = id;
	}
	
	public static void createShipTypes(String [] id, String[] name, int[] size) {
		if (id.length == name.length && id.length==size.length) {
			availableShipTypes = new ShipType[id.length];
			for(int idx = 0;idx<availableShipTypes.length;idx++ ) {
				ShipType ship = new ShipType(id[idx], name[idx], size[idx]);
				availableShipTypes[idx] = ship;
			}
		}
	}
	
	public static void createShipTypes() {
		String [] id = new String[5];
		String [] name = new String[5];
		int [] size = new int[5];
	}

}

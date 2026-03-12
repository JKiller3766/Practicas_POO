package sessio2;

public class Cell {

	private char marker;
	
	public Cell() {
		marker = ' ';
	}
	
	public boolean isEmpty() {
		if (marker == ' ') {
			return true;
		}
		
		return false;
	}
	
	public boolean addMarker(char player) {
		if (isEmpty()) {
			marker = player;
			return true;
		}
		
		return false;
	}
	
	public char getContent(){return marker;}
}

package sessio2;

public class Board {
	
	private final static int SIZE=3; 
	

	//TODO: Add additional private attributes. 
	private Cell[][] cells;
	
	//TODO: Add methods as described in the document
	
	public Board() {
		cells 	= new Cell [SIZE][SIZE];
		for (int row = 0; row < cells.length; row++) {
			for (int col = 0; col < cells[row].length; col++) {
				cells[row][col] = new Cell();
			}
		}
	}
	
	public int getNumRows() {
		return cells.length-1;
	}
	
	public int getNumCols() {
		return cells.length-1;
	}
	
	public char getCellContent(int row, int col) {
		return cells[row][col].getContent();
	}
	
	public boolean move(char letter, int row, int col) {
		if(cells[row][col].addMarker(letter)) {	
			return true;
		}
		return false;
	}
	
	public boolean hasPlayerWon(char player) {
		
		int howManyXorO;	
		for(int fil = 0;fil<cells.length;fil++) {
			howManyXorO = 0;
			for(int col = 0;col<cells[fil].length;col++) {
				if ( cells[fil][col].getContent() == player) {
					howManyXorO++;
					if(howManyXorO == cells.length) return true;
				}		
			}
		}
		howManyXorO = 0;
		for(int fil = 0;fil<cells.length;fil++) {
			howManyXorO = 0;
			for(int col = 0;col<cells[fil].length;col++) {
				if ( cells[col][fil].getContent() == player) {
					howManyXorO++;
					if(howManyXorO == cells.length) return true;
				}	
			}
		}
		howManyXorO = 0;
		for(int fil = 0; fil<cells.length;fil++) {
			for(int col = 0; col<cells[fil].length;col++) {
				if( fil == col && cells[fil][col].getContent() == player) {
					howManyXorO++;
					if( howManyXorO == cells.length) return true;
				}
			}
		}
		howManyXorO = 0;
		for(int fil = cells.length-1, col = 0 ;0<=fil; fil--, col++) {
				if(cells[fil][col].getContent() == player) {
					howManyXorO++;
					if( howManyXorO == cells.length) return true;
				}
			}
		
		return false;
		
	}
	
	public boolean isFull() {
		for(int fil = 0; fil<cells.length;fil++) {
			for(int col = 0; col<cells[fil].length;col++) {
				if(cells[fil][col].isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public String boardToString() {
		String table = "";
		for(int fil = 0;fil<cells.length;fil++) {
			table +=("| ");
			for(int col = 0;col<cells[fil].length;col++) {
				table+=(cells[fil][col].getContent() + " | ");
			}
			table+=("\n");
		
		}
		return table;
	}
}
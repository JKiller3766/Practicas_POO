package domain;

public class Board {
	
	private final static int SIZE = 3;

	// TODO: Add additional private attributes.

	// TODO: Add methods as described in the document

	private Cell cells[][];

	public Board() {
		cells = new Cell[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				cells[i][j] = new Cell();
				
			}
		}
	}

	public int getNumRows() {
		return cells.length;
	}

	public int getNumCols() {
		return cells[0].length;
	}

	public char getCellContent(int row, int column) {
		return cells[row][column].getContent();
	}
	
	public boolean move (char player, int row, int column) {
		if (cells[row][column].addMarker(player)) {
			return true;
		}
		
		return false;
	}

	
	public boolean hasPlayerWon(char player) {
		boolean hasPlayerWon;

		hasPlayerWon = rowWin(player);
		if (!hasPlayerWon) {
			hasPlayerWon = columnWin(player);
		}

		if (!hasPlayerWon) {
			hasPlayerWon = diagonalWin(player);
		}

		if (!hasPlayerWon) {
			hasPlayerWon = invertedDiagonalWin(player);
		}

		return hasPlayerWon;
	}
	
	private boolean rowWin(char player) {
		boolean differentPlayer;

		for (int i = 0; i < SIZE; i++) {
			differentPlayer = false;
			for (int j = 0; j < SIZE && !differentPlayer; j++) {
				if (cells[i][j].getContent() != player) {
					differentPlayer = true;
				}
				if (j == SIZE - 1 && !differentPlayer) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean columnWin(char player) {
		boolean differentPlayer;

		for (int j = 0; j < SIZE; j++) {
			differentPlayer = false;
			for (int i = 0; i < SIZE && !differentPlayer; i++) {
				if (cells[i][j].getContent() != player) {
					differentPlayer = true;
				}
				if (i == SIZE - 1 && !differentPlayer) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean diagonalWin(char player) {
		boolean differentPlayer = false;

		for (int i = 0; i < SIZE; i++) {
			if (cells[i][i].getContent() != player) {
				differentPlayer = true;
			}
			if (i == SIZE - 1 && !differentPlayer) {
				return true;
			}
		}
		return false;
	}

	private boolean invertedDiagonalWin(char player) {
		boolean differentPlayer = false;

		for (int i = 0; i < SIZE; i++) {
			if (cells[i][SIZE - i - 1].getContent() != player) {
				differentPlayer = true;
			}
			if (i == SIZE - 1 && !differentPlayer) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isFull() {
		boolean isFull = true;
		
		for(int i = 0; i < SIZE && isFull; i++) {
			for(int j = 0; j < SIZE && isFull; j++) {
				if (cells[i][j].isEmpty()) {
					isFull = false;
				}
			}
		}
		
		return isFull;
	}
	
}
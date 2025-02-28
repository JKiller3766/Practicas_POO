package domain;

import java.util.Random;

public class Board implements IBoard{
	private Cell [][] cells;
	
	public Board(int rows, int cols, ShipType [] ships, int [] numOfShips) {
		cells = new Cell [rows][cols];
		createEmptyBoard();
		addShipsToBoard(ships, numOfShips);
	}
	public Board(ShipType [] ships, int [] numOfShips) {
		this(10,10,ships,numOfShips);
	}
	public boolean shoot(int row, int col) {
		return cells[row][col].shoot();
	}
	public boolean hasShipSunk(int row, int col) {
		return cells[row][col].hasShipSunk();
	}
	public boolean allShipsSunk() {
		for(int fil = 0;fil<cells.length;fil++) {
			for(int col = 0; col<cells[fil].length;col++) {
				if( !(hasShipSunk(fil,col)) ) {
					return false;
				}
			}
		}
		return true;
	}
	public int getRows() {
		return cells.length;
	}
	public int getColumns() {
		return cells[0].length;
	}
	public boolean hasCellBeenHit(int row, int col) {
		return cells[row][col].hasBeenHit();
	}
	public boolean isCellEmpty(int row, int col) {
		return cells[row][col].isEmpty();
	}
	public String getShipTypeName(int row, int col) {
		return cells[row][col].getShipTypeName(); // no es el nombre bueno
	}
	public Ship getShip(int row, int col) {
		return cells[row][col].getShip();
	}
	public String toString() {
		String tauler = "";
		for(int fil = 0;fil<cells.length;fil++) {
			for(int col = 0;col<cells[fil].length;col++) {
				if( !(hasCellBeenHit(fil, col)) ) {
					tauler += "??";
				}
				else {
					if(isCellEmpty(fil, col)) {
						tauler += "XX";
					}
					else {
						tauler += "HH";
					}
				}
				tauler += "  ";
			}
		}
		return tauler;
	}
	private void createEmptyBoard() {
		for(int fil = 0;fil<cells.length;fil++) {
			for(int col = 0;col<cells[fil].length;col++) {
				cells[fil][col] = new EmptyCell();
			}
		}
	}
	private void addShipsToBoard(ShipType [] ships, int [] numOfShips) {
		Random posi = new Random();
		boolean direccion = posi.nextBoolean();
		if(ships.length==numOfShips.length) {
			
			
		}
		
	}
}


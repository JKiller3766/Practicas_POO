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
					tauler += "??  ";
				}
				else {
					if(isCellEmpty(fil, col)) {
						tauler += "XX  ";
					}
					else {
						tauler += "HH  ";
					}
				}
				
			}
			tauler += "\n";
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
		Random alea = new Random();
		int direccion, positionX, positionY;
		boolean freeCells;
		
		if(ships.length==numOfShips.length) {
			for(int idx = 0; idx < ships.length; idx++) {
				freeCells = true;
				direccion = alea.nextInt(0, 2); //0 = horizontal y 1 = vertical
				if (direccion == 0) {
					do {
						positionX = alea.nextInt(0, cells[0].length);
					} while(positionX + ships[idx].getSize() < cells[0].length);
					
					positionY = alea.nextInt(0, cells.length);
					
					for (int idx2 = positionX; idx2 < cells[0].length && freeCells; idx2++) {
						if (!cells[positionY][idx2].isEmpty()) {
							freeCells = cells[idx2][positionX].isEmpty();
						}
					}
					
				} else {
					do {
						positionY = alea.nextInt(0, cells.length);
					} while(positionY + ships[idx].getSize() < cells.length);
					
					positionX = alea.nextInt(0, cells.length);
					
					for (int idx2 = positionY; idx2 < cells[0].length && freeCells; idx2++) {
						freeCells = cells[idx2][positionX].isEmpty();
					}
				}
				if (freeCells) {
					while(numOfShips[idx]>0){
						Ship ship = new Ship(ships[idx]);
						
						if(direccion == 0) {
							for (int idx2 = positionY, tam = ship.getSize(); idx2 < cells[0].length && tam>0 ; idx2++, tam--) {
								cells[idx2][positionX] = new OccupiedCell(ship);
							}
						}
						else {
							for (int idx2 = positionX, tam = ship.getSize(); idx2 < cells[0].length && tam>0 ; idx2++, tam--) {
								cells[positionY][idx2] = new OccupiedCell(ship);
							}
						}																
						numOfShips[idx]--;
					}
				}
			}
							
		}
		
	}
}


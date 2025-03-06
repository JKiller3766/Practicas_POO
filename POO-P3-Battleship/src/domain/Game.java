package domain;

import exceptions.NoShipException;

public class Game {
	private Board gameBoard;

    private Ship[] sunkenShips;

    private int numSunkenShips;

    public Game() {
        
        ShipType[] ships;
        int enters[];
        
        ShipType.createShipTypes();
        ships = ShipType.getAvailableShipTypes();
        enters = new int[ships.length]; 
        
        sunkenShips = new Ship[enters.length];
        
        for (int i = 0; i < enters.length; i++) {
            enters[i] = 1;
        }
        gameBoard = new Board(ships, enters);
        numSunkenShips = 0;
    }
    public int getNumRows() {
        return gameBoard.getRows();
    }

    public int getNumCols() {
        return gameBoard.getColumns();
    }
    public boolean hasEnded() {
        if (gameBoard.allShipsSunk()) {
            return true;
        }
        return false;
    }
    public boolean hasShipSunk(int fila, int col) {
        return gameBoard.hasShipSunk(fila, col);
    }
    public String getShipTypeName(int fila, int col) throws NoShipException{
        return gameBoard.getShipTypeName(fila, col);
    }
    public boolean isCellEmpty(int fila, int col) {
        return gameBoard.isCellEmpty(fila, col);
    }
    public boolean shootAndHit(int fila, int col) {
        if (gameBoard.shoot(fila, col)) {
            if (gameBoard.hasShipSunk(fila, col)) {     
            	sunkenShips[numSunkenShips] = gameBoard.getShip(fila, col);
            	numSunkenShips++;
            	sortSunkShipsBySize();
            }
            return true;
        }
        return false;
    }
    public String sunkShipInfo() {
        String info = "";
        for (int i = 0; i < numSunkenShips; i++) {
            info += sunkenShips[i].toString() + "\n";
        }
        return info;
    }
    public String boardToString() {
        return gameBoard.toString();
    }
    private void sortSunkShipsBySize() {
        Ship aux;
        for (int a = 1; a <= numSunkenShips - 1; a++) {
            for (int j = numSunkenShips - 1; j >= a; j--) {
                if (sunkenShips[j].compareTo(sunkenShips[j-1]) == 1) {
                    aux = sunkenShips[j];
                    sunkenShips[j] = sunkenShips[j - 1];
                    sunkenShips[j - 1] = aux;
                }
            }
        }
    }
}

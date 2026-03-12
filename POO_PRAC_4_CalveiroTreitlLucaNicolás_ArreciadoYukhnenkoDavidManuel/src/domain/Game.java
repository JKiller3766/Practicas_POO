package domain;

public class Game {
	
	private Board board;
	private char winner;
	private char currentPlayer;
	private static char PLAYER1 = 'X';
	private static char PLAYER2 = 'O';
	
	//TODO: Add attributes as described in the document
	
	//TODO: Add methods
	
	public Game() {
		board = new Board();
		currentPlayer = PLAYER1;
		winner = ' ';
	}
	
	public int getBoardRows() {
		return board.getNumRows();
	}
	
	public int getBoardCols() {
		return board.getNumCols();
	}
	
	public boolean move(int x, int y) {
		if (board.move(currentPlayer, x, y)) {
			if(currentPlayer == PLAYER1) {
				currentPlayer = PLAYER2;
			} else {
				currentPlayer = PLAYER1;
			}
			return true;
		}
		return false;
	}
	
	public boolean hasGameEnded() {
		computeWinner();
		if (board.isFull()) {
			return true;
		}
		return winner != ' ';
		
	}
	
	public String boardToString() {	
		return board.boardToString();
	}
	public char getCellContent(int row, int col) {
		return board.getCellContent(row, col);
	}
	
	public String getEndMessage() {
		if (winner == PLAYER1) {
			return "Player 1 wins the game!";
		} else if (winner == PLAYER2) {
			return "Player 2 wins the game!";
		} else {
			return "TIE! No one has won the game!";
		}
	}
	
	private void computeWinner() {
		if (winner == ' ') {
			if (board.hasPlayerWon(PLAYER1)) {
				winner = PLAYER1;
			} else if (board.hasPlayerWon(PLAYER2)) {
				winner = PLAYER2;
			}
		}
			
	}
}

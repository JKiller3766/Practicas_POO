package sessio2;

public class Game {
	
	private static char PLAYER1 = 'X';
	private static char PLAYER2 = 'O';
	
	//TODO: Add attributes as described in the document
	private Board board;
	private char currentPlayer, winner;
	
	//TODO: Add methods
	public Game () {
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
	
	public boolean move(int row, int col) {
		if(board.move(currentPlayer, row, col)) {
			if(currentPlayer == PLAYER1) {
				currentPlayer = PLAYER2;
			}
			else {
				currentPlayer = PLAYER1;
			}
			return true;
		}
		return false;
	}
	
	public boolean hasGameEnded() {
		if(board.hasPlayerWon(currentPlayer)) {
			return true;
		}
		else if(board.isFull()) {
			return true;
		}
		return false;
	}
	
	public String boardToString() {
		return board.boardToString();
		
	}
	
	public String getEndMessage() {
		if(hasGameEnded()) {
			if(board.hasPlayerWon(currentPlayer)) {
				if(currentPlayer == PLAYER1) {
					return "Player 1 wins the game!";
				}
				else {
					return "Player 2 wins the game!";
				}
			}
			else {
				return "TIE! No one has won the game!";
			}
		}
		return "";
	}
	
	private void computeWinner() {
		if(board.hasPlayerWon(currentPlayer)) {
			if (winner != ' ') winner = currentPlayer;
		}
	}
	
	
}

package sessio1;

import java.awt.Color;
import java.awt.Toolkit;

import jconsole.JConsole;

public class TicTacToeGame {

	public static void main(String[] args) {
		
		//Two consoles, AVOID CHANGING
		JConsole gameConsole = new JConsole(30,10);
		JConsole userInput = new JConsole(60,15);
		
		char [][] board = new char [3][3];
		boolean gameEnded;
		boolean exit;
		boolean canHeMove;
		char player1 = 'X';
		char player2 = 'O';
		char currentPlayer = player1;
		int playerOption, rows = board.length-1, columns = board[rows].length-1;
		
		//TODO: Declare more variables here if you need them.
		
		//Screen size, AVOID CHANGING
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int halfWidthGame = (screenWidth)/4;
		int halfHeightPlayer = (screenHeight)/2;
		
		//Console positioning
		gameConsole.setLocation(halfWidthGame,10);
		userInput.setLocation(halfWidthGame,halfHeightPlayer);
		
		//We hide the cursor in the game console
		gameConsole.setCursorVisible(false);

		
		//TODO: Show main menu
		//TODO: We initialize the variables with some dummy values, feel free to change them if you need to
		gameEnded = false;
		playerOption = showMenuAndSelectOption(userInput);
		if(playerOption == 1) {
			exit = false;
		}
		else {
			exit = true;
		}
		while(!exit) {
			//Game begins
			initializeBoard(board);
			
			
			//TODO: Prepare board and show it
			
			while(!gameEnded) {
				
				
				showBoard(gameConsole, board);
				canHeMove = move(board, getAndValidateCoordinates(userInput,rows,columns), currentPlayer);
				while ( !(canHeMove)) {
					userInput.setForegroundColor(Color.red);
					userInput.println("\nCell already occupied. You need to enter another coordinate");
					userInput.resetColor();
					canHeMove = move(board, getAndValidateCoordinates(userInput,rows,columns), currentPlayer);
				}
				
				gameConsole.clear();
				showBoard(gameConsole, board);
				//TODO: Interact with user and make move
				//Make sure that after a valid move current player changes
				
				
				if(hasPlayerWon(board, currentPlayer) == true ) {
					userInput.println();
					gameConsole.print("Player " + currentPlayer + " wins the game!");
					gameEnded = true;
				}
				else if(isBoardFull(board) == true) {
					gameConsole.print("TIE! no one has won the game");
					gameEnded = true;
				}
				if(currentPlayer == player2) {
					currentPlayer = player1;
				}
				else {
					currentPlayer = player2;
				}
			}
			
			//TODO: Whatever needs to be done when a game has finished
			
			//TODO: Do not forget that the user should be able to play a new game when another game has ended
			playerOption = showMenuAndSelectOption(userInput);
			if(playerOption == 1) {
				gameEnded = false;
			}
			else {
				exit = true;
			}
		}
		
		//We should only reach this point when the user has decided to exit the game. DO NOT MAKE ANY CHANGES HERE.
		userInput.setCursorPosition(0, userInput.getRows()-1);
		userInput.print("Press any key to exit...");
		userInput.readKey();
		System.exit(0);
		
	}
	
	//Private static procedures below. Some of them return dummy values, make sure to change them as appropriate.
	
	/**
	 * Shows main menu and returns option selected by user
	 * @param console
	 * @return
	 */
	private static int showMenuAndSelectOption(JConsole console) {
		/*TODO: Complete*/
		int option = 0;
		console.println("Select option \n1. New game \n2. Exit");
		console.setForegroundColor(Color.green);
		option = console.readInt();
		while(!(option == 1 || option == 2)) {
			console.setForegroundColor(Color.red);
			console.println("Menu option must be between 1 (New game) and 2 (Exit). Reenter your selection");
			console.setForegroundColor(Color.green);
			option = console.readInt();
		}
		console.resetColor();
		return option;
	}


	/**
	 * Initializes board with empty spaces
	 * @param board
	 */
	private static void initializeBoard(char[][] board) {
		/*TODO: Complete*/
		for(int fil = 0;fil<board.length;fil++) {
			for(int col = 0;col<board[fil].length;col++) {
				board[fil][col] = ' ';
			}
		}
	}
	
	
	/**
	 * Shows board on console
	 * @param console
	 * @param board
	 */
	private static void showBoard(JConsole console, char[][] board) {
		/*TODO: Complete*/
		console.clear();
		for(int fil = 0;fil<board.length;fil++) {
			console.print("| ");
			for(int col = 0;col<board[fil].length;col++) {
				console.print(board[fil][col] + " | ");
			}
			console.println();
		}
	}
	
	
	/**
	 * Interacts with user to obtain some valid (within the given parameters) coordinates.
	 * @param console
	 * @param nRows
	 * @param nCols
	 * @return
	 */
	private static int[] getAndValidateCoordinates(JConsole console, int nRows, int nCols) {
		/*TODO: Complete*/
		int userRow, userColumn;
		int [] valors = new int [nRows];
		
		console.println("\nNew coordinates");
		console.println("---------------");
		
		console.print("Insert row number [0,2]: ");
		console.setForegroundColor(Color.green);
		userRow = console.readInt();
		console.resetColor();

		while(userRow<0 || userRow>nRows) {
			console.setForegroundColor(Color.red);
			console.print("Value must be between [0,2]. Insert new value: ");
			console.setForegroundColor(Color.green);
			userRow = console.readInt();
			console.resetColor();			
		}
		
		console.print("Insert column number [0,2]: ");
		console.setForegroundColor(Color.green);
		userColumn = console.readInt();
		console.resetColor();
		
		while(userColumn<0 || userColumn>nCols) {
			console.setForegroundColor(Color.red);
			console.print("Value must be between [0,2]. Insert new value: ");
			console.setForegroundColor(Color.green);
			userColumn = console.readInt();
			console.resetColor();
		}
		valors[0] = userRow;
		valors[1] = userColumn;
		return valors;
	}
	
	
	/**
	 * Coordinates must be valid and player too. Returns true if move can be performed, false otherwise.
	 * @param board
	 * @param coord
	 * @param player
	 * @return
	 */
	private static boolean move(char[][] board, int[] coord, char player) {
		/*TODO: Complete*/
		if (board [coord[0]][coord[1]] == ' ') {
			board [coord[0]][coord[1]] = player; 
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks if the given board is full. Should return true if it's full, false otherwise 
	 * @param board
	 * @return
	 */
	private static boolean isBoardFull(char[][] board) {
		/*TODO: Complete*/
		for(int fil = 0;fil<board.length;fil++) {
			for(int col = 0;col<board[fil].length;col++) {
				if(board[fil][col] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Returns true if the player has won the game, false otherwise.
	 * @param board
	 * @param player
	 * @return
	 */
	private static boolean hasPlayerWon(char[][] board, char player) {
		/*TODO: Complete*/
		//filas
		int howManyXorO;	
		for(int fil = 0;fil<board.length;fil++) {
			howManyXorO = 0;
			for(int col = 0;col<board[fil].length;col++) {
				if ( board[fil][col] == player) {
					howManyXorO++;
					if(howManyXorO == board.length) return true;
				}		
			}
		}
		howManyXorO = 0;
		for(int fil = 0;fil<board.length;fil++) {
			howManyXorO = 0;
			for(int col = 0;col<board[fil].length;col++) {
				if ( board[col][fil] == player) {
					howManyXorO++;
					if(howManyXorO == board.length) return true;
				}	
			}
		}
		howManyXorO = 0;
		for(int fil = 0; fil<board.length;fil++) {
			for(int col = 0; col<board[fil].length;col++) {
				if( fil == col && board[fil][col] == player) {
					howManyXorO++;
					if( howManyXorO == board.length) return true;
				}
			}
		}
		howManyXorO = 0;
		for(int fil = board.length-1, col = 0 ;0<=fil; fil--, col++) {
				if(board[fil][col] == player) {
					howManyXorO++;
					if( howManyXorO == board.length) return true;
				}
			}
		
		return false;
	}


}

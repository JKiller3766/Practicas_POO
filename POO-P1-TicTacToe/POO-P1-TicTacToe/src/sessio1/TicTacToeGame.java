package sessio1;

import java.awt.Color;
import java.awt.Toolkit;

import jconsole.JConsole;

public class TicTacToeGame {

	public static void main(String[] args) {

		// Two consoles, AVOID CHANGING
		JConsole gameConsole = new JConsole(30, 10);
		JConsole userInput = new JConsole(60, 15);

		char[][] board = new char[3][3];
		boolean gameEnded;
		boolean exit;
		char player1 = 'X';
		char player2 = 'O';
		char currentPlayer = player1;
		int selection;
		int[] coordinates = new int[2];

		// TODO: Declare more variables here if you need them.

		// Screen size, AVOID CHANGING
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int halfWidthGame = (screenWidth) / 4;
		int halfHeightPlayer = (screenHeight) / 2;

		// Console positioning
		gameConsole.setLocation(halfWidthGame, 10);
		userInput.setLocation(halfWidthGame, halfHeightPlayer);

		// We hide the cursor in the game console
		gameConsole.setCursorVisible(false);

		// TODO: Show main menu
		// TODO: We initialize the variables with some dummy values, feel free to change
		// them if you need to
		exit = false;
		gameEnded = true;

		while (!exit) {
			// Game begins

			// TODO: Prepare board and show it
			selection = showMenuAndSelectOption(userInput);

			if (selection == 1) {
				gameEnded = false;
			} else {
				exit = true;
			}

			initializeBoard(board);
			showBoard(gameConsole, board);

			while (!gameEnded) {

				// TODO: Interact with user and make move
				// Make sure that after a valid move current player changes

				userInput.println("New coordinates");
				userInput.println("---------------");

				coordinates = getAndValidateCoordinates(userInput, board.length, board[0].length);
				userInput.println();

				while (!move(board, coordinates, currentPlayer)) {
					userInput.setForegroundColor(Color.RED);
					userInput.println("Cell already occupied. You need to enter another coordinate");
					userInput.resetColor();
					userInput.println("New coordinates");
					userInput.println("---------------");
					coordinates = getAndValidateCoordinates(userInput, board.length, board[0].length);
					userInput.println();

				}

				gameConsole.clear();
				showBoard(gameConsole, board);

				if (isBoardFull(board)) {
					gameEnded = true;
					if (hasPlayerWon(board, currentPlayer)) {
						gameConsole.println("Player " + currentPlayer + " wins the game!");
					} else {
						gameConsole.println("TIE! No one has won the game");
					}
				}

				if (hasPlayerWon(board, currentPlayer)) {
					gameEnded = true;
					gameConsole.println("Player " + currentPlayer + " wins the game!");
				}

				switch (currentPlayer) {
				case 'X':
					currentPlayer = player2;
					break;
				case 'O':
					currentPlayer = player1;
					break;
				}

			}

			// TODO: Whatever needs to be done when a game has finished

			// TODO: Do not forget that the user should be able to play a new game when
			// another game has ended

		}

		// We should only reach this point when the user has decided to exit the game.
		// DO NOT MAKE ANY CHANGES HERE.
		userInput.setCursorPosition(0, userInput.getRows() - 1);
		userInput.print("Press any key to exit...");
		userInput.readKey();
		System.exit(0);

	}

	// Private static procedures below. Some of them return dummy values, make sure
	// to change them as appropriate.

	/**
	 * Shows main menu and returns option selected by user
	 * 
	 * @param console
	 * @return
	 */
	private static int showMenuAndSelectOption(JConsole console) {
		/* TODO: Complete */

		int selection;

		console.println("Select option");
		console.println("1. New game");
		console.println("2. Exit");

		console.setForegroundColor(Color.GREEN);
		selection = console.readInt();
		console.resetColor();

		while (!(selection > 0 && selection < 3)) {
			console.setForegroundColor(Color.RED);
			console.println("Menu option must be between 1 (New Game) and 2 (Exit). Reenter your selection: ");
			console.resetColor();
			console.setForegroundColor(Color.GREEN);
			selection = console.readInt();
			console.resetColor();
		}

		return selection;

		// return -1;
	}

	/**
	 * Initializes board with empty spaces
	 * 
	 * @param board
	 */
	private static void initializeBoard(char[][] board) {
		/* TODO: Complete */

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	/**
	 * Shows board on console
	 * 
	 * @param console
	 * @param board
	 */
	private static void showBoard(JConsole console, char[][] board) {
		/* TODO: Complete */

		for (int i = 0; i < board.length; i++) {
			console.print("| ");
			for (int j = 0; j < board[0].length; j++) {
				console.print(board[i][j] + " | ");
			}
			console.println();
		}
	}

	/**
	 * Interacts with user to obtain some valid (within the given parameters)
	 * coordinates.
	 * 
	 * @param console
	 * @param nRows
	 * @param nCols
	 * @return
	 */
	private static int[] getAndValidateCoordinates(JConsole console, int nRows, int nCols) {
		/* TODO: Complete */

		int coordinates[] = new int[2];

		console.print("Insert row number [0, " + (nRows - 1) + "]: ");
		console.setForegroundColor(Color.GREEN);
		coordinates[0] = console.readInt();
		console.resetColor();

		while (coordinates[0] < 0 || coordinates[0] > nRows - 1) {
			console.setForegroundColor(Color.RED);
			console.print("Vaule must be between [0, " + (nRows - 1) + "]. Insert new value: ");
			console.setForegroundColor(Color.GREEN);
			coordinates[0] = console.readInt();
			console.resetColor();

		}

		console.print("Insert column number [0, " + (nCols - 1) + "]: ");
		console.setForegroundColor(Color.GREEN);
		coordinates[1] = console.readInt();
		console.resetColor();

		while (coordinates[1] < 0 || coordinates[1] > nCols - 1) {
			console.setForegroundColor(Color.RED);
			console.print("Vaule must be between [0, " + (nCols - 1) + "]. Insert new value: ");
			console.setForegroundColor(Color.GREEN);
			coordinates[1] = console.readInt();
			console.resetColor();
		}

		return coordinates;
	}

	/**
	 * Coordinates must be valid and player too. Returns true if move can be
	 * performed, false otherwise.
	 * 
	 * @param board
	 * @param coord
	 * @param player
	 * @return
	 */
	private static boolean move(char[][] board, int[] coord, char player) {
		/* TODO: Complete */

		if (board[coord[0]][coord[1]] == ' ') {
			board[coord[0]][coord[1]] = player;
			return true;
		}

		return false;
	}

	/**
	 * Checks if the given board is full. Should return true if it's full, false
	 * otherwise
	 * 
	 * @param board
	 * @return
	 */
	private static boolean isBoardFull(char[][] board) {
		/* TODO: Complete */

		boolean found = true;

		for (int i = 0; i < board.length && found; i++) {
			for (int j = 0; j < board[0].length && found; j++) {
				if (board[i][j] == ' ') {
					found = false;
				}
			}
		}

		return found;
	}

	/**
	 * Returns true if the player has won the game, false otherwise.
	 * 
	 * @param board
	 * @param player
	 * @return
	 */

	private static boolean hasPlayerWon(char[][] board, char player) {
		boolean hasPlayerWon;

		hasPlayerWon = rowWin(board, player);
		if (!hasPlayerWon) {
			hasPlayerWon = columnWin(board, player);
		}

		if (!hasPlayerWon) {
			hasPlayerWon = diagonalWin(board, player);
		}

		if (!hasPlayerWon) {
			hasPlayerWon = invertedDiagonalWin(board, player);
		}

		return hasPlayerWon;
	}

	private static boolean rowWin(char[][] board, char player) {
		boolean differentPlayer;

		for (int i = 0; i < board.length; i++) {
			differentPlayer = false;
			for (int j = 0; j < board[0].length && !differentPlayer; j++) {
				if (board[i][j] != player) {
					differentPlayer = true;
				}
				if (j == board.length - 1 && !differentPlayer) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean columnWin(char[][] board, char player) {
		boolean differentPlayer;

		for (int j = 0; j < board.length; j++) {
			differentPlayer = false;
			for (int i = 0; i < board.length && !differentPlayer; i++) {
				if (board[i][j] != player) {
					differentPlayer = true;
				}
				if (i == board.length - 1 && !differentPlayer) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean diagonalWin(char[][] board, char player) {
		boolean differentPlayer = false;

		for (int i = 0; i < board.length; i++) {
			if (board[i][i] != player) {
				differentPlayer = true;
			}
			if (i == board.length - 1 && !differentPlayer) {
				return true;
			}
		}
		return false;
	}

	private static boolean invertedDiagonalWin(char[][] board, char player) {
		boolean differentPlayer = false;

		for (int i = 0; i < board.length; i++) {
			if (board[i][board.length - i - 1] != player) {
				differentPlayer = true;
			}
			if (i == board.length - 1 && !differentPlayer) {
				return true;
			}
		}
		return false;
	}

}

package sessio2;

import java.awt.Color;
import java.awt.Toolkit;

import jconsole.JConsole;

public class StartGame {
	
	public static void main (String []args) {
		
		//Two consoles, AVOID CHANGING
		JConsole gameConsole = new JConsole(30,10);
		JConsole userInput = new JConsole(60,15);
		
		//Screen size, AVOID CHANGING
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int halfWidthGame = (screenWidth)/4;
		int halfHeightPlayer = (screenHeight)/2;
		
		//Variables
		boolean gameEnded;
		boolean exit;
		Game currentGame;
		
		
		//Additional vars
		//TODO: Add more variables here if you need them
		int playerOption;
		int [] coordenates = new int [2];
		//Console positioning, AVOID CHANGING
		gameConsole.setLocation(halfWidthGame,10);
		userInput.setLocation(halfWidthGame,halfHeightPlayer);
		
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
			
			//TODO: Create the game
			currentGame = new Game();
			//TODO: Show current board 
			gameConsole.print(currentGame.boardToString());
			while(!gameEnded) {
				//TODO: Interact with user and make move
				coordenates = getAndValidateCoordinates(userInput , currentGame.getBoardRows(), currentGame.getBoardCols());
				while(  !(currentGame.move(coordenates[0], coordenates[1]  ) ) ) {
					userInput.setForegroundColor(Color.red);
					userInput.println("\nCell already occupied. You need to enter another coordinate");
					userInput.resetColor();
					coordenates = getAndValidateCoordinates(userInput , currentGame.getBoardRows(), currentGame.getBoardCols());
				}
				
				gameConsole.clear();
				gameConsole.print(currentGame.boardToString());
				
				if( currentGame.hasGameEnded() )  {
					gameConsole.println(currentGame.getEndMessage());
					gameEnded = true;
				}
			}
			userInput.println();
			playerOption = showMenuAndSelectOption(userInput);
			if(playerOption == 1) {
				exit = false;
			}
			else {
				exit = true;
			}
			//TODO: Whatever needs to be done when a game has finished
			
			//TODO: Do not forget that the user should be able to play a new game when another game has ended
			
		}
		
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
	private static int showMenuAndSelectOption(JConsole userInput) {
		//TODO: Complete
		int option = 0;
		userInput.println("Select option \n1. New game \n2. Exit");
		userInput.setForegroundColor(Color.green);
		option = userInput.readInt();
		while(!(option == 1 || option == 2)) {
			userInput.setForegroundColor(Color.red);
			userInput.println("Menu option must be between 1 (New game) and 2 (Exit). Reenter your selection");
			userInput.setForegroundColor(Color.green);
			option = userInput.readInt();
		}
		userInput.resetColor();
		return option;
	}
	
	/**
	 * Interacts with user to obtain some valid (within the given parameters) coordinates.
	 * @param console
	 * @param nRows
	 * @param nCols
	 * @return
	 */
	private static int[] getAndValidateCoordinates(JConsole console, int nRows, int nCols) {
		//TODO: Complete
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

}

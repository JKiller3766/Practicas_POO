package presentation;

import java.awt.Color;
import java.awt.Toolkit;

import domain.Game;
import exceptions.InvalidCoordinatesException;
import exceptions.NoShipException;
import jconsole.JConsole;

public class StartGame {
	
	
	private Game game;
	private JConsole console;
	private JConsole sunkShipInfo;
	
	private StartGame() {
		
		//Do not change this constructor
		
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int halfWidthGame = (screenWidth)/4;
		

		game = new Game();


		console = new JConsole(80,20);
		sunkShipInfo = new JConsole(40,10);
		
		//Console positioning
		sunkShipInfo.setLocation((int) (2*halfWidthGame),0);		
		sunkShipInfo.setCursorVisible(false);
	}
	
	private void run() {
		int []coordinates = new int[2];
		String userInput;
		int totalRow, totalCols;
		String shipTypeName;
		
		
		//Perform setup
		
		
		while(!game.hasEnded()) {
			//Show board
			
			//Get user input
			
			//Parse and validate user input
			
			//Make move
			
			//Show result (HIT, MISS, SUNK SHIP)
			
			//If ship sunk, show info
			

		}

		
		console.println();
		console.println("Congratulations! You sunk all ships!");
		console.println("Press any key to close...");
		console.readKey();
		System.exit(0);
	}
	
	//TODO: A l'enunciat, indicar que suposin d'entrada que l'input conté els elements indicats. Ja ho canviarem després.
	private int[] parseAndValidateCoordinates(String input) { 
		//TODO: Complete
		return null;
	}
	
	private void end() {
		//Do not modify this code		
		console.println("Congratulations! You sunk all ships!");
		console.println("Press any key to close...");
		console.readKey();
		System.exit(0);	
	}

	
	public static void main(String [] args) throws Exception {
		//Do not modify this code
		StartGame runningGame = new StartGame();
		runningGame.run();
		runningGame.end();
	}

}

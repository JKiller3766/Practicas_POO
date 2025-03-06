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
		
		console.println(game.boardToString());
		sunkShipInfo.println("SUNK SHIP INFO");
		sunkShipInfo.println("**************");
		while(!game.hasEnded()) {
			//Show board	
			
			
			//Get user input
			console.print("\nPlease enter a row (0 - 9) and column (0 - 9) separated by a comma: ");
			userInput = console.readString();
			
			//Parse and validate user input
			coordinates = parseAndValidateCoordinates(userInput);
			while(coordinates[0]<0 || coordinates[0]>9 || coordinates[1]<0 || coordinates[1]>9) {
				console.clear();
				console.println(game.boardToString());
				console.print("\nPlease enter a row (0 - 9) and column (0 - 9) separated by a comma: ");
				userInput = console.readString();
				coordinates = parseAndValidateCoordinates(userInput);
			}
			
			//Make move
			if(game.shootAndHit(coordinates[0], coordinates[1])) {
				console.setForegroundColor(Color.green);
				console.clear();
				console.println("You HIT a ship\n");
				if(game.hasShipSunk(coordinates[0], coordinates[1])){
					console.println(game.getShipTypeName(coordinates[0], coordinates[1]) + " SUNK!");
				}
				console.resetColor();
				console.println(game.boardToString());							
			}
			else {
				console.setForegroundColor(Color.red);
				console.clear();
				console.println("MISS\n");
				console.resetColor();
				console.println(game.boardToString());
			}
			//Show result (HIT, MISS, SUNK SHIP)
			//If ship sunk, show info
			if(game.hasShipSunk(coordinates[0], coordinates[1])){
				sunkShipInfo.clear();
				sunkShipInfo.println(game.sunkShipInfo());
			}

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
		String [] coords;
		coords = input.split(",");
		int [] numCoords = new int [coords.length];
		
		for(int i = 0; i<numCoords.length; i++) {
			numCoords[i] = Integer.parseInt(coords[i]);
		}
		return numCoords;
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

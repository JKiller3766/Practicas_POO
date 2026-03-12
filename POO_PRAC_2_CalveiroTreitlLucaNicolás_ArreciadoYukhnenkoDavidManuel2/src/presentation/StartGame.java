package presentation;

import java.awt.Color;
import java.awt.Toolkit;

import domain.Game;
import domain.SurvivorGame;
import jconsole.JConsole;

public class StartGame {

	/*
	 * WARNING: DO NOT MODIFY THIS CODE IN ANY WAY. THE ONLY MODIFICATION YOU CAN
	 * MAKE IS CHANGING new Game FOR new SurvivorGame
	 */

	public static void main(String[] args) {

		JConsole console = new JConsole(80, 25);

		// Screen size
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int halfWidthGame = (screenWidth) / 4;

		// Variables
		boolean gameEnded = false;
		boolean beginGame;
		boolean battleEnded;
		boolean selectedFighters = false;
		int menuOption;
		int firstFighter;
		int secondFighter;
		Game currentGame;

		// Additional vars
		int numChars = 0, addedChars;
		String currentChars;

		// Console positioning
		console.setLocation(halfWidthGame, 0);

		console.println("Welcome to the game!");
		console.println("--------------------");

		// We create the game
		while (numChars < 2) {
			console.println("Please enter how many characters you'd like to create (at least 2):");
			console.setForegroundColor(Color.GREEN);
			numChars = console.readInt();
			console.resetColor();
		}

		// To create a standard game
		//currentGame = new Game(numChars);

		// To create a survivor-only game
		currentGame = new SurvivorGame(numChars);

		beginGame = false;
		addedChars = 0;

		// We create the characters
		while (!beginGame) {
			// Show next menu
			menuOption = showCharacterMenuAndSelect(console);
			// Parse result
			createSelectedCharacter(menuOption, currentGame, console);
			console.println();
			addedChars++;
			beginGame = (addedChars >= numChars);
		}
		console.clear();

		while (!gameEnded) {
			// At this point, we initialize the game

			// Show all characters
			console.println("Characters and status");
			console.println("*********************");
			currentChars = currentGame.charactersAndStatus();
			console.print(currentChars);
			console.println("*********************");
			console.println();

			// Select the two characters that will fight
			while (!selectedFighters) {
				console.println("Select the two characters that will fight, enter their IDs");
				firstFighter = validateSelectedFighter(numChars, "Enter first fighter number", console);
				secondFighter = validateSelectedFighter(numChars, "Enter second fighter number", console);
				if (firstFighter == secondFighter) {
					console.setForegroundColor(Color.RED);
					console.println("A fighter cannot attack themselves!");
					console.resetColor();
				} else {
					// We set the fighters for the game
					selectedFighters = currentGame.selectFighters(firstFighter, secondFighter);
					if (!selectedFighters) {
						console.setForegroundColor(Color.RED);
						console.println("Wrong character selection (either no character in position, or dead)");
						console.resetColor();
					}
				}
			}
			console.clear();
			battleEnded = false;

			// Bucle mentre no ha finalitzat partida

			while (!battleEnded) {
				console.setForegroundColor(Color.YELLOW);
				console.println("Fighters' stats at the beginning: ");
				console.resetColor();
				console.println(currentGame.fightersStatus());

				if (currentGame.performAttack()) {
					// Attack was successful
					console.setForegroundColor(Color.GREEN);
					console.println("The attack was successful\n");
					console.resetColor();
				} else {
					console.setForegroundColor(Color.RED);
					console.println("The attack failed\n");
					console.resetColor();
				}

				console.setForegroundColor(Color.YELLOW);
				console.println("Fighters' stats at the end: ");
				console.resetColor();
				console.println(currentGame.fightersStatus());

				battleEnded = currentGame.hasBattleEnded();

				if (battleEnded) {
					console.setForegroundColor(Color.YELLOW);
					console.println("Battle has ended");
					console.resetColor();
				}

				console.println("Press any key to continue...");
				console.readKey(true);
				console.clear();

			}

			gameEnded = currentGame.hasGameEnded();
			selectedFighters = false;
		}

		// Game END!

		console.println("The overall WINNER is: ");
		console.setForegroundColor(Color.GREEN);
		console.println(currentGame.getWinnerInfo());
		console.resetColor();

		console.setCursorPosition(0, console.getRows() - 1);
		console.print("Press any key to exit...");
		console.readKey();
		System.exit(0);

	}

	/**
	 * Rep la consola com a paràmetre d’entrada i retorna l’opció de menú
	 * seleccionada per l’usuari. El procediment s’encarrega de mostrar un menú a
	 * l’usuari per seleccionar un personatge (guerrer, mag, o arquer). Si l’opció
	 * seleccionada no està entre les donades, el procediment insisteix fins que
	 * l’usuari introdueix l’opció correcta.
	 * 
	 * @param console
	 * @return
	 */
	private static int showCharacterMenuAndSelect(JConsole console) {
		int selectedOption;
		console.println("Select option");
		console.println("1. Add Warrior");
		console.println("2. Add Mage");
		console.println("3. Add Archer");
		console.setForegroundColor(Color.GREEN);
		selectedOption = console.readInt();
		while (selectedOption < 1 || selectedOption > 3) {
			console.setForegroundColor(Color.RED);
			console.println("Menu option must be between 1 and 3. Reenter your selection: ");
			console.setForegroundColor(Color.GREEN);
			selectedOption = console.readInt();
		}
		console.resetColor();
		console.println();
		return selectedOption;
	}

	/**
	 * Returns true if player is ready to begin the game
	 * 
	 * @param num
	 * @param currentGame
	 * @param console
	 * @return
	 */
	private static void createSelectedCharacter(int num, Game currentGame, JConsole console) {
		switch (num) {
		case 1:
			addWarrior(currentGame, console);
			break;
		case 2:
			addMage(currentGame, console);
			break;
		case 3:
			addArcher(currentGame, console);
			break;
		}
	}

	private static void addWarrior(Game currentGame, JConsole console) {
		String name;
		int health;
		int strength;
		console.println("You're creating a warrior");
		name = getCharName(console);
		health = getCharHealth(console);
		console.println("Now enter the warrior's strength (>10): ");
		strength = console.readInt();
		while (strength <= 10) {
			console.setForegroundColor(Color.RED);
			console.println("Warrior's strength must be >10");
			console.resetColor();
			strength = console.readInt();
		}
		if (currentGame.createWarrior(name, health, strength)) {
			console.println("You've successfully created a warrior!");
		} else {
			console.setForegroundColor(Color.RED);
			console.println("Sorry, no more characters can be added");
			console.resetColor();
		}

	}

	private static void addMage(Game currentGame, JConsole console) {
		String name;
		int health;
		int mana;
		int power;
		console.println("You're creating a mage");
		name = getCharName(console);
		health = getCharHealth(console);
		console.println("Now enter the mage's mana (>60): ");
		// console.setForegroundColor(Color.GREEN);
		mana = console.readInt();
		// console.resetColor();
		while (mana <= 60) {
			console.setForegroundColor(Color.RED);
			console.println("Mage's mana must be >60");
			console.resetColor();
			mana = console.readInt();
		}
		console.println("Now enter the mage's magic power (>10): ");
		power = console.readInt();
		while (power <= 10) {
			console.setForegroundColor(Color.RED);
			console.println("Mage's magic power must be >10");
			console.resetColor();
			power = console.readInt();
		}
		if (currentGame.createMage(name, health, mana, power)) {
			console.println("You've successfully created a mage!");
		} else {
			console.setForegroundColor(Color.RED);
			console.println("Sorry, no more characters can be added");
			console.resetColor();
		}
	}

	private static void addArcher(Game currentGame, JConsole console) {
		String name;
		int health;
		int accuracy;
		int arrowDamage;
		console.println("You're creating an archer");
		name = getCharName(console);
		health = getCharHealth(console);
		console.println("Now enter the archer's accuracy (>30): ");
		accuracy = console.readInt();
		while (accuracy <= 30) {
			console.setForegroundColor(Color.RED);
			console.println("Archer's accuracy must be >30");
			console.resetColor();
			accuracy = console.readInt();
		}
		console.println("Now enter the archer's arrow damage (>5): ");
		arrowDamage = console.readInt();
		while (arrowDamage <= 5) {
			console.setForegroundColor(Color.RED);
			console.println("Archer's arrow damage must be >30");
			console.resetColor();
			arrowDamage = console.readInt();
		}
		if (currentGame.createArcher(name, health, accuracy, arrowDamage)) {
			console.println("You've successfully created an archer!");
		} else {
			console.setForegroundColor(Color.RED);
			console.println("Sorry, no more characters can be added");
			console.resetColor();
		}
	}

	private static String getCharName(JConsole console) {
		String name;
		console.println("Please enter the character's name");
		name = console.readString();
		return name;
	}

	private static int getCharHealth(JConsole console) {
		int health;
		console.println("Please enter the character's health (>0)");
		health = console.readInt();
		while (health <= 0) {
			console.setForegroundColor(Color.RED);
			console.println("Health must be greater than 0");
			console.resetColor();
			console.println("Please enter the character's health");
			health = console.readInt();
		}
		return health;
	}

	private static int validateSelectedFighter(int maxChar, String text, JConsole console) {
		int selectedChar;
		console.println(text);
		console.setForegroundColor(Color.GREEN);
		selectedChar = console.readInt();
		console.resetColor();
		while (selectedChar >= maxChar) {
			console.setForegroundColor(Color.RED);
			console.println("No fighter with given number. Number must be between 0 and " + (maxChar - 1));
			console.resetColor();
			console.println("Enter new fighter number");
			console.setForegroundColor(Color.GREEN);
			selectedChar = console.readInt();
			console.resetColor();
		}
		return selectedChar;
	}

}

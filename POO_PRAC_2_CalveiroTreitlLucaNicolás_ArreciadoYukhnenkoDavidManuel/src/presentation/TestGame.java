package presentation;

import java.util.Random;

import domain.Game;
import domain.SurvivorGame;

public class TestGame {

	public static void main(String[] args) {
		/* TODO: Complete this class to test the game */

		// "Standard" game
		// **************
		Game currentGame;
		int attacker = -1, defender = -1;
		Random alea = new Random();

		currentGame = new Game(3);

		// Create game

		System.out.println("-------------");
		System.out.println("GAME");
		System.out.println("-------------");
		// Generate random stats for warrior
		// Add warrior to game, use Game's provided function
		currentGame.createWarrior("TOMATE", alea.nextInt(1, 41), alea.nextInt(11, 101));
		// Generate random stats for mage
		// Add mage to game
		currentGame.createMage("LECHUGA", alea.nextInt(1, 41), alea.nextInt(61, 101), alea.nextInt(11, 101));
		// Generate random stats for archer
		// Add archer to game
		currentGame.createArcher("ZANAHORIA", alea.nextInt(1, 41), alea.nextInt(31, 101), alea.nextInt(6, 101));

		// Show info, inform user beginning of standard game
		System.out.println("-------------");
		System.out.println("BEFORE BATTLE");
		System.out.println("-------------");
		System.out.println(currentGame.charactersAndStatus());
		// Simulate combat (DO NOT USE while(true))
		while (!currentGame.hasGameEnded()) {
			// Select fighters randomly, they have to be alive
				do {
					do {
						attacker = alea.nextInt(0, 3);
						defender = alea.nextInt(0, 3);
					} while (attacker == defender);
				} while (!currentGame.selectFighters(attacker, defender));

			// Simulate battle until it ends

			while (!currentGame.hasBattleEnded()) {
				currentGame.performAttack();
			} // Battle has ended

		}

// When combat ends, show all **available** characters' info
		System.out.println("------------");
		System.out.println("AFTER BATTLE");
		System.out.println("------------");
		System.out.println(currentGame.charactersAndStatus());
// Show winner
		System.out.println("------");
		System.out.println("WINNER");
		System.out.println("------");
		System.out.println(currentGame.getWinnerInfo());
// This is the end of "standard" game
// **************

// "Survivor" game
// **************
		System.out.println("");
		System.out.println("");
		System.out.println("-------------");
		System.out.println("SURVIVOR GAME");
		System.out.println("-------------");

// Create survivor game
		currentGame = new SurvivorGame(3);
// Generate random stats for warrior
// Add warrior to game, use Game's provided function
		currentGame.createWarrior("TOMATE", alea.nextInt(1, 101), alea.nextInt(11, 101));

// Generate random stats for mage
// Add mage to game
		currentGame.createMage("LECHUGA", alea.nextInt(1, 101), alea.nextInt(61, 101), alea.nextInt(11, 101));
// Generate random stats for archer
// Add archer to game
		currentGame.createArcher("ZANAHORIA", alea.nextInt(1, 101), alea.nextInt(31, 101), alea.nextInt(6, 101));
// Show info, inform user beginning of survivor game

		System.out.println("-------------");
		System.out.println("BEFORE BATTLE");
		System.out.println("-------------");
		System.out.println(currentGame.charactersAndStatus());


// Simulate combat (DO NOT USE while(true))
		while (!currentGame.hasGameEnded()) {
// Select fighters randomly, they have to be alive
				do {
					do {
						attacker = alea.nextInt(0, 3);
						defender = alea.nextInt(0, 3);
					} while (attacker == defender);
				} while (!currentGame.selectFighters(attacker, defender));
// Simulate battle until it ends
			while (!currentGame.hasBattleEnded()) {
				currentGame.performAttack();
			}
// Battle has ended
		}

// When combat ends, show all available characters' info
		System.out.println("------------");
		System.out.println("AFTER BATTLE");
		System.out.println("------------");
		System.out.println(currentGame.charactersAndStatus());
// Show winner
		System.out.println("------");
		System.out.println("WINNER");
		System.out.println("------");
		System.out.println(currentGame.getWinnerInfo());
// This is the end of "survivor" game
// **************

	}

}

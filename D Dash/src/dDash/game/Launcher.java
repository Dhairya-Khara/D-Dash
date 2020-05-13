/*
 * By: Dhairya Khara
 * This class contains the main method for Darla's arcade. If running from the first time,
 * one will have to run from this class
 */
package dDash.game;

import dDash.states.GameState;

public class Launcher {

	public static void main(String[] args) {

		//creating game object
		Game game = new Game("D Dash", 700, 600);

		//starting the thread from the Game Class
		game.start();
		
		//running music
		while (game.getRunning() == true) {
			GameState.runMusic();
		}

	}

}

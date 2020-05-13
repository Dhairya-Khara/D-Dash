/*
 * By: Dhairya Khara
 * This class is used to check if any key is pressed or not. Any class that requires key input
 * must go through this class.
 */
package dDash.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	// array that holds all the keys
	private boolean[] keys;

	// variables that toggle true and false depending on if a specific key is
	// pressed or not
	public boolean up, down, restart, start, returnToMain, help;

	// creating an array to hold the maximum number of key inputs possible
	public KeyManager() {
		keys = new boolean[999999999];
	}

	// method to check if a key is pressed or not, this method is required because
	// KeyListener
	// is implemented
	@Override
	public void keyPressed(KeyEvent e) {

		keys[e.getKeyCode()] = true;

	}

	// all the boolean variables are assigned to a specific key
	public void tick() {
		// this key input is used to move the character up. assigned to the up arrow key
		up = keys[KeyEvent.VK_UP];
		// this key input is used to move the character down. assigned to the down arrow
		// key
		down = keys[KeyEvent.VK_DOWN];

		// this key input is used to restart the game if in the game state or return to
		// the main menu if in the help state. Assigned to the  R key
		restart = keys[KeyEvent.VK_R];

		//this key input is used to start the game from the menu state
		start = keys[KeyEvent.VK_ENTER];

		//this key input is used to return to the main menu if in the game state
		returnToMain = keys[KeyEvent.VK_E];

		//this key input is used to switch to the help state if in the menu state
		help = keys[KeyEvent.VK_H];

	}

	//required method for the implemented interface
	
	//checking if key released(not used but required)
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;

	}

	//checking if key typed (not used but required)
	@Override
	public void keyTyped(KeyEvent e) {

	}

}

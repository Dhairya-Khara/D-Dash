/*
 * By: Dhairya Khara
 * This is an abstract class, State. All other states are children of this class. This class
 * has all the information required by other States.
 */
package  dDash.states;

import java.awt.Graphics;

import dDash.game.Handler;

public abstract class State {

	// variable which holds which state the game currently is in
	private static State currentState = null;
	int orderOfState;
	// Handler object
	protected Handler handler;

	// constructor that passes a handler as a parameter because different states
	// might
	// require to use data from other classes
	public State(Handler handler) {
		this.handler = handler;
	}

	// returns the current state the game is in
	public static State getCurrentState() {
		return currentState;
	}

	// sets the current state the game is in
	public static void setCurrentState(State currentState) {
		State.currentState = currentState;
	}

	// abstract tick method. This tick method is used to call the methods that need
	// to be called repeatedly
	public abstract void tick();

	// abstract render method. This method is used to draw all the graphics required
	// by the other states
	public abstract void render(Graphics g);

}

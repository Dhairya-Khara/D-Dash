/*
 * By: Dhairya Khara
 * This state is seen by the user if the user needs help with the controls of the game.
 * Accessed through the MenuState only
 */
package  dDash.states;

import java.awt.Color;
import java.awt.Graphics;

import dDash.game.Game;
import dDash.game.Handler;
import dDash.gfx.Assets;

//This is a child of the State Class. It also implements the TickAndRender interface
public class HelpState extends State implements TickAndRender {

	//constructor, required because child of State class
	public HelpState(Handler handler) {
		super(handler);
		orderOfState = 2;
	}
	
	//ticks the get Input method repeatedly because user can input any time
	public void tick() {
		getInput();
	}

	//renders the instuction for the menu state
	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 700, 650);
		
		g.drawImage(Assets.helpScreen,0,0,700,650, null);
		
		
		
	}
	
	//method used to get key input to return to the main menu
	public void getInput() {
		if(handler.getKeyManager().restart) {
			State.setCurrentState(Game.allStates[0]);
		}
	}
}

/*
 * By: Dhairya Khara
 * This is the MenuState. This State brings all the other States together. All information of 
 * the menu is from or goes through this class
 */
package  dDash.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dDash.game.Game;
import dDash.game.Handler;
import dDash.gfx.Assets;

//This is a child of the State class. It also implements the TickAndRender interface
public class MenuState extends State implements TickAndRender {
	

	//Constructor required because it is a child class of the State class
	public MenuState(Handler handler) {
		super(handler);
		orderOfState = 1;
	}
	
	//Calls the getInput method repeatedly because user can input anythime
	public void tick() {
		getInput();
	}

	//renders the image and texts of the menu 
	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 700, 650);
		
		g.drawImage(Assets.menuScreen,0,0,700,650, null);
		
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 15));
		g.drawString("Press H for Help", 500,590);
		
		
		
	}
	//two inputs. One to launch the game and the other to go to help
	public void getInput() {
		if(handler.getKeyManager().start) {
			State.setCurrentState(Game.allStates[2]);
		}
		if(handler.getKeyManager().help) {
			State.setCurrentState(Game.allStates[1]);
		}
	}
}

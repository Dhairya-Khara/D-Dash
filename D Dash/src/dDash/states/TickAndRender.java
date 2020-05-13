/*
 * By: Dhairya Khara
 * This interface is implemented by other States that require the tick and render methods
 */
package  dDash.states;

import java.awt.Graphics;

public interface TickAndRender {
	//  tick method. This tick method is used to call the methods that need
	// to be called repeatedly
	public void tick() ;
	
	// abstract render method. This method is used to draw all the graphics required
	// by the other states
	public void render(Graphics g);
	
	public void getInput();
}

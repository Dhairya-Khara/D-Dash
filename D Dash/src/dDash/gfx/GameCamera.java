/*
 * By: Dhairya Khara
 * This is the game camera class. This camera is used to move with the character
 */

package dDash.gfx;


import dDash.entities.User;
import dDash.game.Game;

public class GameCamera {

	//variables that calculate how much the camera needs to get offseted by
	private float xOffset, yOffset;
	
	//Game Object
	private Game game;
	
	//Constructor. Used to set the default values
	public GameCamera(Game game, float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.game = game;
	}
	
	//method responsible to move the camera
	public void centerOnEntity(User user) {
		//moving the camera according to the xOffset. Y not Required
		xOffset = user.getX() - game.getWidth()/2 + user.getWidth()/2;

	}
	
	//method used to calculate how much the offsets should be
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
	}
	
	//returns the xOffset
	public float getxOffset() {
		return xOffset;
	}
	//sets the xOffset
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}
	//returns the yOffset
	public float getyOffset() {
		return yOffset;
	}

	//sets the yOffset
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	
}

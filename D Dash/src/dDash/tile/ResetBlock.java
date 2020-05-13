/*
 * By: Dhairya Khara
 * This tile is used to rest the game if collided with. Found at the end of the world
 */
package  dDash.tile;

import dDash.gfx.Assets;

//This class is a child of the Tile class. 

public class ResetBlock extends Tile{

	public ResetBlock( int id) {
		super(Assets.restartBlock, id);
		
	}
	
	//This tile is used to reset the game if collided with
	public boolean isReset() {
		return true;
	}

}

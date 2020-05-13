/*
 * By: Dhairya Khara
 * This class holds information about the block Tile.
 */
package  dDash.tile;

import dDash.gfx.Assets;

//This class is a child of the Tile class. 
public class BlockTile  extends Tile {

	public BlockTile(int id) {
		super(Assets.block, id);
	}
	
	//This tile is checked for collision
	public boolean isSolid() {
		return true;
	}
	
	//This tile is used to represent the black squares in the world
}

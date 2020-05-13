/*
 * By: Dhairya Khara
 * This class holds information about the  pointed square Tile.
 */
package  dDash.tile;

import dDash.gfx.Assets;

//This class is a child of the Tile class. 

public class PointedTile extends Tile{

	
	public PointedTile( int id) {
		super(Assets.pointedTile, id);
	}
	
	// This tile is used to check collision

	public boolean isSolid() {
		return true;
	}
	
	// This tile is used to represent the tile with pointed square in our world


}

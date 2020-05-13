/*
 * By: Dhairya Khara
 * This class holds information about the diamond Tile.
 */
package  dDash.tile;

import dDash.gfx.Assets;

//This class is a child of the Tile class. 
public class DiamondTile extends Tile {

	public DiamondTile(int id) {
		super(Assets.diamondBox, id);
	}

	// This tile is used to check collision
	public boolean isSolid() {
		return true;
	}

	// This tile is used to represent the tile with mini diamonds in our world

}

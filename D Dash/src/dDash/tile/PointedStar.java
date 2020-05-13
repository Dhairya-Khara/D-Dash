/*
 * By: Dhairya Khara
 * This class holds information about the orange pointed star Tile.
 */
package  dDash.tile;

import dDash.gfx.Assets;

//This class is a child of the Tile class. 
public class PointedStar extends Tile {

	public PointedStar(int id) {
		super(Assets.pointedStar, id);
	}
	// This tile is used to check collision
	public boolean isSolid() {
		return true;
	}
	
	// This tile is used to represent the tile with orange stars in our world
}

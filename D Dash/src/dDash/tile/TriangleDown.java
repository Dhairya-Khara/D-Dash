/*
 * By: Dhairya Khara
 * This class holds information about the  down facing triangles Tile.
 */
package  dDash.tile;

import dDash.gfx.Assets;

//This class is a child of the Tile class. 

public class TriangleDown extends Tile {

	public TriangleDown(int id) {
		super(Assets.triangleDown, id);
		
	}
	// This tile is used to check collision

	@Override
	public boolean isSolid() {
		return true;
	}
	
	// This tile is used to represent the tile with down facing triangles in our world
}

/*
 * By: Dhairya Khara
 * This class holds information about the  down facing triangles Tile.
 */
package  dDash.tile;

import dDash.gfx.Assets;

//This class is a child of the Tile class. 

public class TriangleUp extends Tile {

	public TriangleUp(int id) {
		super(Assets.triangleUp, id);

	}

	// This tile is used to check collision
	@Override
	public boolean isSolid() {
		return true;
	}

	// This tile is used to represent the tile with up facing triangles in our world
}

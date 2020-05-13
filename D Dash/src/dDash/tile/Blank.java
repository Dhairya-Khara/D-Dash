/*
 * By: Dhairya Khara
 * This class holds information about the blank Tile.
 */
package  dDash.tile;

import dDash.gfx.Assets;

//This class is a child of the Tile class. 
public class Blank extends Tile {

	
	public Blank(int id) {
		super(Assets.blank, id);
	}
	
	//The blank tile is a tile to represent empty space in the world
	
	
}

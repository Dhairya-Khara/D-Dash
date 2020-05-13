/*
 * By: Dhairya Khara
 * This is the class that brings all Tiles together. It is also the parent of all the tiles.
 * This class sets each Tile to a id which can be used by the world file to generate different
 * tiles at desired locations
 */
package  dDash.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	
	//Array that holds all the tiles
	public static Tile[] tiles = new Tile[10000000];
	
	//each tile assigned to a numerical id
	public static Tile blockTile = new BlockTile(0);
	public static Tile triangleUp = new TriangleUp(1);
	public static Tile triangleDown = new TriangleDown(2);
	public static Tile blank = new Blank(3);
	public static Tile diamondTile = new DiamondTile(4);
	public static Tile pointedTile = new PointedTile(5);
	public static Tile pointedStar = new PointedStar(6);
	public static Tile resetBlock = new ResetBlock(7);

	//variable that actually holds the image of the tile
	protected BufferedImage texture;
	//variable that holds the id for each tile
	protected final int id;
	
	//width and height of the tiles
	public static final int TILEWIDTH = 40, TILEHEIGHT = 40;
	
	//constructor which sets the default variables for many variable above
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	//method that gets the id for tiles
	public int getId() {
		return id;
	}
	
	
	//method that renders the actual tile
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x,y,TILEWIDTH,TILEHEIGHT, null);
	}
	
	//method to check if a tile is applicable for collision
	public boolean isSolid() {
		return false;
		
	}
	
	
	//method to check if a tile if applicable for collision, if there is a collision, the game restarts
	public boolean isReset() {
		return false;
	}
}

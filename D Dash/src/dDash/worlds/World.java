/*
 * By: Dhairya Khara
 * This class is used to generate the world. All data required to generate the world comes from
 * this class. The world is a text file which is used to render each tile at the correct position
 */
package  dDash.worlds;

import java.awt.Graphics;

import dDash.game.Handler;
import dDash.tile.Tile;
import dDash.utils.Utils;

public class World {

	// width and height of the 2D array that holds each tile
	private int width, height;
	// Handler object to access data from other locations
	private Handler handler;
	// spawn variables for each tile
	public static int spawnX;
	public static int spawnY;

	// 2D array that holds all the tiles
	private int[][] tiles;

	// Constructor
	public World(Handler handler, String path) {

		this.handler = handler;

		// calling the loadWorld method to render the world
		loadWorld(path);

	}

	// method used to load the world. The parameter is a String object which holds
	// the path to world file
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		//the text file used white spaces to separate between two tiles
		String[] tokens = file.split("\\s+");
		
		//passing the appropriate tile to the 2D array
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];

		//converts the string "1" to 1 for each id for every tile
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}

	}

	//method used to update world date
	public void tick() {

	}
	//method used to render every tile
	public void render(Graphics g) {

		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
				;
			}
		}

	}
	
	//Method used to get a particular tile from the tile array
	public Tile getTile(int x, int y) {
		//if user somehow finds a bug and escapes the world. The piece of code does not crash the game
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.blockTile;
	
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.blockTile;
		return t;

	}
}

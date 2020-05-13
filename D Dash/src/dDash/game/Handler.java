/*
 * By: Dhairya Khara
 * This class is used has all the data that other classes might require. 
 * If Data from another class is required, it must go through the handler
 */
package dDash.game;

import dDash.gfx.GameCamera;
import dDash.input.KeyManager;
import dDash.worlds.World;

public class Handler {

	//declaring game object
	private Game game;
	//declaring world object
	private World world;

	//constructor to pass default values
	public Handler(Game game) {
		this.game = game;
	}
	

	//returns game object
	public Game getGame() {
		return game;
	}

	//sets game object
	public void setGame(Game game) {
		this.game = game;
	}

	//returns the world object
	public World getWorld() {
		return world;
	}

	//sets the world object
	public void setWorld(World world) {
		this.world = world;
	}

	//returns the width of the JFrame
	public int getWidth() {
		return game.getWidth();
	}

	//returns height of the JFrmae
	public int getHeight() {
		return game.getHeight();
	}
	
	//returns the KeyManager
	public KeyManager getKeyManager() {
		return game.getKeyManager();

	}
	
	//returns the GameCamera
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}

}

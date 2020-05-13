/*
 * By: Dhairya Khara
 * This is the GameState. All the logic during Game Play is in this state.
 */
package dDash.states;

import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import dDash.entities.User;
import dDash.game.Handler;
import dDash.gfx.Assets;
import dDash.worlds.World;

//This class is the child of the State class and implements the Tick and Render interface
public class GameState extends State implements TickAndRender {

	//World object
	private World world;
	//User Object
	private User user;
	
	
	//Constructor which makes the player, makes the world.
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		user = new User(handler, 10, 450, 40, 40);
		orderOfState = 3;
		
	}

	//ticks the character and the world (all required methods are called repeatedly)
	@Override
	public void tick() {

		world.tick();
		user.tick();
		
	}

	//calls the render methods of the world and user classes
	@Override
	public void render(Graphics g) {
		//the background of the game is rendered
		g.drawImage(Assets.background, 0, 0, null);
		world.render(g);
		user.render(g);
		

	}

	//method to run music
	public static void runMusic() {

		// This gets the path to the project, but not into /src for eclipse
		String path = new File("").getAbsolutePath() + "\\res/music/Virus-Crop.wav";
		// Make a File object with a path to the audio file.
		File sound = new File(path);

		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			Clip c = AudioSystem.getClip();
			c.open(ais); // Clip opens AudioInputStream
			c.start(); // Start playing audio

			// sleep thread for length of the song
			Thread.sleep((int) (c.getMicrosecondLength() * 0.001));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void getInput() {
		
	}

}

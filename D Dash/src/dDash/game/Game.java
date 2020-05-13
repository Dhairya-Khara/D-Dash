/*
 * By: Dhairya Khara
 * This is the class that holds the logic for the game. Initalizes the thread the game is going to run
 * This class runs the tick and render method from every other class. In addition, all key inputs and
 *  all states are accessed through this class
 */
package dDash.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dDash.display.Display;
import dDash.gfx.Assets;
import dDash.gfx.GameCamera;
import dDash.input.KeyManager;
import dDash.states.GameState;
import dDash.states.HelpState;
import dDash.states.MenuState;
import dDash.states.State;

public class Game implements Runnable {

	// creating a display object to display the JFrame
	private Display display;
	// int and height of the frame
	private int width, height;
	// title of the game
	public String title;
	// variable to see if the game is running or not
	public static boolean running = false;
	// thread the game runs on
	private Thread thread;

	// BufferStrategy for the thread
	private BufferStrategy bs;
	// Graphics object to render everything
	private Graphics g;
	// KeyManager object to check for inputs
	private KeyManager keyManager;

	//GameCamera object for the classes that require it
	private GameCamera gameCamera;

	//Handler object to access data from other classes
	private Handler handler;

	
	

	//array of objects that is going to hold the states
	public static State allStates[] = new State[3];


	//constructor to give some of the variables the default values
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;

		//initializing keyManager object
		keyManager = new KeyManager();

	}

	@Override
	public void run() {
		//Game Timer. To make the FPS at a 60 constant
		
		//calling the init() method to initialize the display, images, all the states, etc.
		init();
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;

			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				delta--;
				ticks++;
			}

			if (timer >= 1000000000) {
				ticks = 0;
				timer = 0;
			}

		}
		//calling the stop method because that method is required to stop the thread properly
		stop();
	}

	private void init() {
		//making a display object
		display = new Display(title, width, height);
		//adding the keyManager to the frame so it can listen to the inputs
		display.getFrame().addKeyListener(keyManager);
		//getting all the images from the Assets class
		Assets.init();

		//initializing the gameCamera object
		gameCamera = new GameCamera(this, 0, 0);
		//initializing the handler object
		handler = new Handler(this);

		//initializing all the states for other classes to use
		allStates[0] = new MenuState(handler);
		allStates[1] = new HelpState(handler);
		allStates[2] = new GameState(handler);
		
		
		//setting the current state to the menu state because the game needs to start with it
		State.setCurrentState(allStates[0]);

	}

	//method that calls the tick method of the current state
	private void tick() {
		//ticking the keyManager repeatedly because input can come any time
		keyManager.tick();
		
		//ticking the method of the current state
		if (State.getCurrentState() != null) {
			State.getCurrentState().tick();
		}

	}

	//method that calls the render method of the current state
	private void render() {

		//getting the buffer strategy of the canvas
		bs = display.getCanvas().getBufferStrategy();
		//setting the buffer strategy to 3 for smoother running
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();
		
		//Rendering the method of the current state
		if (State.getCurrentState() != null) {
			
			State.getCurrentState().render(g);

		}
		
		//showing the graphics
		bs.show();
		//clear the JFrame repeatedly to avoid overlapping
		g.clearRect(0, 0, width, height);

		//disposing the graphics once they are rendered
		g.dispose();

	}

	//method to start the thread
	public synchronized void start() {
		//don't want to start the thread if already running
		if (running) {
			return;
		}

		//starting the tread
		running = true;
		thread = new Thread(this);
		thread.start();

	}

	
	//method to stop the thread
	public synchronized void stop() {
		
		//dont want to stop the thread if already stopped
		if (running == false) {
			return;
		}
		//stopping the thread. Exception Handling for smooth stop if something happened
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//returngs the GameCamera object
	public GameCamera getGameCamera() {
		return gameCamera;
	}

	//returns the running variable
	public boolean getRunning() {
		return running;
	}

	//returns width of JFrame
	public int getWidth() {
		return width;
	}
	
	//sets the width of the JFrame
	public void setWidth(int width) {
		this.width = width;
	}

	//gets the height of the JFrame
	public int getHeight() {
		return height;
	}
	
	//sets the height of the JFrame
	public void setHeight(int height) {
		this.height = height;
	}
	
	//returns the KeyManager
	public KeyManager getKeyManager() {
		return keyManager;
	}

}

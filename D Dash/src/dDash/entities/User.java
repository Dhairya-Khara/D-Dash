/*
 *By: Dhairya Khara
 *This class is the class for the player. The player's moment, his/her rendering. etc. is all
 *taken care by this class. In addition, collision detection is also implemented in the class 
 */
package dDash.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import dDash.game.Game;
import dDash.game.Handler;
import dDash.gfx.Assets;
import dDash.states.State;
import dDash.tile.Tile;

public class User {

	// variable responsible for the x co-ordinate of the player on the JFrame
	public static float x;
	// variable responsible for the y co-ordinate of the player on the JFrame
	private float y;

	// width of the player
	private int width;
	// height of the player
	private int height;

	// making a handler object to access information from other classes
	private Handler handler;

	// these are how many pixels the character will move in the y direction when
	// required to do so
	private int ySpeed = 7;
	// these are how many pixels the character will move in the x direction when
	// required to do so
	private int xSpeed = 5;

	// making a rectangle around the player for collision detection
	Rectangle bounds = new Rectangle();

	// variables responsible for changing the x and y co-ordinates (respectively)
	// of the player when required
	protected float xMove, yMove;

	// boolean variable to check if the player has collided with a block
	public static boolean collided = false;

	// boolean variable to check if the player wants to restart the game
	public static boolean restart = false;

	// variable that holds the score of the player
	public static int score;

	// constructor
	public User(Handler handler, float x, float y, int width, int height) {
		// setting the default values for some of the above variables
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.handler = handler;

		xMove = 0;
		yMove = 0;

		bounds = new Rectangle((int) x, (int) y, width, height);

	}

	// this is the tick method, called repeatedly to implement the logic
	public void tick() {
		// calling the move method
		move();
		// calling the getInput method
		getInput();
		// telling the gameCamera from the GameCamera class to center on the player
		handler.getGameCamera().centerOnEntity(this);

		// this increment is responsible for repeatedly and smoothly moving the player
		// the if statement is used to check the player has collided, dont want to move
		// the player if true
		if (collided == false) {
			x += xSpeed;
		}
		// calling the reset method
		reset();
		// calling the restart method
		restart();

		// incrementing the score for the user
		if (!collided) {
			score += 1;
		}
		// resetting the score
		if (x == 10 && y == 450) {
			score = 0;
		}

	}

	// method used to render everything related to the player
	public void render(Graphics g) {
		// drawing the player
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);

		// changing colour to white for score
		g.setColor(Color.white);

		// calculating score
		int b = score / 3;

		// converting b to string because rendering is required
		String a = String.valueOf(b);
		// rendering the score
		g.drawString(a, 100, 100);

		// Game Over Screen, rendered if player collides wit a block
		if (collided) {
			// setting background to black
			g.setColor(Color.black);
			g.fillRect(0, 0, 700, 650);

			// rendering the game over image
			g.drawImage(Assets.gameOver, 0, 0, 700, 650, null);

			// rendering a string of characters to tell the user how to proceed from the
			// game over screen
			g.setColor(Color.WHITE);
			g.drawString("Press R to Restart or press E to return to main menu", 200, 580);

			// displaying ther user's score
			String yourScore = "Your Score:";
			g.setFont(new Font("serif", Font.BOLD, 50));
			g.drawString(yourScore, 200, 85);
			g.drawString(a, 460, 90);

		}

	}

	// method responsible for moving the character up and down
	private void getInput() {

		// setting the move variables to 0. The reset is required because the character
		// to stop moving once key is released
		yMove = 0;
		xMove = 0;

		// checking if up arrow key is pressed
		if (handler.getKeyManager().up) {
			// moving up
			yMove = -ySpeed;
		}
		// checking if down arrow key is pressed
		if (handler.getKeyManager().down) {
			// moving down
			yMove = ySpeed;
		}

	}

	// method responsible for moving the character with appropriate collision
	// detection
	public void move() {
		// only required to implement if the player hasn't already collided
		if (collided == false) {
			// calling method responsible for checking collision horizontally
			moveX();
			// calling method responsible for checking collision vertically
			moveY();
		}
	}

	// method responsible for checking collision horizontally
	public void moveX() {
		// Moving right
		if (xMove == 0) {

			// variable for the blocks
			int tx = (int) (x + xMove + bounds.width) / Tile.TILEWIDTH;

			// calling the collisionWithTile to check if collision occurred
			if (!collisionWithTile(tx, (int) (y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y) / Tile.TILEHEIGHT)) {
				// no collision
				x += xMove;
			} else {
				// collision happens here

				// changing collided variable to true
				collided = true;
			}
		}

	}

	// method responsible for checking collision horizontally
	public void moveY() {
		// Up
		if (yMove < 0) {

			// variable for the blocks
			int ty = (int) (y + yMove) / Tile.TILEHEIGHT;

			// calling the collisionWithTile to check if collision occurred
			if (!collisionWithTile((int) (x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.width) / Tile.TILEWIDTH, ty)) {
				// no collision
				y += yMove;

			} else {
				// collision happens here

				// changing collided variable to true
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT;
				collided = true;

			}
			// Down
		} else if (yMove > 0) {
			// variable for the blocks
			int ty = (int) (y + yMove + bounds.height) / Tile.TILEHEIGHT;

			// calling the collisionWithTile to check if collision occured
			if (!collisionWithTile((int) (x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + +bounds.width) / Tile.TILEWIDTH, ty)) {
				// no collision
				y += yMove;

			} else {
				// collision happens here

				// changing collided variable to true
				y = ty * Tile.TILEHEIGHT - bounds.height - 1;
				collided = true;

			}

		}
	}

	// checking to restart the level with higher speeds if level finished
	protected boolean restartWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isReset();
	}

	// restarting the level with higher speeds if level finished
	public void reset() {
		if (xMove == 0) {// Moving right
			int tx = (int) (x + xMove + bounds.width) / Tile.TILEWIDTH;

			// if collision detected with the tiles to restart
			if (!restartWithTile(tx, (int) (y) / Tile.TILEHEIGHT)
					&& !restartWithTile(tx, (int) (y) / Tile.TILEHEIGHT)) {
				// no collision yet
				x += xMove;
			} else {
				// collision happens here

				// resetting player's position to default
				x = 10;

				// increasing the speed every time level finishes
				if (xSpeed < 9) {
					ySpeed += 1;
					xSpeed += 1;
				}
			}
		}
	}
	
	//method to check if a collision has occurred
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	//method that decides what the player wants to do from the game over screen
	public void restart() {
		
		//checking if player wants to restart
		if (collided) {
			if (handler.getKeyManager().restart) {
				
				//setting variables to default values to run the game again
				x = 10;
				y = 450;

				xSpeed = 5;
				ySpeed = 7;

				collided = false;

			}
			
			//checking if players want to return to the main menu
			if (handler.getKeyManager().returnToMain) {
				
				//switching game state the the main menu
				State.setCurrentState(Game.allStates[0]);
				
				//setting default variables for the next time the player wants to play the game
				x = 10;
				y = 450;
				xSpeed = 5;
				ySpeed = 7;

				collided = false;
			}

		}

	}
	
	//gets the X co-ordinate of the player
	public float getX() {
		return x;
	}
	//gets the Y co-ordinate of the player
	public float getY() {
		return y;
	}
	
	//gets the width of the player
	public int getWidth() {
		return width;
	}

	//gets the height of the player
	public int getHeight() {
		return height;
	}

}

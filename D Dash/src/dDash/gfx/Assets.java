/*
 * By: Dhairya Khara
 * This class has all the images required for D-Dash. All other classes need to go 
 * through this class to access a image.
 */
package dDash.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	// all the image variables required for D-Dash
	public static BufferedImage player, block, triangleUp, triangleDown, blank, diamondBox, background, pointedTile,
			gameOver, pointedStar, restartBlock, menuScreen, helpScreen;

	// the default int and height of the tiles during Game play
	private static final int width = 40;
	private static final int height = 40;

	// Method to access the images
	public static void init() {
		// making a sprite shhet object. Loading it from the load image method from the
		// ImageLoader class
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Sprite_Sheet_Dash_40.png"));
		
		//all the images Cropped. Cropping done through the crop method in SpriteSheet class
		player = sheet.crop(0, 0, width, height);
		block = sheet.crop(width, 0, width, height);
		triangleUp = sheet.crop(width * 2, 0, width, height);
		triangleDown = sheet.crop(width * 3, 0, width, height);
		blank = sheet.crop(width * 4, 0, width, height);
		diamondBox = sheet.crop(width * 5, 0, width, height);
		pointedTile = sheet.crop(width * 6, 0, width, height);
		pointedStar = sheet.crop(width * 7, 0, width, height);
		restartBlock = sheet.crop(width * 8, 0, width, height);
		
		//image for the menu screen
		menuScreen = ImageLoader.loadImage("/textures/menuScreen.jpg");
		//background of the game
		background = ImageLoader.loadImage("/textures/background1.png");
		//game over screen
		gameOver = ImageLoader.loadImage("/textures/gameOver.jpg");
		//image for the help screen
		helpScreen = ImageLoader.loadImage("/textures/Help Screen.jpg");
	}
}

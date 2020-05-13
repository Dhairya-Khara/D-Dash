/*
 * By: Dhairya Khara
 * This class contains the crop method which can be called by any class to crop a image.
 * The main image cropped by this method is the SpriteSheet image
 */
package dDash.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}

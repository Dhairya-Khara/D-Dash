/*
 * By: Dhairya Khara
 * This class is responsible for creating the JFrame(the window) and the canvas (to put stuff in)
 * for the game of D-Dash
 */
package dDash.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	//jframe and canvas objets
	private static JFrame frame;
	private static Canvas canvas;

	//variables that hold information about the jframe, the title, width and height
	private String title;
	private int width, height;

	//constructor to set the default values
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		//running the createDisplay() method in the constructor because the method is requierd
		//to run whenever an object from this class is created
		createDisplay();
	}

	//method used to make the main menu
	private void createDisplay() {
		//making the frame object
		frame = new JFrame("D Dash");
		//specifying the width and height of the window
		frame.setSize(width, height);
		//telling the jframe to close the program whenever one exits from it
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//don't want the user to resize the jframe
		frame.setResizable(false);
		//need the jframe to render in the middle of the screen
		frame.setLocationRelativeTo(null);
		//telling the jframe to be visible
		frame.setVisible(true);

		//making the canvas object
		canvas = new Canvas();
		//making the canvas so that it adjusts the resolution on its own on differenct screens
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		//telling the canvas to focus on the key inputs (whenever applicable)
		canvas.setFocusable(false);
		//adding the canvas to the jframe
		frame.add(canvas);
		//telling the jframe to adjust itself according to the adjusted canvas
		frame.pack();
		
		

	}

	//gets the canvas object
	public Canvas getCanvas() {
		return canvas;
	}
	//gets the jframe object
	public JFrame getFrame() {
		return frame;
	}



}

/*
 * By:Dhairya Khara
 * This class is used to load data from a text file. In addition, the data of type String can
 * be converted of type Integer from this class. This class is primarily is used to generate 
 * the world which is a text file.
 */
package  dDash.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

	//Method to load file 
	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line+"\n");
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	//method to convent the data type of string to type Integer
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}
}

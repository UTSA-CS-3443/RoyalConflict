/*
 * The Credits class represents the credits for the game.
 * This has a method that loads the credits from a file.
 * @author Team rEach4help
 * UTSA CS 3443 - Team Project
 * Fall 2021
 */
package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Credits {

	public Credits() {
	}
	/*loadCredits() loads text from a file, to be used on the rules page
	 * @param String fileName
	 * @return String
	 */
	public static String loadCredits(String fileName) {
		File file = new File(fileName);
		Scanner scan;
		String s = "";
		try {
			scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String line = scan.nextLine(); 
				s += line + "\n";
		}
		scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
}
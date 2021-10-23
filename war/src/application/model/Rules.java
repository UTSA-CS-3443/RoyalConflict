/*
 * The Rules class represents the rules of the game.
 * This has a method that loads the game rules from a file.
 * @author Team rEach4help
 * UTSA CS 3443 - Team Project
 * Fall 2021
 */
package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rules {

	public Rules() {
	}
	/*loadRules() loads text from a file, to be used on the rules page
	 * @param String fileName
	 * @return String
	 */
	public static String loadRules(String fileName) {
		File file = new File(fileName);
		Scanner scan;
		String s = "";
		try {
			scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] tokens = line.split("\\.");
			for(int i = 0; i < tokens.length; i++) 
				s += tokens[i] + ".\n";
		}
		scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
}

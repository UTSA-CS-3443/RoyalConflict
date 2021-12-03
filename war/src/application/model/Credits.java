/**
 * The Credits class represents the credits for the game.
 * This has a method that loads the credits from a file.
 * 
 * @author Team rEach4help UTSA CS 3443 - Team Project Fall 2021
 * @author Kyle Anderson
 * @author Allison Clay
 * @author Alayna Richerson
 * @author John Weaver
 */
package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Credits {

	public Credits() {
	}

	/**
	 * METHOD:loadCredits() Loads text from a file, to be used on the rules
	 * page.
	 * 
	 * @param fileName
	 *     A file is passed in as a String called fileName.
	 * 
	 * @return s Returns a string called s that is the read in file.
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
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
}

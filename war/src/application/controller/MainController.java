/**
 * The MainController class controls the Menu screen.
 * There are buttons that lead to other scenes of the program.
 * 
 * @author Team rEach4help UTSA CS 3443 - Team Project Fall 2021
 * @author Kyle Anderson
 * @author Allison Clay
 * @author Alayna Richerson
 * @author John Weaver
 */
package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class MainController implements EventHandler<Event>, Initializable {
	@FXML
	Button rulesButton;
	@FXML
	Button playButton;
	@FXML
	Button creditsButton;

	/**
	 * handle() A placeholder for the javaFX EventHandler interface.
	 * 
	 * @param event
	 *     One of the fxml buttons was clicked.
	 */
	@Override
	public void handle(Event event) {
		/** Auto-generated method stub. */
	}

	/**
	 * initialize() Sets the credits label with the team members names.
	 * 
	 * @param location
	 *     ResourceBundle that was given to the FXMLLoader.
	 * @param resources
	 *     URL location of the FXML file given to the FXMLLoader.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/** Auto-generated method stub. */
	}

	/**
	 * METHOD:rules This launches the rules screen. Allows the user to press the
	 * rules button to go to the rules page of the application.
	 * 
	 * @param event
	 *     The rules button was clicked.
	 */
	public void rules(ActionEvent event) {
		try {
			Parent root = FXMLLoader
					.load(getClass().getResource("../view/Rules.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.setTitle("Rules");
			Main.stage.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * METHOD: play This launches the play screen. Allows the user to press the
	 * play button to go to the play page of the application.
	 * 
	 * @param event
	 *     The play button was clicked.
	 */
	public void play(ActionEvent event) {
		try {
			Parent root = FXMLLoader
					.load(getClass().getResource("../view/Play.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.setTitle("Royal Conflict");
			Main.stage.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * METHOD:credits Launches the credits page. Allows the user to press the
	 * credits button to go to the credits page of the application.
	 * 
	 * @param event
	 *     The credits button was clicked.
	 */
	public void credits(ActionEvent event) {
		try {
			Parent root = FXMLLoader
					.load(getClass().getResource("../view/Credits.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.setTitle("Credits");
			Main.stage.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

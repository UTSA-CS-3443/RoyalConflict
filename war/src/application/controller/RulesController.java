/**
 * The RulesController class controls the page displaying the games's rules.
 * This class controls a button that leads back to the menu screen.
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
import application.model.Rules;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RulesController implements EventHandler<Event>, Initializable {

	@FXML
	Button menuButton;
	@FXML
	Label rulesLabel;

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
		String s = Rules.loadRules("data/royal_conflict_rules.txt");
		rulesLabel.setText(s);
	}

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
	 * METHOD: menu Launches the menu (front page) page.
	 * Allows the user to press the menu button to return to the main page of
	 * the application.
	 * 
	 * @param event
	 *     The menu button was clicked.
	 */
	public void menu(ActionEvent event) {
		try {
			Parent root = FXMLLoader
					.load(getClass().getResource("../view/Main.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.setTitle("Menu");
			Main.stage.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

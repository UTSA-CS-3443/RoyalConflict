/*
 * The RulesController class controls the page that displays the rules of the game.
 * This class controls a button that leads back to the menu screen.
 * @author Team rEach4help
 * UTSA CS 3443 - Team Project
 * Fall 2021
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String s = Rules.loadRules("data/royal_conflict_rules.txt");
		rulesLabel.setText(s);
	}
	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		
	}
	public void menu(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.setTitle("Menu");
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

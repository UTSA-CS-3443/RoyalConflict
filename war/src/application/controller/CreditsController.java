/*
 * The CreditsController class controls the credits screen. There is a button leading to
 * the menu screen.
 * @author Team rEach4help UTSA CS 3443 - Team Project Fall 2021
 */
package application.controller ;

import java.net.URL ;
import java.util.ResourceBundle ;
import application.Main ;
import application.model.Credits ;
import javafx.event.ActionEvent ;
import javafx.event.Event ;
import javafx.event.EventHandler ;
import javafx.fxml.FXML ;
import javafx.fxml.FXMLLoader ;
import javafx.fxml.Initializable ;
import javafx.scene.Parent ;
import javafx.scene.Scene ;
import javafx.scene.control.Button ;
import javafx.scene.control.Label ;


public class CreditsController implements EventHandler < Event > , Initializable {
	@FXML Button menuButton ;
	@FXML Label creditsLabel ;
	
	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources ;
	
	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location ;
	
	@Override
	public void handle( Event event ) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void initialize( URL location , ResourceBundle resources ) {
		String s = Credits.loadCredits( "data/team_members.txt" ) ;
		creditsLabel.setText( s ) ;
		
		assert menuButton != null
					: "fx:id=\"menuButton\" was not injected: check your FXML file 'Credits.fxml'." ;
		assert creditsLabel != null
					: "fx:id=\"creditsLabel\" was not injected: check your FXML file 'Credits.fxml'." ;
	}
	
	public void menu( ActionEvent event ) {
		try {
			Parent root = FXMLLoader
						.load( getClass( ).getResource( "../view/Main.fxml" ) ) ;
			Main.stage.setScene( new Scene( root , 800 , 800 ) ) ;
			Main.stage.setTitle( "Menu" ) ;
			Main.stage.show( ) ;
		}
		catch ( Exception e ) {
			e.printStackTrace( ) ;
		}
	}
}

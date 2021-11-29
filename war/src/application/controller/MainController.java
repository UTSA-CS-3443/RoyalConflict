/*
 * The MainController class controls the Menu screen. There are buttons that lead to other
 * scenes of the program.
 * @author Team rEach4help UTSA CS 3443 - Team Project Fall 2021
 */
package application.controller ;

import java.net.URL ;
import java.util.ResourceBundle ;
import application.Main ;
import javafx.event.ActionEvent ;
import javafx.event.Event ;
import javafx.event.EventHandler ;
import javafx.fxml.FXML ;
import javafx.fxml.FXMLLoader ;
import javafx.fxml.Initializable ;
import javafx.scene.Parent ;
import javafx.scene.Scene ;
import javafx.scene.control.Button ;


public class MainController implements EventHandler < Event > , Initializable {
	@FXML Button rulesButton , playButton , creditsButton ;
	@Override
	public void handle( Event event ) {
		// TODO Auto-generated method stub
	}
	@Override
	public void initialize( URL location , ResourceBundle resources ) {
		// TODO Auto-generated method stub
		
	}
	public void rules( ActionEvent event ) {
		try {
			Parent root = FXMLLoader
						.load( getClass( ).getResource( "../view/Rules.fxml" ) ) ;
			Main.stage.setScene( new Scene( root , 800 , 800 ) ) ;
			Main.stage.setTitle( "Rules" ) ;
			Main.stage.show( ) ;
		}
		catch ( Exception e ) {
			e.printStackTrace( ) ;
		}
	}
	public void play( ActionEvent event ) {
		try {
			Parent root = FXMLLoader
						.load( getClass( ).getResource( "../view/Play.fxml" ) ) ;
			Main.stage.setScene( new Scene( root , 800 , 800 ) ) ;
			Main.stage.setTitle( "Royal Conflict" ) ;
			Main.stage.show( ) ;
		}
		catch ( Exception e ) {
			e.printStackTrace( ) ;
		}
	}
	public void credits( ActionEvent event ) {
		try {
			Parent root = FXMLLoader
						.load( getClass( ).getResource( "../view/Credits.fxml" ) ) ;
			Main.stage.setScene( new Scene( root , 800 , 800 ) ) ;
			Main.stage.setTitle( "Credits" ) ;
			Main.stage.show( ) ;
		}
		catch ( Exception e ) {
			e.printStackTrace( ) ;
		}
	}
}

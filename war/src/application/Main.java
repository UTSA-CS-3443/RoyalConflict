/**
 * The Main class uses FXML to set up the stage and scene so the project can
 * launch GUI components and run.
 * 
 * @author Team rEach4help UTSA CS 3443 - Team Project Fall 2021
 * @author Kyle Anderson
 * @author Allison Clay
 * @author Alayna Richerson
 * @author John Weaver
 */
package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static Stage stage;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader
					.load(getClass().getResource("view/Main.fxml"));
			primaryStage.setScene(new Scene(root, 800, 800));
			primaryStage.setTitle("Menu");
			primaryStage.show();
			stage = primaryStage;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}

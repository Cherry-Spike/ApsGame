package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import view.ViewManager;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ViewManager vmanager = new ViewManager();
			primaryStage = vmanager.getMainStage();
			primaryStage.setTitle("City Last Light!");			
		  		    
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

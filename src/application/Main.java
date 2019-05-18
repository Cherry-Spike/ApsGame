package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewManager;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ViewManager vmanager = new ViewManager();
			primaryStage = vmanager.getMainStage();
			primaryStage.setTitle("City Last Light!");
			primaryStage.setResizable(false);  
			primaryStage.show();    
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

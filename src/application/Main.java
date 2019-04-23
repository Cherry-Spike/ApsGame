package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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
			ViewManager manager = new ViewManager();
			primaryStage = manager.getMainStage();
			primaryStage.setTitle("City Last Light!");
			
		    VBox vb = new VBox();
		    vb.setPadding(new Insets(10, 50, 50, 50));
		    vb.setSpacing(10);

		    // Title
		    Label lbl = new Label("City Last Light");
		    lbl.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
		    vb.getChildren().add(lbl);

		    // Buttons
		    Button btn1 = new Button();
		    btn1.setText(""
		    		+ "Iniciar");
		    vb.getChildren().add(btn1);

		    Button btn2 = new Button();
		    btn2.setText("Créditos");
		    vb.getChildren().add(btn2);
		    
		    VBox.setMargin(vb.getChildren().get(1),new Insets(0,50,0,50));
		    VBox.setMargin(vb.getChildren().get(2),new Insets(0,50,0,45));
		    
		 // Adding VBox to the scene
		    Scene scene = new Scene(vb);
		    
		    manager.SetNewScene(scene);
		  		    
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

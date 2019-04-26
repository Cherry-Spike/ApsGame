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
			
		    /*VBox vb = new VBox();
		    vb.setPadding(new Insets(200, 250, 0, 200));
		    vb.setSpacing(10);

		    // Title
		    Label lbl = new Label("City Last Light");
		    lbl.setFont(Font.font("Amble CN", FontWeight.BOLD, 50));
		    vb.getChildren().add(lbl);

		    // Buttons
		    Button btn1 = new Button();
		    btn1.setText("Iniciar");
		    btn1.setPrefWidth(400);
		    btn1.setFont(Font.font("Amble CN", 20));
		    vb.getChildren().add(btn1);

		    Button btn2 = new Button();
		    btn2.setText("Creditos");
		    btn2.setFont(Font.font("Amble CN", 20));
		    btn2.setPrefWidth(400);
		    vb.getChildren().add(btn2);
		    
		    VBox.setMargin(vb.getChildren().get(1),new Insets(0,50,0,50));
		    VBox.setMargin(vb.getChildren().get(2),new Insets(0,50,0,50));
		    
		 // Adding VBox to the scene
		    
		    vmanager.SetNewScene(vb);*/
		  		    
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

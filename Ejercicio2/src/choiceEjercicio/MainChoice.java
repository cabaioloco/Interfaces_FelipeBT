package choiceEjercicio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainChoice extends Application {
	
	private VBox rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainChoice.class.getResource("ChoiceLayout.fxml"));
			rootLayout = (VBox) loader.load();			
			Scene scene = new Scene(rootLayout);
			
			
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejemplo sobre filtros");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package pagination;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainLayout extends Application {
	
	private AnchorPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainLayout.class.getResource("paginationLayout.fxml"));
			rootLayout = (AnchorPane) loader.load();			
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

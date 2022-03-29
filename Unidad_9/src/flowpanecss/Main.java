package flowpanecss;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Main extends Application {
	private FlowPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el dise�o del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("FlowPaneLayout.fxml"));
			rootLayout = (FlowPane) loader.load();

			// Mostramos la escena del FlowPane de la variable rootLayot
			Scene scene = new Scene(rootLayout);
			scene.getStylesheets().add("flowpanecss/application.css");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

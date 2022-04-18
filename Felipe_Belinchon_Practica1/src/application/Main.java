package application;
	


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
	private BorderPane rootLayout;
	@Override
	public void start(Stage primaryStage) {
	try {
	// Carga el dise�o del archivo FXML en la variable rootLayout
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(Main.class.getResource("RootLayout.fxml"));
	rootLayout = (BorderPane) loader.load();
	
	MenuController menuController = loader.getController();
	menuController.setRootLayout(rootLayout);
	
	
	
	// Mostramos la escena del BorderPane de la variable rootLayot
	Scene scene = new Scene(rootLayout);
	primaryStage.setScene(scene);
	primaryStage.setTitle("Filo Entertainment App");
	primaryStage.getIcons().add(new Image("file:src/img/fondo.jpg"));
	scene.getStylesheets().add("/css/application.css");
	primaryStage.show();
	

	
	} catch(Exception e) {
	e.printStackTrace();
	}

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

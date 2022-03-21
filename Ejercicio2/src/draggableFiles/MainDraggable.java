package draggableFiles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainDraggable extends Application {

	private AnchorPane root;

	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainDraggable.class.getResource("draggLayout.fxml"));
			root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);


			Text source = (Text) scene.lookup("#source");
			Text target = (Text) scene.lookup("#destination");
			
			source.setOnDragDetected((event)->{
				Dragboard db = source.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putString(source.getText());
				db.setContent(content);
			});
			
			target.setOnDragOver((event) -> {
				if (event.getDragboard().hasString()) {
				event.acceptTransferModes(TransferMode.MOVE);
				}
				});
			target.setOnDragDropped((event) -> {
				Dragboard db = event.getDragboard();
				if (db.hasString()) {
				target.setText(db.getString());
				source.setText("Operacion drag Terminada");
				}
				});
			
		
			
			

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


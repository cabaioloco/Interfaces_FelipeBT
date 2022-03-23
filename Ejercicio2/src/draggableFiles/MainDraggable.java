package draggableFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
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
			ImageView imagen = (ImageView) scene.lookup("#imagen");
			
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
				imagen.setOnDragOver((event)->{
					if(event.getDragboard().hasFiles()) {
						event.acceptTransferModes(TransferMode.ANY);
					}

				});
				imagen.setOnDragDropped((event)->{
					List<File> files = event.getDragboard().getFiles();
					try {
						Image img = new Image(new FileInputStream(files.get(0)));
						imagen.setImage(img);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
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


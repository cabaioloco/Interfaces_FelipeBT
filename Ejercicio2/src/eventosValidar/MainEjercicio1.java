package eventosValidar;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainEjercicio1 extends Application {
	
	private VBox rootLayout;

	@Override
	public void start(Stage primaryStage) {
		//EJercicio 1
		rootLayout = new VBox(10);
		rootLayout.setPadding(new Insets(10));
		HBox vb = new HBox(10);
		Label labe = new Label("Label:");
		TextField tf = new TextField();
		Button bt = new Button("Mostrar Dialogo");
		bt.setAlignment(Pos.CENTER);
		
		vb.getChildren().addAll(labe,tf);
		rootLayout.getChildren().addAll(vb,bt);
		
		
		
		TextInputDialog textDialog = new TextInputDialog();
		textDialog.setTitle("Ejemplo de diálogo");
		textDialog.setHeaderText("Diálogo para introducir un texto");
		//Ejercicio2
		
		textDialog.getDialogPane().addEventFilter(KeyEvent.KEY_TYPED, e ->{
			if(Character.isLowerCase(e.getCharacter().charAt(0))) {
				e.consume();
			}
		});
		bt.setOnAction(e -> {
			textDialog.showAndWait().ifPresent(response -> {
				String prueba = response;
				String correcto = prueba.toUpperCase();
				if(correcto==prueba) {
					tf.setText(response);
				}
				else {
					
				}
				});
	
		});
		
		//Ejercicio 2
		textDialog.getDialogPane().addEventHandler(KeyEvent.KEY_PRESSED, e ->{
			if(e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.ESCAPE) {
				e.consume();
			}
		});
		
		tf.addEventHandler(MouseEvent.MOUSE_ENTERED,e -> {
			tf.setCursor(Cursor.HAND);
		});
		
		textDialog.setOnCloseRequest((event) -> {
    		tf.requestFocus();
            
        });
    	
		

		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ejercicio 1");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

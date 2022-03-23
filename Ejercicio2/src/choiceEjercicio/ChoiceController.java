package choiceEjercicio;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.FocusModel;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class ChoiceController {

	@FXML
	private ListView<String> choice;

	@FXML
	private Button boton;

	@FXML
	void initialize() {
		choice.getItems().addAll("opcion 1", "opcion 2", "opcion 3", "opcion 4", "opcion 5", "opcion 6", "opcion 7",
				"opcion 8", "opcion 9", "opcion 10");
		choice.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		choice.getSelectionModel().getSelectedItems().addListener(new InvalidationListener() {	
			@Override
			public void invalidated(Observable arg0) {
			boton.setDisable(false);	
			}
		});
		choice.addEventHandler(MouseEvent.MOUSE_EXITED, e ->{
			if(choice.getSelectionModel().getSelectedItem()==null) {
			Alert infoAlert = new Alert(AlertType.INFORMATION);
			infoAlert.setTitle("Aviso sobre listado");
			infoAlert.setHeaderText("Sin items Selecionados");
			infoAlert.setContentText("No se puede mostar un dialogo hasta que se seleccione un item");
			infoAlert.show();
			}
		});
		
		boton.setOnAction(e->{
			ObservableList<String> array = choice.getSelectionModel().getSelectedItems();
		
			ChoiceDialog<String> choiceDialog = new ChoiceDialog(array.get(0),array);
			
			choiceDialog.setTitle("Ejemplo de diálogo");
			choiceDialog.setHeaderText("Seleccione un valor...");
			choiceDialog.showAndWait().ifPresent(response->{
				int index = choice.getItems().indexOf(response);
				choice.getSelectionModel().clearAndSelect(index);
			});
			
		});
	}

	public ListView<String> getChoice() {
		return choice;
	}

	public void setChoice(ListView<String> choice) {
		this.choice = choice;
	}

	public Button getBoton() {
		return boton;
	}

	public void setBoton(Button boton) {
		this.boton = boton;
	}

}

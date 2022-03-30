package ch.makery.address.view;

import ch.makery.address.Main;
import ch.makery.address.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

	
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private Button edit;
    // Referencia a la aplicación principal
    private Main mainApp;
    
    /**
     * Método para inicializar el controlador que se llama cuando se carga el FXML
     */
    @FXML
    private void initialize() {
    	// Se inicializan las columnas firstName y lastName
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    	
    }

 
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        personTable.setItems(this.mainApp.getPersonData());
               
  
    }
  
    @FXML
    private void handleNewPerson(ActionEvent event) {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }       
    }   
    @FXML
    private void editHandleNewPerson(ActionEvent event) {
    		if(personTable.getSelectionModel().getSelectedItem()==null) {
    			Alert alert =  new Alert(AlertType.ERROR);
    			alert.setTitle("ERROR");
    			alert.setHeaderText("Ninguna persona selecionada");
    			alert.setContentText("Debes Seleccionar a una persona para editar");
    			alert.show();
    		}
    		else {
    			  Person tempPerson = personTable.getSelectionModel().getSelectedItem();
    			  
    			  boolean okClicked =  mainApp.showPersonEditDialog(tempPerson);
  		         
		        if (okClicked) {
		        	 int index = personTable.getSelectionModel().getSelectedIndex();
		            mainApp.getPersonData().get(index).setFirstName(tempPerson.getFirstName());
		            mainApp.getPersonData().get(index).setLastName(tempPerson.getLastName());;
		        } 
    		}    	
         
    }  
    
    @FXML
    private void deleteHandleNewPerson(ActionEvent event) {
    		if(personTable.getSelectionModel().getSelectedItem()==null) {
    			Alert alert =  new Alert(AlertType.ERROR);
    			alert.setTitle("ERROR");
    			alert.setHeaderText("Ninguna persona selecionada");
    			alert.setContentText("Debes Seleccionar a una persona para Borrar");
    			alert.show();
    		}
    		else {
    			Boolean si= false;
    			Alert confirm = new  Alert(AlertType.CONFIRMATION);
    			confirm.setTitle("Ejemplo de diálogo");
    			confirm.setHeaderText("Alert informativo");
    			confirm.setContentText("Esto es un ejemplo de diálogos en Java FX...");
    			 int index = personTable.getSelectionModel().getSelectedIndex();
    			 mainApp.getPersonData().remove(index);
    			 personTable.setItems(mainApp.getPersonData());
    			 
    			 
    		}    	
         
    }  
}
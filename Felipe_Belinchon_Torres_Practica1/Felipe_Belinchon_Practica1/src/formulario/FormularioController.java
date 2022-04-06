package formulario;

import javax.swing.ButtonGroup;

import application.MenuController;
import application.Persona;
import datos.DatosController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class FormularioController {
	
	  @FXML
	  private ChoiceBox<String> choice1;
	  
	   @FXML
	    private ToggleGroup genero;
	   
	   //-------------------------------------
	   @FXML
	    private TextField nombre;

	    @FXML
	    private TextField apellido;
	    
	    @FXML
	    private TextField sueldo;

	    @FXML
	    private Slider edad;

	    @FXML
	    private TextField email;
	    @FXML
	    private RadioButton masculino;
	    @FXML
	    private RadioButton femenino;
	    @FXML
	    private RadioButton otro;
	    
	    private String generoFinal;
	    
	    private MenuController main;
	    
	    @FXML
	    void initialize() {

	    	
	    	choice1.getItems().addAll("Ingles","Español", "Italiano","Chino","Otro");
	    	choice1.setValue("select a value...");


	    
	    					
	    }
	    public Boolean datosNoValidos() {
	    	String mensajeError="";
	    	if(nombre.getText()==null || nombre.getText().length()==0) {
	    		mensajeError = mensajeError+"El nombre no puede estar vacio \n";
	    		
	    	}
	    	if(apellido.getText()==null || apellido.getText().length()==0) {
	    		mensajeError = mensajeError+"El apellido no puede estar vacio \n";
	    		
	    	}
	    	if(email.getText()==null||email.getText().length()==0) {
	    		mensajeError = mensajeError+"El email no puede estar vacio \n";
	    	}
	    	if(sueldo.getText()==null||sueldo.getText().length()==0) {
	    		mensajeError = mensajeError+"El sueldo no puede estar vacio \n";
	    	}
	    	
	    	if(choice1.getSelectionModel().getSelectedItem()=="select a value..."){
	    		mensajeError =mensajeError+"Por favor escoja un lenguaje \n";
	    		
	    	}
	    	if(genero.getSelectedToggle() != null) {
	    		if(masculino.isSelected()==true) {
	    			generoFinal="Masculino";
	    		}
	    		if(femenino.isSelected()==true) {
	    			generoFinal="Femenino";
	    		}
	    		if(otro.isSelected()==true) {
	    			generoFinal="Otro";
	    			
	    		}
	    	}
	    	else {
	    		mensajeError=mensajeError+"porfavor escoga algun valor de genero \n";
	    	}
	    	
	    	
	    	
	    		
	    	 if (mensajeError.length() == 0) {
	             return true;
	         } else {

	     		Alert errorAlert = new Alert(AlertType.ERROR);
	         	
	     		errorAlert.setTitle("Hay campos incorrectos");
	     		errorAlert.setHeaderText("Por favor, rellena correctamente los campos");
	     		errorAlert.setContentText(mensajeError);
	     		
	     		errorAlert.showAndWait();
	             return false;
	         }
	    	
	    }
	    public void crearRegistro(ActionEvent e ) {
	    	Boolean valido=datosNoValidos();
	    	if(valido==true) {
	    		int edadVa=(int) this.edad.getValue();
	    		int sueldoVa =Integer.parseInt(this.sueldo.getText());
	    		Persona persona = new Persona(nombre.getText(),apellido.getText(),email.getText(),edadVa,generoFinal,choice1.getValue(),sueldoVa);;
	    		main.setPersona(persona);
	    		main.annadirPersona();
	    	}
	    }
	    public void resetearDatos() {
	    	nombre.setText("");
	    	apellido.setText("");
	    	email.setText("");
	    	choice1.setValue("select a value...");
	    	edad.setValue(0);
	    	if(masculino.isSelected()==true) {
    			masculino.setSelected(false);
    		}
    		if(femenino.isSelected()==true) {
    			femenino.setSelected(false);
    		}
    		if(otro.isSelected()==true) {
    			otro.setSelected(false);
    			
    		}
	    }

	    public void setMenuController(MenuController datos) {
	    	this.main=datos;
	    }
	    
	    
	  

}

package formulario;

import java.awt.Menu;

import javax.swing.ButtonGroup;

import application.MenuController;
import application.Persona;
import datos.DatosController;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

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
	    
	    //Junto las apitudes con la descripcion para que sea mas facil el transporte
	    //de informacion
	    private String descripcion;
	    @FXML
	    private CheckBox aser;
	    @FXML
	    private TextArea historia;
	    @FXML
	    private CheckBox actitud;
	    @FXML
	    private CheckBox lider;
	    @FXML
	    private CheckBox teamwork;
	    
	    private MenuController main;
	    
	    @FXML
	    private Button resetear;
	    @FXML
	    private Button enviar;
	    
	    @FXML
	    private VBox tuto;
	    
	    @FXML
	    void initialize() {

	    	
	    	choice1.getItems().addAll("Ingles","Español", "Italiano","Chino","Otro");
	    	choice1.setValue("select a value...");
	    	
	    	
	    	//filtro para que solo se puedan poner numeros
	    	sueldo.addEventFilter(KeyEvent.KEY_TYPED, e->{
	    		if(Character.isLowerCase(e.getCharacter().charAt(0)) || Character.isUpperCase(e.getCharacter().charAt(0)) ) {
	    			e.consume();
	    		}
	    	});
	    	
	    	//evento para redireccionar a la informacion relativa de esa pestaña
	    	tuto.addEventHandler(MouseEvent.MOUSE_CLICKED , e -> {
				main.RedireccionInfoForm();
				});
	    	tuto.addEventHandler(MouseEvent.MOUSE_ENTERED, e->{
				tuto.setCursor(Cursor.HAND);
			});
	    	enviar.addEventHandler(MouseEvent.MOUSE_ENTERED, e->{
				enviar.setCursor(Cursor.HAND);
			});
	    	resetear.addEventHandler(MouseEvent.MOUSE_ENTERED, e->{
				resetear.setCursor(Cursor.HAND);
			});
	    	
	    	//pequeña animacion del cursos cuando interactuamos con el slider
	    	//animacion la mano agarra el slider se cierra la mano,el cursor entrea o deja de ser presionado es una mano abierta
	    	edad.addEventHandler(MouseEvent.MOUSE_PRESSED, e->{
				edad.setCursor(Cursor.CLOSED_HAND);
			});
	    	edad.addEventFilter(MouseEvent.MOUSE_RELEASED, e->{
	    		edad.setCursor(Cursor.OPEN_HAND);
	    	});
	    	edad.addEventFilter(MouseEvent.MOUSE_ENTERED, e->{
	    		edad.setCursor(Cursor.OPEN_HAND);
	    	});
	    	
	    	
	    	
	    	
	    
	    					
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
	    		main.setPersona(crearPersona());
	    		main.annadirPersona();	    		
	    		main.RedireccionDatos();
	    	}
	    }
	   
	    public String elaborarDescripcion() {
	    	
	    if(historia.getText()=="" && !teamwork.isSelected()&& !lider.isSelected() && !actitud.isSelected() && !aser.isSelected()) {
	    	return "no tiene descripcion";
	    }
	    else {
	    	String descri="";
	    	if(historia.getText()=="") {
	    		descri= descri+"Aptitudes: \n";
	    	}
	    	else {
	    		descri=descri+"pequeña descricpion: \n "+historia.getText();	
	    		descri=descri+"\n Aptitudes: \n";

	    	}
	    	if(teamwork.isSelected()) {
	    		descri= descri+"Trabajo en equipo \n";
	    		
	    	}	
	    	 if(lider.isSelected()) {
	    		descri= descri+"Lider \n";
	    	}
	    	 if(actitud.isSelected()) {
	    		descri=descri+ "Actitud \n";
	    	}
	    	 if(aser.isSelected()) {
	    		descri= descri+"Asertivo \n";
	    	}
	    	return descri;
	    }
	    }
	    public Persona crearPersona() {
	    		int edadVa=(int) this.edad.getValue();
	    		int sueldoVa =Integer.parseInt(this.sueldo.getText());		    			    		
	    		Persona persona = new Persona(nombre.getText(),apellido.getText(),email.getText(),edadVa,generoFinal,choice1.getValue(),sueldoVa,elaborarDescripcion());;
	    		return persona;
	    }
	    

	    public void setMenuController(MenuController datos) {
	    	this.main=datos;
	    }
	    public void resetearDatos() {
	    	nombre.setText("");
	    	apellido.setText("");
	    	email.setText("");
	    	choice1.setValue("select a value...");
	    	edad.setValue(0);
	    	sueldo.setText("");
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
	    
	    //metodo que sirve para establecer los valores al editar
	    public void datosPersona() {
	    	
	    	nombre.setText(main.getPersona().getFirstName());
	    	apellido.setText(main.getPersona().getLastName());
	    	email.setText(main.getPersona().getEmail());
	    	choice1.setValue(main.getPersona().getLenguaje());
	    	edad.setValue(main.getPersona().getAge());
	    	sueldo.setText(main.getPersona().getSueldo().toString());
	    	if(main.getPersona().getGenero().equals("Masculino")) {
    			masculino.setSelected(true);
    		}
    		if(main.getPersona().getGenero().equals("Femenino")) {
    			femenino.setSelected(true);
    		}
    		if(main.getPersona().getGenero().equals("Otro")) {
    			otro.setSelected(true);
    			
    		}
	    }
	    

}

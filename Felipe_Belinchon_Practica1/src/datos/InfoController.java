package datos;

import application.Persona;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InfoController {
	
	//labels de la ventan de dialogo de mostrar
	   @FXML
	    private Label nombre;

	    @FXML
	    private Label apellido;
	    
	    @FXML
	    private Label sueldo;

	    @FXML
	    private Label edad;
	    @FXML
	    private Label idioma;
	    @FXML
	    private Label email;
	  
	    @FXML
	    private Label descripcion;
	    @FXML
	    private Label genero;
	    
	    private Persona persona;
	//-------------------------------------------------------------
	    
	    public void info() {	    	
	  	  nombre.setText(persona.getFirstName());
	  		apellido.setText(persona.getLastName());
	  		edad.setText(persona.getAge().toString());
	  		idioma.setText(persona.getLenguaje());
	  		sueldo.setText(persona.getSueldo().toString());
	  		email.setText(persona.getEmail());
	  		descripcion.setText(persona.getDescripcion());
	  		genero.setText(persona.getGenero());
	    } 
	    
	    
	    public void setPersona(Persona persona) {
	    	this.persona=persona;
	    }
}

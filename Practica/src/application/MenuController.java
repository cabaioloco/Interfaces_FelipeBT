package application;

import java.io.IOException;
import java.text.Normalizer.Form;

import datos.DatosController;
import formulario.FormularioController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MenuController {
	
	private BorderPane rootLayout;
	
	private Persona person;
	
	private  static ObservableList<Persona> data = FXCollections.observableArrayList(
    	    new Persona("Felipe", "Belinchon", "Felipe@example.com", 20,"Masculino","Español",3000,"hey"));
	
	  @FXML
	    private void initialize() {
	        
	    }
	    
	  @FXML
	    private void abrirInfoDatos(ActionEvent event) {    	
	    	try {
			
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MenuController.class.getResource("/informacion/DatosInfoLayout.fxml"));
				AnchorPane listadoControles = (AnchorPane) loader.load();

				
				rootLayout.setCenter(listadoControles);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	  @FXML
	    private void abrirInfoGeneral(ActionEvent event) {    	
	    	try {
			
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MenuController.class.getResource("/informacion/GeneralLayout.fxml"));
				AnchorPane listadoControles = (AnchorPane) loader.load();

				
				rootLayout.setCenter(listadoControles);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	  @FXML
	    private void abrirInfoForm(ActionEvent event) {    	
	    	try {
			
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MenuController.class.getResource("/informacion/FormInfoLayout.fxml"));
				AnchorPane listadoControles = (AnchorPane) loader.load();

				
				rootLayout.setCenter(listadoControles);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	 @FXML
	    private void abrirDatos(ActionEvent event) {    	
	    	try {
			
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MenuController.class.getResource("/datos/DatosLayout.fxml"));
				AnchorPane listadoControles = (AnchorPane) loader.load();
				DatosController datosController = loader.getController();
				
				datosController.setMenu(this);
				
				datosController.setData(data);
				datosController.actualizarTabla();
			
				rootLayout.setCenter(listadoControles);
				
			
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	 
	 @FXML
	    private void abrirFormulario(ActionEvent event) {    	
	    	try {
			
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MenuController.class.getResource("/formulario/FormularioLayout.fxml"));
				GridPane listadoControles = (GridPane) loader.load();

				
				rootLayout.setCenter(listadoControles);
				FormularioController formController = loader.getController();
				formController.setMenuController(this);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	 @FXML
	 private void cerrarInformacion(ActionEvent event) {    	
	    	rootLayout.setCenter(null);	
	    }
	 public BorderPane getRootLayout() {
			return rootLayout;
		}

		public void setRootLayout(BorderPane rootLayout) {
			this.rootLayout = rootLayout;
		}	
		
		public void setPersona(Persona persona) {
			this.person=persona;
		}
		public Persona getPersona() {
			return this.person;
		}
		public void annadirPersona() {
			data.add(person);
		}		
		
		public void RedireccionFormulario() {
			//esto sirve para redireccionar al formulario
			try {
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MenuController.class.getResource("/formulario/FormularioLayout.fxml"));
				GridPane listadoControles = (GridPane) loader.load();

				
				rootLayout.setCenter(listadoControles);
				FormularioController formController = loader.getController();
				formController.setMenuController(this);
				formController.datosPersona();
				
							
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void RedireccionDatos() {
			try {
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MenuController.class.getResource("/datos/DatosLayout.fxml"));
				AnchorPane listadoControles = (AnchorPane) loader.load();
				DatosController datosController = loader.getController();
				
				datosController.setMenu(this);
				
				datosController.setData(data);
				datosController.actualizarTabla();
			
				rootLayout.setCenter(listadoControles);
				
			
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	    public void RedireccionInfoDatos() {    	
	    	try {
			
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MenuController.class.getResource("/informacion/DatosInfoLayout.fxml"));
				AnchorPane listadoControles = (AnchorPane) loader.load();

				
				rootLayout.setCenter(listadoControles);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    public void RedireccionInfoForm() {    	
	    	try {
			
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MenuController.class.getResource("/informacion/FormInfoLayout.fxml"));
				AnchorPane listadoControles = (AnchorPane) loader.load();

				
				rootLayout.setCenter(listadoControles);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		
		
	
	    
}

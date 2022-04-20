package informacion;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class DatosInfoController implements Initializable {

		
		@FXML Pagination pag;
		
		@FXML ProgressBar bar ;
		
		public void initialize(URL url, ResourceBundle rb) {
	       
	        pag.setMaxPageIndicatorCount(7);
	        pag.setPageCount(4);
	        pag.setStyle("-fx-border-color:skyblue;");

	        pag.setPageFactory(new Callback<Integer, Node>() {
	            @Override
	            public Node call(Integer pageIndex) {
	            	double x =(pageIndex+1)*0.25;
	            	//comprobacion por consola que da el resultado que tiene que dar
	            	System.out.print(pageIndex);
	            	System.out.print("/4=");
	            	System.out.println();
	            	System.out.print(x);
	            	System.out.println();
	            	bar.setProgress(x);
	            	
	            	VBox box = new VBox();
			        box.setStyle("-fx-background-color:skyblue");
	            		if(pageIndex==0) {
	            			Label label = new Label("Tabla \n \n"
	            					+ "Esta pestaña cuenta con una tabla en la que podremos visualizar los datos de los empleados,"
	            					+ "El nombre,el apellido,su sueldo,su edad,el idioma nativo,su genero y su email "
	            					+ "Ademas tendremos un boton llamado 'mostrar informacion' que nos permitira visualizar  infromacion mas especifica "
	            					+ " como una pequeña descripcion en la que se incluyen las aptitudes del  empleado.");
	            			label.setWrapText(true);
	            			box.getChildren().add(label);
	            		}
	            		if(pageIndex==2) {
	            			Label label = new Label("\n Abajo a la izquierda contaremos con cuadrado en vista de arbol en el que veremos las tareas,"
	            					+ "los contactos y los bojetivos.Ademas podremos crear objetivos,contactos o tareas con los "
	            					+ " botones situados justo debajo del rectangulo. ");
	            			label.setWrapText(true);
	            			box.getChildren().add(label);
	            		}
	            		if(pageIndex==1) {
	            			Label label = new Label("\n Tambien podremos editar o borrar  de manera combencional los empleados con los botones 'editar' y  'borrar'"
	            					+ "pero primero deberemos seleccionar u empleado en la tabla. Ademas tendremos una funcionalida  bastante  practica "
	            					+ " la que podremos seleccionar un empleado de la tabla y abajo se mostrara que empleado se ha  seleccionado "
	            					+ " y si arrastarmos y soltamos en la papelera se borrara el empleado , se nos mostrara un mensaje de que  el empleado se ha borrado con exito. ");
	            			label.setWrapText(true);
	            			box.getChildren().add(label);
	            		}
	            		if(pageIndex==3) {
	            			Label label = new Label(" \n En caso de que en algun momento se nos olvide cualquiera de la informacion de la pagina constaremos  "
	            					+ "con un cuadrado con interrogacion para redireccionarnos a esta pagina.");
	            			label.setWrapText(true);
	            			box.getChildren().add(label);
	            		}
	            	return box;
	            }
	        });
	    } 
		
		 
	}

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

public class FormInfoController implements Initializable{

	
	@FXML Pagination pag;
	
	@FXML ProgressBar bar ;
	
	public void initialize(URL url, ResourceBundle rb) {
       
        pag.setMaxPageIndicatorCount(7);
        pag.setPageCount(2);
        pag.setStyle("-fx-border-color:skyblue;");
        
        pag.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
            	double x =(pageIndex+1)*0.5;
            	
            	bar.setProgress(x);
            	VBox box = new VBox();
		        box.setStyle("-fx-background-color:skyblue");
            		if(pageIndex==0) {
            			Label label = new Label("\nEsta pestaña tiene varias campos que se deben rellenar."
            					+ "Los campos precedidos de '*'  son campos obligatorios.\n Estos campos deberan ser rellenados de manera obligatoria."
            					+ "En caso de no ser rellenados nos saltara una alerta recordandonos que debemos rellenarlos.");
            			label.setWrapText(true);
            			box.getChildren().add(label);
            		}
            		if(pageIndex==1) {
            			Label label = new Label("\nEsta pestaña cuenta con dos botones situados en la parte inferior.'Resetear Datos' nos permitira reiniciar  el formulario poniendo todos los campos en blanco."
            					+ "'Enviar formulario' nos permitira enviar la informacion  a la pestaña 'Datos' y ademas nos redireccionara  a esa misma pestaña."
            					+ "En caso de que en algun momento se nos olvide cualquiera de la informacion de la pagina constaremos  con un cuadrado con interrogacion para redireccionarnos a esta pagina");
            			label.setWrapText(true);
            			box.getChildren().add(label);
            		}
            	return box;
                
            }
        });
    } 
	
	
}

package informacion;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

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
	                return createPage(pageIndex);
	            }
	        });
	    } 
		
		 public VBox createPage(int pageIndex) {        
		        int itemsPerPage = 5;//items por pagina
		        VBox box = new VBox();//contenedor
		        box.setStyle("-fx-background-color:skyblue");
		        int page = pageIndex * itemsPerPage;         
		        for (int i = page; i < page + itemsPerPage && i < 18; i++) {            
		        	
		            
		        }
		        return box;
		    }
	}

package pagination;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class PaginationController implements Initializable {
	
	@FXML Pagination pag;
	
	@FXML ProgressBar bar ;
	
	public void initialize(URL url, ResourceBundle rb) {
       
        pag.setMaxPageIndicatorCount(7);
        pag.setPageCount(4);
        pag.setStyle("-fx-border-color:blue;");

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
	        box.setStyle("-fx-background-color:blue");
	        int page = pageIndex * itemsPerPage;         
	        for (int i = page; i < page + itemsPerPage && i < 18; i++) {            
	            //Crea un Label con un nombre aleatorio
	            Label text = new Label( (i+1) + ".- " + Dummy.getFullName());
	            text.setStyle("-fx-font-size:16;-fx-background-color:cyan"+  
	                          ";-fx-pref-width:400px;-fx-padding:8px 0 8px 8px;");            
	            box.getChildren().add(text);
	        }
	        return box;
	    }
}

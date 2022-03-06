package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.image.ImageView;

public class ListController {

    @FXML
    private ResourceBundle resources;
    
    public static final ObservableList<String> names = FXCollections.observableArrayList();
        public static final ObservableList<String> data = FXCollections.observableArrayList();
        
    @FXML
    private URL location;

    @FXML
    private ToggleGroup genero;
    @FXML
    private ChoiceBox<Object> choice1;
    @FXML
    private ListView<String> list1;
    @FXML
    private ComboBox<String> combo1;
    @FXML
    private TreeView<String> tree1;

    @FXML
    void initialize() {
    	
    	//Choice box Ejercicio2 a
        choice1.getItems().addAll("New York","Orlando", new Separator(),"London","Manchester");
        choice1.setValue("select a value...");
    	 
        //Listview Ejercicio2 b
        list1.setEditable(true);
        
    	 names.addAll("Adam", "Alex", "Alfred", "Albert",
                 "Brenda", "Connie", "Derek", "Donny", 
                 "Lynne", "Myrtle", "Rose", "Rudolph", 
                 "Tony", "Trudy", "Williams", "Zach"
            );
    	 for (int i = 0; i < 10; i++) {
             data.add("Indeterminate(pick a choice)");
         }
    	    
         list1.setItems(data);
         list1.setCellFactory(ComboBoxListCell.forListView(names)); 
         
         // ComboBox Ejercicio 2 c
         combo1.getItems().addAll("English","Spanish","Japanese");
         combo1.setValue("Select a lenguage...");
         
         //Ejercicio 3 a Tree view
         TreeItem<String> rootItem= new TreeItem<String>("Inbox");
         rootItem.getChildren().add(new TreeItem<String> ("Sales"));
         rootItem.getChildren().add(new TreeItem<String> ("Marketing"));
         rootItem.getChildren().add(new TreeItem<String> ("Distribution"));
         rootItem.getChildren().add(new TreeItem<String> ("Cost"));
         rootItem.setExpanded(true);
         tree1.setRoot(rootItem);
         
    }
    
}

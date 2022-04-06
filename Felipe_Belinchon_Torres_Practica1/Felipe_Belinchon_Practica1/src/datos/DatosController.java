package datos;



import application.MenuController;
import application.Persona;
import formulario.FormularioController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTreeCell;



public class DatosController {
	@FXML
	private ComboBox <String> list1;
	@FXML
	private ChoiceBox <String> list2;
    @FXML
    private TableView<Persona> table1;
    @FXML
    private TableColumn<Persona, String> firstNameCol;
    @FXML
    private TableColumn<Persona, String> lastNameCol;
    @FXML
    private TableColumn<Persona, String> emailCol;
    @FXML
    private TableColumn<Persona, Integer> ageColumn;
    @FXML
    private TableColumn<Persona, String> generoColumn;
    @FXML
    private TableColumn<Persona, String> lenguajeColumn;
    @FXML
    private TableColumn<Persona, Integer> sueldoColumn;
    
    @FXML
    private TreeView<String> tree1;
    
    private MenuController menu;

    
    private  static ObservableList<Persona> data ;

    
    @FXML
    void initialize() {
    	
    	list1.getItems().addAll("Felipe Belinchon","David Perez","javier Fernandez","Jose Gracia","Peter Pan");
    	list2.getItems().addAll("Depsedir","Ascender","Mantener");
    	list2.setValue("Accion");
    	
    			firstNameCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("firstName"));
    			lastNameCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("lastName"));
    			emailCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("email"));
    			ageColumn.setCellValueFactory(new PropertyValueFactory<Persona,Integer>("age"));
    			generoColumn.setCellValueFactory(new PropertyValueFactory<Persona,String>("genero"));
    			lenguajeColumn.setCellValueFactory(new PropertyValueFactory<Persona,String>("lenguaje"));
    			sueldoColumn.setCellValueFactory(new PropertyValueFactory<Persona,Integer>("sueldo"));
    			
    			
    			
    					
    			
    			TreeItem<String> rootItem = new TreeItem<String>("FiloEntertainment");
    
    			TreeItem<String> webItem = new TreeItem<String>("Departamento de RRHH");
    			webItem.getChildren().add(new TreeItem<String>("Jose gracia"));
    			webItem.getChildren().add(new TreeItem<String>("Armando Bronca"));
    			webItem.getChildren().add(new TreeItem<String>("Pepito Perez"));
    			webItem.getChildren().add(new TreeItem<String>("Peter Pan"));
    			rootItem.getChildren().add(webItem);

    			TreeItem<String> javaItem = new TreeItem<String>("Departamento de prgramacion");
    			javaItem.getChildren().add(new TreeItem<String>("Felipe Belinchon"));
    			javaItem.getChildren().add(new TreeItem<String>("Javier Fernandez"));
    			javaItem.getChildren().add(new TreeItem<String>("Daviz Perez"));
    			rootItem.getChildren().add(javaItem);
    			tree1.setCellFactory(TextFieldTreeCell.forTreeView());

    			rootItem.setExpanded(true);
    			tree1.setRoot(rootItem);
    			
    			
    			table1.setItems(data);
    			
    					
    }
    public void actualizarTabla() {
    	table1.setItems(data);
    }
    
    
    public void setMenu(MenuController menu) {
    	this.menu=menu;
    }
    
    
  
    
    
    
    
    
    
	public ComboBox<String> getList1() {
		return list1;
	}
	public void setList1(ComboBox<String> list1) {
		this.list1 = list1;
	}
	public ChoiceBox<String> getList2() {
		return list2;
	}
	public void setList2(ChoiceBox<String> list2) {
		this.list2 = list2;
	}
	public TableView<Persona> getTable1() {
		return table1;
	}
	public void setTable1(TableView<Persona> table1) {
		this.table1 = table1;
	}
	public TableColumn<Persona, String> getFirstNameCol() {
		return firstNameCol;
	}
	public void setFirstNameCol(TableColumn<Persona, String> firstNameCol) {
		this.firstNameCol = firstNameCol;
	}
	public TableColumn<Persona, String> getLastNameCol() {
		return lastNameCol;
	}
	public void setLastNameCol(TableColumn<Persona, String> lastNameCol) {
		this.lastNameCol = lastNameCol;
	}
	public TableColumn<Persona, String> getEmailCol() {
		return emailCol;
	}
	public void setEmailCol(TableColumn<Persona, String> emailCol) {
		this.emailCol = emailCol;
	}
	public TableColumn<Persona, Integer> getAgeColumn() {
		return ageColumn;
	}
	public void setAgeColumn(TableColumn<Persona, Integer> ageColumn) {
		this.ageColumn = ageColumn;
	}
	public TableColumn<Persona, String> getGeneroColumn() {
		return generoColumn;
	}
	public void setGeneroColumn(TableColumn<Persona, String> generoColumn) {
		this.generoColumn = generoColumn;
	}
	public TableColumn<Persona, String> getLenguajeColumn() {
		return lenguajeColumn;
	}
	public void setLenguajeColumn(TableColumn<Persona, String> lenguajeColumn) {
		this.lenguajeColumn = lenguajeColumn;
	}
	public TableColumn<Persona, Integer> getSueldoColumn() {
		return sueldoColumn;
	}
	public void setSueldoColumn(TableColumn<Persona, Integer> sueldoColumn) {
		this.sueldoColumn = sueldoColumn;
	}
	public TreeView<String> getTree1() {
		return tree1;
	}
	public void setTree1(TreeView<String> tree1) {
		this.tree1 = tree1;
	}
	public ObservableList<Persona> getData() {
		return data;
	}
	public void setData(ObservableList<Persona> data) {
		this.data = data;
	}
}
	

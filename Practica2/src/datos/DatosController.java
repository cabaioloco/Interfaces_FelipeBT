package datos;




import java.io.IOException;

import application.MenuController;
import application.Persona;
import formulario.FormularioController;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class DatosController {

	@FXML
	private Button borrar;
	@FXML
	private Button editar;
	@FXML
	private Button mostrar;
	
	@FXML
	private Text cambio;
	
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
 
    private Button info;
    
    private MenuController menu;
    
    private InfoController icontroller;
    
    @FXML
    private VBox tuto;
    
    @FXML
    private Button crearTarea;
    @FXML
    private Button crearObjetivo;
    @FXML
    private Button crearContacto;
    
//    @FXML
//    private TreeItem<String> rootItem = new TreeItem<String>("FiloEntertainment");

    @FXML
    private ListView<String> list;
    
    @FXML 
    private VBox papelera; 
    
    private  static ObservableList<Persona> data ;

    
    @FXML
    void initialize() {
    	
    		list.getItems().addAll("Tareas:","-Eliminar presupuesto");

    		if(table1 !=null) {
    			firstNameCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("firstName"));
    			lastNameCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("lastName"));
    			emailCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("email"));
    			ageColumn.setCellValueFactory(new PropertyValueFactory<Persona,Integer>("age"));
    			generoColumn.setCellValueFactory(new PropertyValueFactory<Persona,String>("genero"));
    			lenguajeColumn.setCellValueFactory(new PropertyValueFactory<Persona,String>("lenguaje"));
    			sueldoColumn.setCellValueFactory(new PropertyValueFactory<Persona,Integer>("sueldo"));
    			
    			
//    		    
//    			TreeItem<String> tareas = new TreeItem<String>("Tareas");
//    		
//    			rootItem.getChildren().add(tareas);
//
//    			TreeItem<String> objetivos = new TreeItem<String>("Objetivos");
//    			
//    			rootItem.getChildren().add(objetivos);
//    			
//    			TreeItem<String> contactos = new TreeItem<String>("Contactos");
//    			
//    			rootItem.getChildren().add(contactos);
    			
    			
    			
    			list.setOnDragDetected((event) -> {
        			// Se indica que el modo de transferencia será del tipo movimiento
        			Dragboard db = list.startDragAndDrop(TransferMode.MOVE);
        			});
        		
        		papelera.setOnDragOver((event) -> {
        			// Solo se acepta si se detecta texto en el objeto Dragboard
        			if (event.getDragboard().hasString()) {
        			// Se permite movimiento drag and drop
        			event.acceptTransferModes(TransferMode.MOVE);
        			}
        			});
        		papelera.setOnDragDropped((event) -> {
        			// Si se ha almacenado texto se copia al destino
        			Dragboard db = event.getDragboard();
        			if (db.hasString()) {
        			
        			}
        			});
        		
        		

    				

    			
    			
//    			tree1.setCellFactory(TextFieldTreeCell.forTreeView());

//    			rootItem.setExpanded(true);
//    			tree1.setRoot(rootItem);
    			
    			
    			table1.setItems(data);
    			//revisar listener salta una excepcion
    			
    			table1.getSelectionModel().getSelectedItems().addListener(new InvalidationListener() {
					
					@Override
					public void invalidated(Observable arg0) {
						if(table1.getSelectionModel().getSelectedItem().getFirstName()!=null) {
						cambio.setText("El empleado "+table1.getSelectionModel().getSelectedItem().getFirstName()+" ha sido seleccionado");
						}
					}
				});
    			//eventos relativos a el cuadrado que redirecciona a la informacion
    			tuto.addEventHandler(MouseEvent.MOUSE_CLICKED , e -> {
    				//redireccinamos a la pestaña de informacion relativa
					menu.RedireccionInfoDatos();
					});
    			
    			//cambios de cursores
    			tuto.addEventHandler(MouseEvent.MOUSE_ENTERED, e->{
    				tuto.setCursor(Cursor.HAND);
    			});
    			borrar.addEventHandler(MouseEvent.MOUSE_ENTERED, e->{
    				borrar.setCursor(Cursor.HAND);
    			});
    			crearTarea.addEventHandler(MouseEvent.MOUSE_ENTERED, e->{
    				crearTarea.setCursor(Cursor.HAND);
    			});
    			editar.addEventHandler(MouseEvent.MOUSE_ENTERED, e->{
    				editar.setCursor(Cursor.HAND);
    			});
    			mostrar.addEventHandler(MouseEvent.MOUSE_ENTERED, e->{
    				mostrar.setCursor(Cursor.HAND);
    			});
    			crearContacto.addEventFilter(MouseEvent.MOUSE_ENTERED, e->{
    				crearContacto.setCursor(Cursor.HAND);
    			});
    			crearObjetivo.addEventFilter(MouseEvent.MOUSE_ENTERED, e->{
    				crearObjetivo.setCursor(Cursor.HAND);
    			});
    			crearTarea.addEventFilter(MouseEvent.MOUSE_ENTERED, e->{
    				crearTarea.setCursor(Cursor.HAND);
    			});
    			
    		}
    		
    		
    			
    			
    			
    					
    }  
    
    public void crearTarea() {
    	TextInputDialog textDialog = new TextInputDialog("Tarea...");
    	textDialog.setTitle("Creacion de Tareas");
    	textDialog.setHeaderText("Pon el nombre de la Tarea que quieres crear");
    	textDialog.showAndWait().ifPresent(response->{
    		TreeItem<String> Item = new TreeItem<String>(response);
//    		 rootItem.getChildren().get(0).getChildren().add(Item);
    	});
    	
    }
    public void crearObjetivo() {
    	TextInputDialog textDialog = new TextInputDialog("Objetivo...");
    	textDialog.setTitle("Creacion de Objetivos");
    	textDialog.setHeaderText("Pon el nombre del objetivo que quieres crear");
    	textDialog.showAndWait().ifPresent(response->{
    		TreeItem<String> Item = new TreeItem<String>(response);
//    		 rootItem.getChildren().get(1).getChildren().add(Item);
    	});
    	
    }public void crearContacto() {
    	TextInputDialog textDialog = new TextInputDialog("Contacto...");
    	textDialog.setTitle("Creacion de Contactos");
    	textDialog.setHeaderText("Pon el nombre de la contacto que quieres crear");
    	textDialog.showAndWait().ifPresent(response->{
    		TreeItem<String> Item = new TreeItem<String>(response);
//    		 rootItem.getChildren().get(2).getChildren().add(Item);
    	});
    	
    }
    public void borrarDepartamento() {
    	if(tree1.getSelectionModel().getSelectedItem()!=null) {
			Alert confirmation = new Alert(AlertType.CONFIRMATION);
			confirmation.setTitle("¿Desea borrar?");
			confirmation.setHeaderText("¿Usted esta seguro de borrar el departamento?");
			confirmation.setContentText("Si borras el departamento no podras recuperarlo");
			confirmation.showAndWait().ifPresent(response->{
				if(response == ButtonType.OK) {
					int index =tree1.getSelectionModel().getSelectedIndex();
//					rootItem.getChildren().remove(index-1);
				}
				});
			
		}
		else {
			Alert noSelected = new Alert(AlertType.WARNING);
			noSelected.setTitle("¡Cuidado!");
			noSelected.setHeaderText("¡Cuidado! Selececiona un departamento");
			noSelected.setContentText("Para borrar un departamento primero debes selecionar un empleado.");
			noSelected.showAndWait();
		}
    }
    public void actualizarTabla() {
    	table1.setItems(data);
    }
    
    
    public void setMenu(MenuController menu) {
    	this.menu=menu;
    }
    public void setInfo(InfoController i) {
    	this.icontroller=i;
    }
  //Boton de borrar registro
    public void borrar(ActionEvent e) {
    	if(table1.getSelectionModel().getSelectedItem()!=null) {
			Alert confirmation = new Alert(AlertType.CONFIRMATION);
			confirmation.setTitle("¿Desea borrar?");
			confirmation.setHeaderText("¿Usted esta seguro de borrar el registro?");
			confirmation.setContentText("Si borras el registro no podras recuperarlo");
			confirmation.showAndWait().ifPresent(response->{
				if(response == ButtonType.OK) {
					int index = table1.getSelectionModel().getSelectedIndex();
					data.remove(index);
					actualizarTabla();
				}
				});
			
		}
		else {
			Alert noSelected = new Alert(AlertType.WARNING);
			noSelected.setTitle("¡Cuidado!");
			noSelected.setHeaderText("¡Cuidado! Selececiona un empleado");
			noSelected.setContentText("Para borrar un empleado primero debes selecionar un empleado.");
			noSelected.showAndWait();
		}
    }
	public void ventana(ActionEvent e) {
		if(table1.getSelectionModel().getSelectedItem()!=null) {
		try {
			Persona persona = table1.getSelectionModel().getSelectedItem();
			// Cargamos el diseño del diálogo desde un XML
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(DatosController.class.
			getResource("InfoEmpleado.fxml"));
			GridPane page = (GridPane) loader.load();
			// Se crea un nuevo Stage para mostrar el diálogo
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Informacion de usuario");
			// Se bloquean los eventos de la pantalla principal
			dialogStage.initModality(Modality.WINDOW_MODAL);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			
			dialogStage.show();
			
			InfoController icontroll=loader.getController();
			
			icontroll.setPersona(persona);
			
		
		
		} catch (IOException ex) {
			ex.printStackTrace();
			}
	}
	else {
		Alert noSelected = new Alert(AlertType.WARNING);
		noSelected.setTitle("¡Cuidado!");
		noSelected.setHeaderText("¡Cuidado! Selececiona un empleado");
		noSelected.setContentText("Para mostrar un empleado primero debes selecionar un empleado.");
		noSelected.showAndWait();
	}
	}
    
   public void editar() {
		if(table1.getSelectionModel().getSelectedItem()!=null) {	
			   menu.setPersona(table1.getSelectionModel().getSelectedItem());
			   menu.RedireccionFormulario();

				 int index = data.indexOf(table1.getSelectionModel().getSelectedItem());
				   data.remove(index);
		}
		else {
			Alert noSelected = new Alert(AlertType.WARNING);
			noSelected.setTitle("¡Cuidado!");
			noSelected.setHeaderText("¡Cuidado! Selececiona un empleado");
			noSelected.setContentText("Para editar un empleado primero debes selecionar un empleado.");
			noSelected.showAndWait();
		}
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
	

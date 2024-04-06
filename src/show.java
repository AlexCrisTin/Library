import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class show implements Initializable{
    @FXML
    private TableView<availableBooks> table;

    @FXML
    private TableColumn<availableBooks, String> author;
    
    @FXML
    private TableColumn<availableBooks, String> kind;

    @FXML
    private TableColumn<availableBooks, String> namebook;

    @FXML
    private TableColumn<availableBooks, String> view;

    private ObservableList<availableBooks> books;
    
    public void initialize(URL location, ResourceBundle resources, ObservableList<availableBooks> books) {
        this.books = books;
        namebook.setCellValueFactory(new PropertyValueFactory<availableBooks, String>("namebook"));
        kind.setCellValueFactory(new PropertyValueFactory<availableBooks, String>("kind"));
        author.setCellValueFactory(new PropertyValueFactory<availableBooks, String>("author"));
        view.setCellValueFactory(new PropertyValueFactory<availableBooks, String>("view"));
        table.setItems(books);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         {
            namebook.setCellValueFactory(new PropertyValueFactory<availableBooks, String>("namebook"));
            kind.setCellValueFactory(new PropertyValueFactory<availableBooks, String>("kind"));
            author.setCellValueFactory(new PropertyValueFactory<availableBooks, String>("author"));
            view.setCellValueFactory(new PropertyValueFactory<availableBooks, String>("view"));
            table.setItems(books);
        }

    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void btnCreateClicked(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/FXML/Create.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private AnchorPane scenePane;
    
    public void Logout(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout?");
        alert.setHeaderText("Are you sure?");
        alert.setContentText("Bye and see you again.");
        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) scenePane.getScene().getWindow();
         
            stage.close();
        }
    }
    public void Home(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void ReturnBook(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/FXML/return.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void CheckBook(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/FXML/CheckBook.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void Fix(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/FXML/fix.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }
    public void Delete(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/FXML/Delete.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void Create(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/FXML/Create1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void btnExitClicked(ActionEvent event) throws IOException{
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit?");
        alert.setHeaderText("Are you sure?");
        alert.setContentText("Save everything before exit!!!");
    
        if(alert.showAndWait().get() == ButtonType.OK){
            root = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}

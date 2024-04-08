import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

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

public class show {
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


  
    
    public void initialize() {
        
        namebook.setCellValueFactory(new PropertyValueFactory<>("namebook"));
        kind.setCellValueFactory(new PropertyValueFactory<>("kind"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        view.setCellValueFactory(new PropertyValueFactory<>("view"));
        table.setItems(getbooks());
    }

    private ObservableList<availableBooks> getbooks() {
        ObservableList<availableBooks> books = FXCollections.observableArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader("BookData.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                for (int i = 0; i < data.length; i++) {
                    data[i] = binaryToString(data[i]);
                }
                books.add(new availableBooks(data[0], data[1], data[2], data[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    private String binaryToString(String binary) {
        StringBuilder str = new StringBuilder();
        String[] split = binary.split(" ");
        for (String s : split) {
            str.append((char) Integer.parseInt(s, 2));
        }
        return str.toString();
    }
    
    public void Delete1 (ActionEvent e) throws IOException{
      
    
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
    public void information(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/FXML/infor.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

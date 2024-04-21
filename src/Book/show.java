package Book;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class show {
    @FXML
    private TextField search;
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

    ObservableList<availableBooks> books = FXCollections.observableArrayList();


    public void initialize() {
        namebook.setCellValueFactory(new PropertyValueFactory<>("namebook"));
        kind.setCellValueFactory(new PropertyValueFactory<>("kind"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        view.setCellValueFactory(new PropertyValueFactory<>("daypuli"));
        table.setItems(books());
        FilteredList<availableBooks> filteredList = new FilteredList<>(books(), b -> true);{
            search.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate(book -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
            
                    String lowerCaseFilter = newValue.toLowerCase();
            
                    if (book.getNamebook().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    return false;
                });
            });}
            SortedList<availableBooks> sortedData = new SortedList<>(filteredList);
            sortedData.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(sortedData);

    }


    
    private ObservableList<availableBooks> books() {
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
        availableBooks selected = table.getSelectionModel().getSelectedItem();
    
        if (selected != null) {
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("BookData.dat"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    for (int i = 0; i < data.length; i++) {
                        data[i] = binaryToString(data[i]);
                    }
                 
                    if (!data[0].equals(selected.getNamebook()) ||
                        !data[1].equals(selected.getKind()) ||
                        !data[2].equals(selected.getAuthor()) ||
                        !data[3].equals(selected.getDaypuli())) {
                        lines.add(line);
                    }
                }
            } catch (IOException i) {
                i.printStackTrace();
            }
    
         
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("BookData.dat"))) {
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
            } catch (IOException i) {
                i.printStackTrace();
            }
    
            
            table.getItems().remove(selected);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Hãy chọn 1 sách để xóa ");
            alert.showAndWait();
        
        }
    }
    public void updatebook(ActionEvent event) throws IOException{
        availableBooks selected = table.getSelectionModel().getSelectedItem();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/fixinfo.fxml"));
            Parent studentViewParent = loader.load();
            Scene scene = new Scene(studentViewParent);
            FixBook controller = loader.getController();
           
            controller.setBook(selected);
            stage.setScene(scene);
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

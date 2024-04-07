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
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


    
    public class TableReturn {
        private Stage stage;
        private Scene scene;
        private Parent root;
        @FXML
        private TableView<StudentInformation> tableView;
        @FXML
        private TableColumn<StudentInformation, String> nameColumn;
        @FXML
        private TableColumn<StudentInformation, String> mssvColumn;
        @FXML
        private TableColumn<StudentInformation, String> dayColumn;
        @FXML
        private TableColumn<StudentInformation, String> dayPayColumn;
    
        public void initialize() {
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("namestudent"));
            mssvColumn.setCellValueFactory(new PropertyValueFactory<>("MSSV"));
            dayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));
            dayPayColumn.setCellValueFactory(new PropertyValueFactory<>("daypay"));
    
            tableView.setItems(getStudents());
        }
    
        private ObservableList<StudentInformation> getStudents() {
            ObservableList<StudentInformation> students = FXCollections.observableArrayList();
            try (BufferedReader reader = new BufferedReader(new FileReader("StudentData.dat"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    for (int i = 0; i < data.length; i++) {
                        data[i] = binaryToString(data[i]);
                    }
                    students.add(new StudentInformation(data[0], data[1], data[2], data[3]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return students;
        }
    
        private String binaryToString(String binary) {
            StringBuilder str = new StringBuilder();
            String[] split = binary.split(" ");
            for (String s : split) {
                str.append((char) Integer.parseInt(s, 2));
            }
            return str.toString();
        }
    
    
    @FXML
    void btnExitClicked(ActionEvent event) throws IOException {
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



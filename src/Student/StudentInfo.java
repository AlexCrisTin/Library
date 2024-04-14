package Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;


import Book.availableBooks;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentInfo {

    @FXML
    private TextField MSSV;
    @FXML
    private ComboBox<availableBooks> book;
    @FXML
    private TextField day;
    @FXML
    private TextField daypay;
    @FXML
    private TextField namestudent;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void initialize() {
        ObservableList<availableBooks> books = FXCollections.observableArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader("BookData.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                for (int i = 0; i < data.length; i++) {
                    data[i] = binaryToString(data[i]);
                }
                books.add(new availableBooks(data[0], line, line, line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        book.setItems(books); 
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
void rent(ActionEvent event) throws IOException {
    Alert alert;
    
        String[] StudentInfo = new String[5];
        StudentInfo[0] = namestudent.getText();
        StudentInfo[1] = MSSV.getText();
        StudentInfo[2] = day.getText();
        StudentInfo[3] = daypay.getText();
        StudentInfo[4] = book.getValue().getNamebook();

       
        for (String info : StudentInfo) {
            if (info == null || info.trim().isEmpty()) {
                alert = new Alert(AlertType.WARNING);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Làm ơn điền thông tin");
                alert.showAndWait();
                return; 
            }
        }

        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Rent Complete");
        alert.setHeaderText("Rent Complete");
        
        saveToFile(StudentInfo);
     
    
    if(alert.showAndWait().get() == ButtonType.OK){
        
        Parent NewStudentInterface = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
        Scene NewStudentScene = new Scene(NewStudentInterface); 
        Stage window = (Stage)((Button) event.getSource()).getScene().getWindow(); 
        window.setScene(NewStudentScene);
        window.show();
    }
}
private void saveToFile(String[] StudentInfo) {
    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("StudentData.dat", true)))) {
        for (String info : StudentInfo) {
            if (info != null) {
                String binaryString = stringToBinary(info);
                writer.write(binaryString + ","); 
            }
        }
        writer.newLine();
        writer.flush(); 
    } catch (IOException e) {
        e.printStackTrace();
    }
}
private String stringToBinary(String str) {
    StringBuilder binary = new StringBuilder();
    for (char c : str.toCharArray()) {
        String binaryChar = Integer.toBinaryString(c);
        binary.append(binaryChar).append(" ");
    }
    return binary.toString();

}
    
public void Rule(ActionEvent event) throws IOException {
    
        root = FXMLLoader.load(getClass().getResource("/FXML/Rule.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
}
public void close(ActionEvent event) throws IOException {
    
    root = FXMLLoader.load(getClass().getResource("/FXML/info.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

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


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentInfo {

    @FXML
    private TextField MSSV;

    @FXML
    private TextField day;

    @FXML
    private TextField namestudent;
    private Stage stage;
    private Scene scene;
    private Parent root;
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
    @FXML
    void rent(ActionEvent event) throws IOException {
        String[] StudentInfo = new String[3];
        StudentInfo[0] = namestudent.getText();
        StudentInfo[1] = MSSV.getText();
        StudentInfo[2] = day.getText();

        saveToFile(StudentInfo);

        Parent NewStudentInterface = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
        Scene NewStudentScene = new Scene(NewStudentInterface); 
        Stage window = (Stage)((Button) event.getSource()).getScene().getWindow(); 
        window.setScene(NewStudentScene);
        window.show();
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
}

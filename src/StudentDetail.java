

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class StudentDetail {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label daily;

    @FXML
    private Label dailypay;

    @FXML
    private Label id;

    @FXML
    private Label name;

    @FXML
    private Label namebook;

    
    public void setStudent(StudentInformation student){
        name.setText(String.valueOf(student.getDay()));
        id.setText(student.getNamestudent());
        daily.setText(String.valueOf(student.getDay()));
        dailypay.setText(String.valueOf(student.getDaypay()));
    }
    public void ReturnBook(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/FXML/return.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

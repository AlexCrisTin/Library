
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class MainSceneController {      
    
private Stage stage;
private Scene scene;
private Parent root;

                                         //Login and Logout method
                
@FXML
private PasswordField passwordField;

@FXML
private TextField usernameField;

Preferences preferences;

public void in(URL url, ResourceBundle rb){
    //Tạo một nút Preferences cho Main
    preferences = Preferences.userNodeForPackage(MainSceneController.class);
    //Kiểm tra
    if(preferences != null){
        if(preferences.get("username", null) != null && !preferences.get("username", null).isEmpty()){
            // Đặt giá trị lưu trữ cho username và password trong preferences
            usernameField.setText(preferences.get("username", null));
            passwordField.setText(preferences.get("password", null));
        }
    }
}


public void Login(ActionEvent event) throws IOException{
    if(usernameField.getText().equals("1") && passwordField.getText().equals("1")){
        //Kiểm tra
        if (preferences != null) {
            //Lưu trữ cho username và password trong preferences
            preferences.put("username", usernameField.getText());
            preferences.put("pass", passwordField.getText());
        } else {
            System.out.println("Welcome");
        }
        // Load scene
        root = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
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

                    // Button Click

    
public void watchmore(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Watchmore.fxml"));
    root = loader.load();
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
public void btnCreateClicked(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("/FXML/Create.fxml"));
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

public void Delete(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Delete.fxml"));
    root = loader.load();
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

public void Cancel(ActionEvent event) throws IOException {
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Cancel?");
    alert.setHeaderText("Are you sure?");
    alert.setContentText("Think again before cancel posting a book");

    if(alert.showAndWait().get() == ButtonType.OK){
        root = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}


                                      //Book

public void btnViewClicked(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("/FXML/B1.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}


public void information(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("/FXML/infor.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
}
    

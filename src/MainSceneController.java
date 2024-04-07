
import java.io.File;
import java.io.IOException;
import java.net.URL;


import java.util.ResourceBundle;
import java.util.prefs.Preferences;






import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
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
    preferences = Preferences.userNodeForPackage(MainSceneController.class);

    if(preferences != null){
        if(preferences.get("username", null) != null && !preferences.get("username", null).isEmpty()){
            usernameField.setText(preferences.get("username", null));
            passwordField.setText(preferences.get("password", null));
        }
    }
}
public void Log(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
@FXML
private Button buttlog;

public void Login(ActionEvent event) throws IOException{
    if(usernameField.getText().equals("1") && passwordField.getText().equals("1")){
        if (preferences != null) {
            preferences.put("username", usernameField.getText());
            preferences.put("pass", passwordField.getText());
        } else {
            System.out.println("Welcome");
        }
        
        root = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        buttlog.setVisible(false);
    }


    /*String username = nameTextField.getText();

    FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));

    root = loader.load();
    Scene2Login login = loader.getController();
    login.displayName(username);
    */
    
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

public void Home(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
    
    
public void watchmore(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Watchmore.fxml"));
    root = loader.load();
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    ObservableList<availableBooks> books = FXCollections.observableArrayList(
        new availableBooks("C++", "Author1", "Kind1", "View1"),
        new availableBooks("Book2", "Author2", "Kind2", "View2")
    );
    show show = loader.getController();
    show.initialize(null, null, books);
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
    ObservableList<availableBooks> books = FXCollections.observableArrayList(
        new availableBooks("C++", "Author1", "Kind1", "View1"),
        new availableBooks("Book2", "Author2", "Kind2", "View2")
    );
    show show = loader.getController();
    show.initialize(null, null, books);
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

                                 // Find book



                    //Book

public void btnViewClicked(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("/FXML/B1.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

public void btnView1Clicked(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("/FXML/B2.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

public void btnView2Clicked(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("/FXML/B3.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

public void btnView3Clicked(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("/FXML/B4.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}












                                //Pick photo
@FXML
private ImageView imgView;


public void Pick(ActionEvent event) throws IOException{
    FileChooser fileChooser = new FileChooser();
    fileChooser.setInitialDirectory(new File("C:\\"));
    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG image","*.jpg"),
        new FileChooser.ExtensionFilter("PNG image", "*.png"), new FileChooser.ExtensionFilter("All images", "*.jpg","*.png"));
    File selectFile = fileChooser.showOpenDialog(stage);
    if(selectFile != null){
        Image image = new Image(selectFile.toURI().toURL().toExternalForm());
        imgView.setImage(image);
    }
    else{
        System.out.println("No file has been choose");
        
    }
} 
                    //Information
public void information(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("/FXML/infor.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
}
    

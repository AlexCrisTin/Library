
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.*;

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
@FXML

public void Login(ActionEvent event) throws IOException{
    if(usernameField.getText().equals("1") && passwordField.getText().equals("1")){
        if (preferences != null) {
            preferences.put("username", usernameField.getText());
            preferences.put("pass", passwordField.getText());
        } else {
            System.out.println("Welcome");
        }

        root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

public void watchmore(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("Watchmore.fxml"));
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
        root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
public void btnCreateClicked(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("Create.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

public void Create(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("Create1.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

public void Delete(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

public void Fix(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("fix.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

}
public void ReturnBook(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("return.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}



public void CheckBook(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("CheckBook.fxml"));
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
        root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

                                 // Find book

private TextField findBook;
private Button Find;

String find;
public void Find(ActionEvent event){
    
    

}
                    //Book

public void btnViewClicked(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("B1.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

public void btnView1Clicked(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("B2.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

public void btnView2Clicked(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("B3.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

public void btnView3Clicked(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("B4.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}












                                //Pick photo and upload
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
public void upload(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("B4.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
                    //Information
public void information(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("infor.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

//nhap file
public class Item {
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;
    private String field6;
    private String field7;
    public void setField1(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setField1'");
    }

    // Các phương thức getter và setter cho từng trường dữ liệu
}
/* 
public class Write {
    public static void main(String[] args) {
        FileWriter fw = new FileWriter("data.txt", true);
    }
}
*/


public class FXMLParser {
    public static void main(String[] args) {
        try {
            // Load the FXML file
            File fxmlFile = new File("Create1.fxml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fxmlFile);
            
            // Normalize the document
            doc.getDocumentElement().normalize();
            
            // Get the root element
            Element root = doc.getDocumentElement();
            
            // Here you can extract data from the root element
            // For example, if you want to extract text content:
            String content = root.getTextContent();
            
            // Write the extracted content to another file
            FileWriter writer = new FileWriter("output.txt");
            writer.write(content);
            writer.close();
            
            System.out.println("Data extracted and written to output.txt successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


}
                    

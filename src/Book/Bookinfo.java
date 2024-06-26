package Book;
import java.io.BufferedWriter;
import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Bookinfo {

    @FXML
    private TextField daypuli;

    @FXML
    private TextField kind;

    @FXML
    private TextField nameauthor;

    @FXML
    private TextField namebook;

    Alert alert;
    @FXML
    public void upload(ActionEvent event) throws IOException {
        String[] bookInfo = new String[4];
        bookInfo[0] = namebook.getText();
        bookInfo[1] = kind.getText();
        bookInfo[2] = nameauthor.getText();
        bookInfo[3] = daypuli.getText();
        
        for (String info : bookInfo) {
            if (info == null || info.trim().isEmpty()) {
                alert = new Alert(AlertType.WARNING);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Làm ơn điền thông tin");
                alert.showAndWait();
                return; 
            }
        }
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Upload Complete");
            alert.setHeaderText("Upload Complete");
            
            saveToFile(bookInfo);

            if(alert.showAndWait().get() == ButtonType.OK){
                Parent NewStudentInterface = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
                Scene NewStudentScene = new Scene(NewStudentInterface); 
                Stage window = (Stage)((Button) event.getSource()).getScene().getWindow(); 
                window.setScene(NewStudentScene);
                window.show();
            }
       
    }

    private void saveToFile(String[] BookInfo) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("BookData.dat", true)))) {
            for (String info : BookInfo) {
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
      
        private Stage stage;
        private Scene scene;
        private Parent root;
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
}

package Book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

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

public class FixBook {

    @FXML
    private TextField daypuli;

    @FXML
    private ImageView imgView;

    @FXML
    private TextField kind;

    @FXML
    private TextField nameauthor;

    @FXML
    private TextField namebook;

    @SuppressWarnings("unused")
    private availableBooks selectedBook; // Sách được chọn để chỉnh sửa

    // Phương thức này được gọi từ lớp show khi người dùng chọn sách để chỉnh sửa
    public void setBook(availableBooks book) {
        this.selectedBook = book;
        // Hiển thị thông tin sách đã chọn trong giao diện chỉnh sửa
        namebook.setText(book.getNamebook());
        kind.setText(book.getKind());
        nameauthor.setText(book.getAuthor());
        daypuli.setText(book.getDaypuli());
    }

    // Phương thức để lưu thông tin sách sau khi chỉnh sửa
    public void uploadfix(ActionEvent event) throws IOException {
        // Lấy thông tin sách cũ
        String oldNamebook = namebook.getText();
    
        // Lấy thông tin sách mới
        String newNamebook = namebook.getText();
        String newKind = kind.getText();
        String newNameauthor = nameauthor.getText();
        String newDaypuli = daypuli.getText();
        
    
        // Cập nhật thông tin sách trong tệp nhị phân
        updateBookInfo(oldNamebook, newNamebook, newKind, newNameauthor, newDaypuli);
    
        // Chuyển đến giao diện chính
        Parent NewBookInterface = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
        Scene NewBookScene = new Scene(NewBookInterface);
        Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
        window.setScene(NewBookScene);
        window.show();
    }
    
    private void updateBookInfo(String oldNamebook, String newNamebook, String newKind, String newNameauthor, String newDaypuli) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("BookData.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                for (int i = 0; i < data.length; i++) {
                    data[i] = binaryToString(data[i]);
                }
    
                // Kiểm tra xem dòng nào chứa thông tin sách cần cập nhật
                if (data[0].equals(oldNamebook)) {
                    // Cập nhật thông tin sách mới
                    data[0] = newNamebook;
                    data[1] = newKind;
                    data[2] = newNameauthor;
                    data[3] = newDaypuli;
                }
    
                // Chuyển lại thành dạng nhị phân và thêm vào danh sách dòng mới
                StringBuilder updatedLine = new StringBuilder();
                for (String info : data) {
                    updatedLine.append(stringToBinary(info)).append(",");
                }
                lines.add(updatedLine.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        // Ghi lại tất cả các dòng đã cập nhật vào tệp nhị phân
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BookData.dat"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    // Phương thức này chuyển đổi chuỗi ký tự thành chuỗi nhị phân
    private String stringToBinary(String str) {
        StringBuilder binary = new StringBuilder();
        for (char c : str.toCharArray()) {
            String binaryChar = Integer.toBinaryString(c);
            binary.append(binaryChar).append(" ");
        }
        return binary.toString();
    }
    
    private String binaryToString(String binary) {
        StringBuilder str = new StringBuilder();
        String[] split = binary.split(" ");
        for (String s : split) {
            str.append((char) Integer.parseInt(s, 2));
        }
        return str.toString();
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



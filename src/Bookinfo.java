import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Bookinfo {
    
    @FXML
    private TextField count;

    @FXML
    private DatePicker daypuli;

    @FXML
    private TextField kind;

    @FXML
    private TextField nameauthor;

    @FXML
    private TextField namebook;

    @FXML
    private TextField price;
    @FXML
    public void Create(ActionEvent event) throws IOException {
        String[] bookInfo = new String[5];
        bookInfo[0] = count.getText();
        bookInfo[1] = daypuli.getPromptText();
        bookInfo[2] = kind.getText();
        bookInfo[3] = nameauthor.getText();
        bookInfo[4] = namebook.getText();
        bookInfo[5] = price.getText();
        
        saveToFile(bookInfo);

        Parent NewGuestInterface = FXMLLoader.load(getClass().getResource("Create1.fxml"));
        Scene NewGuestScene = new Scene(NewGuestInterface); 
        Stage window = (Stage)((Button) event.getSource()).getScene().getWindow(); 
        window.setScene(NewGuestScene);
        window.show();
    }

    private void saveToFile(String[] guestInfo){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BookInfo.dat", true))) {
            for (String info : guestInfo) {
                writer.write(info);
            }
        } catch (IOException e){}
    }
    
   
}


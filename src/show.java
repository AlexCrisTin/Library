import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class show implements Initializable{
    @FXML
    private TableView<availableBooks> table;

    @FXML
    private TableColumn<availableBooks, String> author;
    
    @FXML
    private TableColumn<availableBooks, String> kind;

    @FXML
    private TableColumn<availableBooks, String> namebook;

    @FXML
    private TableColumn<availableBooks, String> view;

    private ObservableList<availableBooks> books;
    
    public void initialize(URL location, ResourceBundle resources){
        books = FXCollections.observableArrayList(
    new availableBooks("Book1", "Author1", "Kind1", "View1"),
    new availableBooks("Book2", "Author2", "Kind2", "View2")
    
);
        namebook.setCellValueFactory(new PropertyValueFactory<availableBooks, String>("namebook"));
        kind.setCellValueFactory(new PropertyValueFactory<availableBooks, String>("kind"));
        author.setCellValueFactory(new PropertyValueFactory<availableBooks, String>("author"));
        view.setCellValueFactory(new PropertyValueFactory<availableBooks, String>("view"));
        table.setItems(books);
    }

    public void initialize(ObservableList<availableBooks> books2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }
    
}


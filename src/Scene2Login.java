import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Scene2Login {
    @FXML
    Label nameLabel;

    public void displayName(String username){
        nameLabel.setText(username);
    }
}

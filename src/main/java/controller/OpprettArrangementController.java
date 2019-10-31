package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Arrangement;

import java.io.IOException;

public class OpprettArrangementController {

    @FXML
    private Button ferdigButton;

    @FXML
    private TextField tittelTextField;

    public void tilbakeFraOpprettArrangement(ActionEvent event) throws IOException {
        Parent brukerParent = FXMLLoader.load(getClass().getResource("/adminside.fxml"));
        Scene brukerScene = new Scene(brukerParent);
        Stage vindu = (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(brukerScene);
        vindu.show();
    }

    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

            /*Ha dette i en if-test som sjekker om returen på erTittelOk*/
            Arrangement.erTittelOk(tittelTextField.getText());

        }
    };

    @FXML
    private void initialize(){
        ferdigButton.setOnAction(event);
    }

}

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartsideController {

    public void byttTilBrukerScene(ActionEvent event) throws IOException {
        visFXML(event, "/brukerside.fxml");
    }

    public void byttTilAdminScene(ActionEvent event) throws IOException {
        visFXML(event,"/adminside.fxml");
    }

    public void byttTilGjestScene(ActionEvent event) throws IOException {
        visFXML(event,"/gjestside.fxml");
    }


    private void visFXML (ActionEvent event, String fxml){
        Parent brukerParent = null;
        try {
            brukerParent = FXMLLoader.load(getClass().getResource(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert brukerParent != null;
        Scene brukerScene = new Scene(brukerParent);
        Stage vindu = (Stage) ((Node) event.getSource()).getScene().getWindow();
        vindu.setScene(brukerScene);
        vindu.show();
    }
}

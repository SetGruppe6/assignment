package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;

public class OpprettArrangementController {

    @FXML
    private Button ferdigButton;

    @FXML
    private TextField tittelTextField;

    @FXML
    private TextField stedTextField;

    @FXML
    private TextField startTextField;

    @FXML
    private TextField sluttTextField;

    @FXML
    private TextField kapasitetTextField;

    @FXML
    private ComboBox<String> typeTextField;

    @FXML
    private ComboBox<Distanse> distanseTextField;

    Alert opprettAlert = new Alert(Alert.AlertType.INFORMATION);

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

            /*Midlertidig løsning. Burde kanskje bruke stringbuilder her?
            * Nå får den resultatet fra metodene, og om den går igjennom metoden uten
            * feil returneres "". Om den ikke går gjennom uten feil, legges
            * feilmeldingen til og printes i en alert-box så man vet hvilke felter man har misset
            *
            * mangler noe implementasjon på feltene.*/
            StringBuilder resultat = new StringBuilder();
            //String resultat = "";

            resultat.append("\n").append(Arrangement.erTittelOk(tittelTextField.getText()));
            resultat.append("\n").append(Arrangement.erLokasjonGitt(stedTextField.getText()));
            resultat.append("\n").append(Arrangement.erTidsromGitt(startTextField.getText(), sluttTextField.getText()));
            resultat.append("\n").append(Arrangement.erDeltakerKapasitetOk(Integer.parseInt(kapasitetTextField.getText())));

            /**resultat += "\n"+Arrangement.erTittelOk(tittelTextField.getText());
            resultat += "\n"+Arrangement.erLokasjonGitt(stedTextField.getText());
            resultat += "\n"+Arrangement.erTidsromGitt(startTextField.getText(), sluttTextField.getText());
            resultat += "\n"+Arrangement.erDeltakerKapasitetOk(Integer.parseInt(kapasitetTextField.getText()));**/


            if (resultat.toString().isEmpty()) {
                opprettAlert.setTitle("Advarsel");
                opprettAlert.setHeaderText("Det er noen feil i skjemaet.");
                opprettAlert.setContentText(resultat.toString());
                opprettAlert.showAndWait();
            }else {
                opprettAlert.setTitle("");
                opprettAlert.setHeaderText("Arrangement opprettet");
                opprettAlert.setContentText("Ditt arrangement:\n" + tittelTextField.getText() + "\ner opprettet");
                opprettAlert.showAndWait();
            }
        }
    };

    @FXML
    private void initialize(){
        ferdigButton.setOnAction(event);

        typeTextField.getItems().addAll("Sykkel", "Ski", "Springe");
        typeTextField.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                distanseTextField.getItems().removeAll(distanseTextField.getItems());

                if(newValue == "Sykkel") {
                    Sykkel.fyllDistanseListe();
                    for(int i = 0; i < Sykkel.getSykkelAvstander().length; i++) {
                        distanseTextField.getItems().add(Sykkel.getSykkelAvstander()[i]);
                    }
                } else if(newValue == "Ski") {
                    Ski.fyllDistanseListe();
                    for(int i = 0; i < Ski.getSkiAvstander().length; i++) {
                        distanseTextField.getItems().add(Ski.getSkiAvstander()[i]);
                    }
                } else if(newValue == "Springe") {
                    Lop.fyllDistanseListe();
                    for(int i = 0; i < Lop.getLopsAvstander().length; i++) {
                        distanseTextField.getItems().add(Lop.getLopsAvstander()[i]);
                    }
                }
            }
        });
    }

}

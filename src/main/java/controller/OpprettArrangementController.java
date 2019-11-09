package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OpprettArrangementController {

    @FXML
    private TextField tittelTextField;

    @FXML
    private DatePicker datoTextField;

    @FXML
    private TextField stedTextField;

    @FXML
    private TextField startTextField;

    @FXML
    private TextField sluttTextField;

    @FXML
    private TextField kapasitetTextField;

    @FXML
    private TextField prisTextField;

    @FXML
    private TextArea beskrivelseTextArea;

    @FXML
    private Button ferdigButton;

    @FXML
    private Button avbrytButton;

    @FXML
    private ComboBox<String> typeTextField;

    @FXML
    private ComboBox<Distanse> distanseTextField;

    @FXML
    private Label tittelLable;

    @FXML
    private Label typeLabel;

    @FXML
    private Label distanseLabel;

    @FXML
    private Label datoLabel;

    @FXML
    private Label stedLabel;

    @FXML
    private Label startLabel;

    @FXML
    private Label sluttLabel;

    @FXML
    private Label kapasitetLabel;

    @FXML
    private Label prisLabel;


    Alert opprettAlert = new Alert(Alert.AlertType.INFORMATION);

    public void avbrytOpprettArrangement(ActionEvent event) { returnerTilAdminSide(event); }

    @FXML
    void opprettArrangement(ActionEvent event)  {
        String tittel = tittelTextField.getText();
        String sted = stedTextField.getText();
        LocalDate dato = datoTextField.getValue();
        LocalTime startTid = LocalTime.parse(startTextField.getText(),DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTime sluttTid = LocalTime.parse(sluttTextField.getText(),DateTimeFormatter.ISO_LOCAL_TIME);
        int deltakerKapasitet = Integer.parseInt(kapasitetTextField.getText());
        int paameldingAvgift = Integer.parseInt(prisTextField.getText());
        String beskrivelse = beskrivelseTextArea.getText();
        Distanse distanse = distanseTextField.getValue();

        if(typeTextField.getSelectionModel().getSelectedItem() == "Sykkel") {
            Sykkel sykkelLop = new Sykkel(tittel,sted,dato,startTid,sluttTid,deltakerKapasitet,paameldingAvgift,beskrivelse,new ArrayList<>(),distanse);
            Arrangement.leggTilArrangement(sykkelLop);
        }
        else if(typeTextField.getSelectionModel().getSelectedItem() == "Ski") {
            Ski skiLop = new Ski(tittel,sted,dato,startTid,sluttTid,deltakerKapasitet,paameldingAvgift,beskrivelse,new ArrayList<>(),distanse);
            Arrangement.leggTilArrangement(skiLop);
        }
        else if(typeTextField.getSelectionModel().getSelectedItem() == "Springe") {
            Lop lop = new Lop(tittel,sted,dato,startTid,sluttTid,deltakerKapasitet,paameldingAvgift,beskrivelse,new ArrayList<>(),distanse);
            Arrangement.leggTilArrangement(lop);
        }

        returnerTilAdminSide(event);
    }

    private void returnerTilAdminSide(ActionEvent event)  {
        Parent brukerParent = null;

        try {
            brukerParent = FXMLLoader.load(getClass().getResource("/adminside.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            opprettAlert.setTitle("Error: innlasting av adminside feilet");
            opprettAlert.setHeaderText("Noe gikk galt!");
            opprettAlert.setContentText("Kunne ikke laste inn adminside! Kontakt systemadministrator");
            opprettAlert.showAndWait();
        }
        Scene brukerScene = new Scene(brukerParent);
        Stage vindu = (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(brukerScene);
        vindu.show();

    }

    private void intputValidering(Arrangement arrangement) {
        arrangement.erDatoOK(arrangement.getDato());
        arrangement.erDeltakerKapasitetOk(arrangement.getDeltakerKapasitet());
        arrangement.erLokasjonGitt(arrangement.getLokasjon());
        arrangement.erPrisGitt(arrangement.getPameldingsAvgift());
        arrangement.erStartTidspunktOk(arrangement.getStartTid(), arrangement.getSluttTid());
        arrangement.erTittelOk(arrangement.getNavn());
    }

    /**EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

            /*Midlertidig løsning. Burde kanskje bruke stringbuilder her?
            * Nå får den resultatet fra metodene, og om den går igjennom metoden uten
            * feil returneres "". Om den ikke går gjennom uten feil, legges
            * feilmeldingen til og printes i en alert-box så man vet hvilke felter man har misset
            *
            * mangler noe implementasjon på feltene.*/
            /**StringBuilder resultat = new StringBuilder();
            //String resultat = "";

            //resultat.append("\n").append(this.Arrangement.erTittelOk(tittelTextField.getText()));
            resultat.append("\n").append(Arrangement.erLokasjonGitt(stedTextField.getText()));
            resultat.append("\n").append(Arrangement.erTidsromGitt(startTextField.getText(), sluttTextField.getText()));
            resultat.append("\n").append(Arrangement.erDeltakerKapasitetOk(Integer.parseInt(kapasitetTextField.getText())));


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
    };**/

    @FXML
    private void initialize(){
        //ferdigButton.setOnAction(event);

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

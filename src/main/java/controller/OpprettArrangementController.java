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
    private Label kapasitetLbl;

    @FXML
    private Label prisLbl;

    @FXML
    private Label beskrivelseLbl;

    Alert opprettAlert = new Alert(Alert.AlertType.INFORMATION);


    public void avbrytOpprettArrangement(ActionEvent event) {
        returnerTilAdminSide(event);
    }

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
        Lag laget = new Lag("Tufte");

        if(typeTextField.getSelectionModel().getSelectedItem() == "Sykkel") {
            Sykkel sykkelLop = new Sykkel(tittel,sted,dato,startTid,sluttTid,deltakerKapasitet,paameldingAvgift,beskrivelse,new ArrayList<>(),distanse);
            if(!intputValidering(sykkelLop).isEmpty()) {
                setFeilMeldinger(sykkelLop);
            } else {
                Arrangement.leggTilArrangement(sykkelLop);
                returnerTilAdminSide(event);
            }
        }
        else if(typeTextField.getSelectionModel().getSelectedItem() == "Ski") {
            Ski skiLop = new Ski(tittel,sted,dato,startTid,sluttTid,deltakerKapasitet,paameldingAvgift,beskrivelse,new ArrayList<>(),distanse);
            if(!intputValidering(skiLop).isEmpty()) {
                setFeilMeldinger(skiLop);
            } else {
                Arrangement.leggTilArrangement(skiLop);
                returnerTilAdminSide(event);
            }
        }
        else if(typeTextField.getSelectionModel().getSelectedItem() == "Springe") {
            Lop lop = new Lop(tittel,sted,dato,startTid,sluttTid,deltakerKapasitet,paameldingAvgift,beskrivelse,new ArrayList<>(),distanse);
            if(!intputValidering(lop).isEmpty()) {
                setFeilMeldinger(lop);
            } else {
                Arrangement.leggTilArrangement(lop);
                returnerTilAdminSide(event);
            }
        }


        AdminController.adminController.getArrangementListView().getSelectionModel().selectLast();


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

    private String intputValidering(Arrangement arrangement) {
        StringBuilder inputResulat = new StringBuilder();
        //inputResulat.append(arrangement.erDatoOK(arrangement.getDato()));
        inputResulat.append(arrangement.erDeltakerKapasitetOk(arrangement.getDeltakerKapasitet()));
        inputResulat.append(arrangement.erLokasjonGitt(arrangement.getLokasjon()));
        inputResulat.append(arrangement.erPrisGitt(arrangement.getPameldingsAvgift()));
        inputResulat.append(arrangement.erStartTidspunktOk(arrangement.getStartTid(), arrangement.getSluttTid()));
        inputResulat.append(arrangement.erTittelOk(arrangement.getNavn()));
        inputResulat.append(arrangement.erBeskrivelseGitt(arrangement.getBeskrivelse()));
        if(typeTextField.getSelectionModel().isEmpty()) {
            inputResulat.append("Velg hvilken type arrangement");
        }
        else if(distanseTextField.getSelectionModel().isEmpty()) {
            inputResulat.append("Velg en type distanse");
        }


        return inputResulat.toString();
    }

    private void setFeilMeldinger(Arrangement arrangement) {
        String tittel = tittelTextField.getText();
        String sted = stedTextField.getText();
        LocalDate dato = datoTextField.getValue();
        LocalTime startTid = LocalTime.parse(startTextField.getText(),DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTime sluttTid = LocalTime.parse(sluttTextField.getText(),DateTimeFormatter.ISO_LOCAL_TIME);
        int deltakerKapasitet = Integer.parseInt(kapasitetTextField.getText());
        int paameldingAvgift = Integer.parseInt(prisTextField.getText());
        String beskrivelse = beskrivelseTextArea.getText();
        Distanse distanse = distanseTextField.getValue();

        tittelLable.setText(arrangement.erTittelOk(tittel));
        //datoLabel.setText(sykkelLop.erDatoOK(dato));
        kapasitetLbl.setText(arrangement.erDeltakerKapasitetOk(deltakerKapasitet));
        prisLbl.setText(arrangement.erPrisGitt(paameldingAvgift));
        stedLabel.setText(arrangement.erLokasjonGitt(sted));
        beskrivelseLbl.setText(arrangement.erBeskrivelseGitt(beskrivelse));
        startLabel.setText(arrangement.erStartTidspunktOk(startTid,sluttTid));
    }

    private void tomFeilmeldinger() {
        tittelLable.setText("");
        //datoLabel.setText(sykkelLop.erDatoOK(dato));
        kapasitetLbl.setText("");
        prisLbl.setText("");
        stedLabel.setText("");
        beskrivelseLbl.setText("");
        startLabel.setText("");
        typeLabel.setText("");
        distanseLabel.setText("");
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
                    tomFeilmeldinger();
                } else if(newValue == "Ski") {
                    Ski.fyllDistanseListe();
                    for(int i = 0; i < Ski.getSkiAvstander().length; i++) {
                        distanseTextField.getItems().add(Ski.getSkiAvstander()[i]);
                    }
                    tomFeilmeldinger();
                } else if(newValue == "Springe") {
                    Lop.fyllDistanseListe();
                    for(int i = 0; i < Lop.getLopsAvstander().length; i++) {
                        distanseTextField.getItems().add(Lop.getLopsAvstander()[i]);
                    }
                    tomFeilmeldinger();
                }
            }
        });
    }

}

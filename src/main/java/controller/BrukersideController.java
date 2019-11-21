package controller;

import View.Main;
import datahandler.Datahandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Arrangement;
import model.Lop;
import model.Ski;
import model.Sykkel;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class BrukersideController implements Initializable {

    @FXML
    private ListView<Arrangement> arrangementListView;

    @FXML
    private Button meldPaaButton;

    @FXML
    private Label tittelLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label datoLabel;

    @FXML
    private Label adresseLabel;

    @FXML
    private Label tidsromLabel;

    @FXML
    private Label kapasitetLabel;

    @FXML
    private Label prisLabel;

    @FXML
    private ImageView bildeImageView;

    @FXML
    private ComboBox<String> sorteringComboBox;

    @FXML
    private Label antallPaameldte;

    @FXML
    private Label velkomstLabel;

    public static BrukersideController brukersideController;
    public BrukersideController(){
        brukersideController = this; }

    public void gaaTilbake(ActionEvent event) {
        visFXML(event,"/startside.fxml");
    }

    public int prisforBrukerArrangement(){
        return arrangementListView.getSelectionModel().getSelectedItem().getPameldingsAvgift();
    }

    public void meldpaa_bruker(ActionEvent event) {
        visFXML(event,"/meldpaaBruker.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StringBuilder velkomst = new StringBuilder();
        velkomst.append("Velkommen ").append(Main.getApplication().getDummyBruker().getBrukernavn());
        velkomstLabel.setText(velkomst.toString());

        sorteringComboBox.getItems().addAll("Kommende arrangementer", "Avsluttede arrangementer","Paameldte arrangementer");
        arrangementListView.setItems(Datahandler.getArrangementListe());

        sorteringComboBox.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if(newValue == "Kommende arrangementer") {
                    arrangementListView.setItems(Datahandler.setArrangementListe(Datahandler.filtrerPaaDatoKommende(Datahandler.getArrangementer())));
                    meldPaaButton.setDisable(false);

                }
                else if(newValue == "Avsluttede arrangementer") {
                    arrangementListView.setItems(Datahandler.setArrangementListe(Datahandler.filtrerPaaAvsluttede(Datahandler.getArrangementer())));
                    meldPaaButton.setDisable(true);
                }
                else if(newValue == "Paameldte arrangementer") {
                    try {
                        arrangementListView.setItems(Datahandler.setArrangementListe(Main.getApplication().getDummyBruker().getArrangementerPersonErPameldt()));
                    } catch (NullPointerException nullify) {
                        Alert feil = new Alert(Alert.AlertType.ERROR);
                        feil.setHeaderText("ERROR: Listen er tom");
                        feil.setContentText("Listen er tom, ikke mulig aa vise arrangementene");
                        feil.showAndWait();
                        sorteringComboBox.getSelectionModel().selectFirst();
                    }

                    meldPaaButton.setDisable(false);
                }
                arrangementListView.getSelectionModel().selectFirst();
                arrangementListView.refresh();
            }
        });

        // oppdaterer variabler som tittel osv når man trykker på de ulike arrangementene
        arrangementListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Arrangement>() {
            @Override
            public void changed(ObservableValue<? extends Arrangement> observableValue, Arrangement arrangement, Arrangement ny) {

                if (!arrangementListView.getSelectionModel().isEmpty()) {
                    String formatet = "dd.MM.yyyy";
                    DateTimeFormatter datoFormatering = DateTimeFormatter.ofPattern(formatet);

                    tittelLabel.setText(ny.getNavn());
                    datoLabel.setText(datoFormatering.format(ny.getDato()));
                    adresseLabel.setText(ny.getLokasjon());
                    tidsromLabel.setText(ny.getStartTid() + " - " + ny.getSluttTid());
                    kapasitetLabel.setText(String.valueOf(ny.getDeltakerKapasitet()));
                    prisLabel.setText(String.valueOf(ny.getPameldingsAvgift()));
                    descriptionLabel.setText(ny.getBeskrivelse());

                    StringBuilder kapasitet = new StringBuilder();
                    kapasitet.append("Antall paameldte: ").append(ny.getDeltakere().size()).append(" / ").append(ny.getDeltakerKapasitet());
                    antallPaameldte.setText(kapasitet.toString());

                    // Ulike ikoner som samsvarer med arrangementets instans (ski, sykkel, lop)
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            if (ny instanceof Sykkel) {
                                Image image = new Image("/sykkel.png");
                                bildeImageView.setImage(image);
                            } else if (ny instanceof Ski) {
                                Image image = new Image("/ski.png");
                                bildeImageView.setImage(image);
                            } else if (ny instanceof Lop) {
                                Image image = new Image("/lop.png");
                                bildeImageView.setImage(image);
                            }
                        }
                    };
                    Thread bilde = new Thread(runnable);
                    bilde.start();
                } else if(arrangementListView.getSelectionModel().isEmpty()) {
                    tittelLabel.setText("");
                    datoLabel.setText("");
                    adresseLabel.setText("");
                    tidsromLabel.setText("");
                    kapasitetLabel.setText("");
                    prisLabel.setText("");
                    descriptionLabel.setText("");
                }
            }
        });

        sorteringComboBox.getSelectionModel().selectFirst();
    }


    public ListView<Arrangement> getArrangementListView() {
        return arrangementListView;
    }
  
    //Avmelder Brukeren som er paameldt
    public void avmeldFraArrangement(ActionEvent event) {
        Arrangement valgt = arrangementListView.getSelectionModel().getSelectedItem();

        if(valgt.getDeltakere().contains(Main.getApplication().getDummyBruker())) {
            valgt.fjernDeltaker(Main.getApplication().getDummyBruker());
            Main.getApplication().getDummyBruker().meldAvArrangement(valgt);
        }

        //Oppdaterer listen
        if(sorteringComboBox.getSelectionModel().isSelected(2)) {
            sorteringComboBox.getSelectionModel().selectFirst();
        }

        //Unselect og select for å oppdatere antall deltakere
        arrangementListView.getSelectionModel().select(-1);
        arrangementListView.getSelectionModel().select(valgt);


    }

    //Metode for å bytte fxml sider
    private void visFXML(ActionEvent event,String fxml) {
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

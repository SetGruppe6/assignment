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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    private Label velkommenLbl;

    @FXML
    private ListView<Arrangement> arrangementListView;

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
    private Button meldPaaButton;

    @FXML
    private Label antallPaameldte;

    @FXML
    private ComboBox<Person> deltakereComboBox;

    @FXML
    private ComboBox<String> sorteringComboBox;

    private ArrayList<Person> personer = new ArrayList<>();


    public static AdminController adminController;
    public AdminController() {adminController = this;}

    public void gaaTilbake(ActionEvent event) {
        visFXML(event,"/startside.fxml");
    }

    public void opprettArrangement(ActionEvent event)  {
        visFXML(event,"/opprettarrangement.fxml");
    }

    public void meldPaa (ActionEvent event) {
        visFXML(event,"/meldpaa.fxml");
    }

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle){
        StringBuilder velkommen = new StringBuilder();
        velkommen.append("Velkommen ").append(Main.getApplication().getTufte().getNavn());
        velkommenLbl.setText(velkommen.toString());
        deltakereComboBox.getItems().addAll(personer);
        sorteringComboBox.getItems().addAll("Kommende arrangementer", "Avsluttede arrangementer","Paameldte arrangementer");

        sorteringComboBox.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if(newValue == "Kommende arrangementer") {
                    arrangementListView.setItems(Datahandler.setArrangementListe(Datahandler.filtrerPaaDatoKommende()));
                    meldPaaButton.setDisable(false);

                }
                else if(newValue == "Avsluttede arrangementer") {
                    arrangementListView.setItems(Datahandler.setArrangementListe(Datahandler.filtrerPaaAvsluttede()));
                    meldPaaButton.setDisable(true);
                }
                else if(newValue == "Paameldte arrangementer") {
                    MeldPaaController mpc = new MeldPaaController();
                    arrangementListView.setItems(Datahandler.setArrangementListe(Main.getApplication().getTufte().paameldteArrangementer(Datahandler.getArrangementer())));
                    meldPaaButton.setDisable(false);
                }
                arrangementListView.getSelectionModel().selectFirst();
            }
        });

        arrangementListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Arrangement>() {
            @Override
            public void changed(ObservableValue<? extends Arrangement> observableValue, Arrangement old, Arrangement ny) {

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
                    deltakereComboBox.getItems().removeAll(deltakereComboBox.getItems());
                    deltakereComboBox.getItems().addAll(ny.getDeltakere());
                    deltakereComboBox.getSelectionModel().selectFirst();

                    StringBuilder kapasitet = new StringBuilder();
                    kapasitet.append("Antall paameldte: ").append(ny.getDeltakere().size()).append(" / ").append(ny.getDeltakerKapasitet());
                    antallPaameldte.setText(kapasitet.toString());


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
        arrangementListView.refresh();
    }

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

    public ListView<Arrangement> getArrangementListView() {
        return arrangementListView;
    }


}

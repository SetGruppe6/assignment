package controller;

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
import model.*;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class GjestsideController implements Initializable {

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
    private ComboBox<Person> deltakereComboBox;

    @FXML
    private ComboBox<String> sorteringComboBox;


    public static GjestsideController gjestsideController;
    public GjestsideController() {gjestsideController = this;}

    AdminController adminController = new AdminController();


    public int prisforarr(){
        return arrangementListView.getSelectionModel().getSelectedItem().getPameldingsAvgift();
    }

    public void gaaTilbake(ActionEvent event) throws IOException {

        Parent brukerParent = FXMLLoader.load(getClass().getResource("/startside.fxml"));
        Scene brukerScene = new Scene(brukerParent);
        Stage vindu = (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(brukerScene);
        vindu.show();
    }


    public void meldpaa_gjest(ActionEvent event) throws IOException {
        Parent brukerParent = FXMLLoader.load(getClass().getResource("/meldpaaGjest.fxml"));
        Scene brukerScene = new Scene(brukerParent);
        Stage vindu = (Stage) ((Node) event.getSource()).getScene().getWindow();
        vindu.setScene(brukerScene);
        vindu.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sorteringComboBox.getItems().addAll("Kommende arrangementer", "Avsluttede arrangementer","Paameldte arrangementer");
        arrangementListView.setItems(Datahandler.getArrangementListe());

        sorteringComboBox.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if(newValue == "Kommende arrangementer") {
                    arrangementListView.setItems(Datahandler.setArrangementListe(Arrangement.filtrerPaaDatoKommende()));
                    meldPaaButton.setDisable(false);

                }
                else if(newValue == "Avsluttede arrangementer") {
                    arrangementListView.setItems(Datahandler.setArrangementListe(Arrangement.filtrerPaaAvsluttede()));
                    meldPaaButton.setDisable(true);
                }
                else if(newValue == "Paameldte arrangementer") {
                    try {
                        arrangementListView.setItems(Datahandler.setArrangementListe(MeldPaaGjestController.meldPaaGjestController.getGjestMedlem()));
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
                    deltakereComboBox.getItems().removeAll(deltakereComboBox.getItems());
                    deltakereComboBox.getItems().addAll(ny.getDeltakere());

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

    public Label getPrisLabel() {
        return prisLabel;
    }

    public ListView<Arrangement> getArrangementListView() {
        return arrangementListView;
    }
}

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Arrangement;
import model.Person;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GjestsideController implements Initializable {

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
    private ComboBox<Person> deltakereComboBox;

    public static GjestsideController gjestsideController;
    public GjestsideController() {gjestsideController = this;}

    AdminController adminController = new AdminController();


    public ArrayList<Person> getGjester(){
       return arrangementListView.getSelectionModel().getSelectedItem().getDeltakere();
    }

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
        arrangementListView.setItems(Datahandler.getArrangementListe());

        arrangementListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Arrangement>() {
            @Override
            public void changed(ObservableValue<? extends Arrangement> observableValue, Arrangement arrangement, Arrangement ny) {
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
            }
        });
    }

    public Label getPrisLabel() {
        return prisLabel;
    }
}

package controller;

import datahandler.Datahandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Arrangement;

import java.io.IOException;

public class AdminController {

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


    public void gaaTilbake(ActionEvent event) throws IOException {
        Parent brukerParent = FXMLLoader.load(getClass().getResource("/startside.fxml"));
        Scene brukerScene = new Scene(brukerParent);
        Stage vindu = (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(brukerScene);
        vindu.show();
    }

    @FXML
    private void initialize(){

        arrangementListView.setItems(Datahandler.arrangementData());


        arrangementListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Arrangement>() {
            @Override
            public void changed(ObservableValue<? extends Arrangement> observableValue, Arrangement old, Arrangement ny) {
                if (arrangementListView != null){
                    tittelLabel.setText(ny.getNavn());
                    datoLabel.setText(ny.getDato());
                    adresseLabel.setText(ny.getLokasjon());
                    tidsromLabel.setText(ny.getStartTid() + " - " + ny.getSluttTid());
                    kapasitetLabel.setText(String.valueOf(ny.getDeltakerKapasitet()));
                    prisLabel.setText(String.valueOf(ny.getPåmeldingsAvgift()));
                    descriptionLabel.setText(ny.getBeskrivelse());

                }
            }
        });

        arrangementListView.getSelectionModel().selectFirst();

    }


}

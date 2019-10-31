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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Arrangement;
import model.Lop;
import model.Ski;
import model.Sykkel;

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

    @FXML
    private ImageView bildeImageView;


    public void gaaTilbake(ActionEvent event) throws IOException {
        Parent brukerParent = FXMLLoader.load(getClass().getResource("/startside.fxml"));
        Scene brukerScene = new Scene(brukerParent);
        Stage vindu = (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(brukerScene);
        vindu.show();
    }

    public void opprettArrangement(ActionEvent event) throws IOException {
        Parent brukerParent = FXMLLoader.load(getClass().getResource("/opprettarrangement.fxml"));
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


                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            if (ny instanceof Sykkel){
                                Image image = new Image("https://cdn0.iconfinder.com/data/icons/bicycle-19/64/road-bike-bicycle-bike-riding-512.png");
                                bildeImageView.setImage(image);
                            }
                            else if (ny instanceof Ski){
                                Image image = new Image("https://image.flaticon.com/icons/png/512/94/94150.png");
                                bildeImageView.setImage(image);
                            }
                            else if (ny instanceof Lop){
                                Image image = new Image("https://cdn4.iconfinder.com/data/icons/misc-vol-2/512/man_person_run_runner_running-512.png");
                                bildeImageView.setImage(image);
                            }
                        }
                    };
                    Thread bilde = new Thread(runnable);
                    bilde.start();
                }
            }
        });

        arrangementListView.getSelectionModel().selectFirst();

    }


}

package controller;

import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Arrangement;
import model.Betaling;
import model.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MeldPaaBrukerController implements Initializable {

    @FXML
    private ImageView vippsImageView;

    @FXML
    private ImageView visaImageView;

    @FXML
    private Label betalLabel;

    private boolean betalt = false;


    public static MeldPaaBrukerController meldPaaBrukerController;
    public MeldPaaBrukerController() {meldPaaBrukerController = this; }

    Betaling betaling = new Betaling(betalt);



    public void betaltVipps(MouseEvent mouseEvent) {
        betaling.harBetalt();
        betaltText();
    }

    public void betaltText(){
        betalLabel.setText("Du har naa betalt for arrangementet!");
    }

    public void betaltVisa(MouseEvent mouseEvent) {
        betaling.harBetalt();
        betaltText();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image vipps = new Image("/vipps.png");
        Image visa = new Image("/visa.png");
        visaImageView.setImage(visa);
        vippsImageView.setImage(vipps);
    }

    public void brukerErMeldtPaa(ActionEvent event) {
        Arrangement deltakere = BrukersideController.brukersideController.getArrangementListView().getSelectionModel().getSelectedItem();
        ArrayList<Person> listeBruker = BrukersideController.brukersideController.getBrukere();

        if (betaling.isBetalt() || BrukersideController.brukersideController.prisforBrukerArrangement() <= 0) {

            if (!deltakere.getDeltakere().contains(Main.getApplication().getDummyBruker())) {
                deltakere.leggTilDeltaker(Main.getApplication().getDummyBruker());
            }
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/brukerside.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                System.out.println(e);
            }
            Parent p = fxmlLoader.getRoot();
            Scene scene = new Scene(p);
            Stage vindu = (Stage) ((Node) event.getSource()).getScene().getWindow();
            vindu.setScene(scene);
            vindu.show();
        }else{
            betalLabel.setText("Du maa betale foer du kan registere deg. Vennligst velg betalingsmetode under:");
        }
    }

    public void gaaTilbake(ActionEvent event) throws IOException {

        Parent brukerParent = FXMLLoader.load(getClass().getResource("/brukerside.fxml"));
        Scene brukerScene = new Scene(brukerParent);
        Stage vindu = (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(brukerScene);
        vindu.show();
    }

    /*public ArrayList<Arrangement> getDummyMedlem() {
        return dummyBruker.getArrangementerPersonErPameldt();
    }*/
}

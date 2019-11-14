package controller;

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

    Betaling betaling = new Betaling(betalt);


    public void betaltVipps(MouseEvent mouseEvent) {
        betaling.harBetalt();
        betaltText();
    }

    public void betaltText(){
        betalLabel.setText("Du har nå betalt for arrangementet!");
    }

    public void betaltVisa(MouseEvent mouseEvent) {
        betaling.harBetalt();
        betaltText();
    }

    Person dummyBruker = new Person("Ola", "Normann");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image vipps = new Image("/vipps.png");
        Image visa = new Image("/visa.png");
        visaImageView.setImage(visa);
        vippsImageView.setImage(vipps);
    }

    public void brukerErMeldtPaa(ActionEvent event) {

        ArrayList<Person> listeBruker = BrukersideController.brukersideController.getBrukere();

        if (betaling.isBetalt() == true || BrukersideController.brukersideController.prisforBrukerArrangement() <= 0) {

            if (!listeBruker.contains(dummyBruker)) {
                listeBruker.add(dummyBruker);
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
            betalLabel.setText("Du må betale før du kan registere deg. Vennligst velg betalingsmetode under :)");
        }
    }

    public void gaaTilbake(ActionEvent event) throws IOException {

        Parent brukerParent = FXMLLoader.load(getClass().getResource("/brukerside.fxml"));
        Scene brukerScene = new Scene(brukerParent);
        Stage vindu = (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(brukerScene);
        vindu.show();
    }
}

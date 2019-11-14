package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Arrangement;
import model.Betaling;
import model.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MeldPaaGjestController implements Initializable {

    @FXML
    private ImageView vippsImageView;

    @FXML
    private ImageView visaImageView;

    @FXML
    private TextField fornavnTextField;

    @FXML
    private TextField etternavnTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Label betalLabel;

    private boolean betalt = false;
    Betaling betaling = new Betaling(betalt);

    String fornavn;
    String etternavn;
    String email;
    Person gjestMedlem;

    public static MeldPaaGjestController meldPaaGjestController;
    public MeldPaaGjestController() {meldPaaGjestController=this;}


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image vipps = new Image("/vipps.png");
        Image visa = new Image("/visa.png");
        visaImageView.setImage(visa);
        vippsImageView.setImage(vipps);
    }

    public void gjestErMeldtPaa(ActionEvent event) {
        gjestMedlem = new Person(fornavn,etternavn,email,new ArrayList<>());
        Arrangement valgtArrangement = GjestsideController.gjestsideController.getArrangementListView().getSelectionModel().getSelectedItem();

        if(betaling.isBetalt() == true || GjestsideController.gjestsideController.prisforarr() <= 0) {
            if (!valgtArrangement.getDeltakere().contains(gjestMedlem)) {
                valgtArrangement.leggTilDeltaker(gjestMedlem);
                gjestMedlem.setArrangementerPersonErPameldt(valgtArrangement);
            }
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/gjestside.fxml"));
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
        }else {
            betalLabel.setText("Du må betale før du kan registere deg. Vennligst velg betalingsmetode under :)");
        }

    }

    public void gaaTilbake(ActionEvent event) throws IOException {

        Parent brukerParent = FXMLLoader.load(getClass().getResource("/gjestside.fxml"));
        Scene brukerScene = new Scene(brukerParent);
        Stage vindu = (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(brukerScene);
        vindu.show();
    }

    public void etternavnKey(KeyEvent keyEvent) {
        etternavn = etternavnTextField.getText();
    }

    public void emailKey(KeyEvent keyEvent) {
        email = emailTextField.getText();
    }

    public void fornavnKey(KeyEvent keyEvent) {
        fornavn = fornavnTextField.getText();
    }

    public ArrayList<Arrangement> getGjestMedlem() {
        return gjestMedlem.getArrangementerPersonErPameldt();
    }

}

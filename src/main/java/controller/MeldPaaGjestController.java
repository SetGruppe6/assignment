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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Arrangement;
import model.Betaling;
import model.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
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

    @FXML
    private Label fornavnLabel;

    @FXML
    private Label etternavnLabel;

    @FXML
    private Label emailLabel;

    private boolean betalt = false;
    Betaling betaling = new Betaling(betalt);

    Person gjestMedlem;

    public static MeldPaaGjestController meldPaaGjestController;

    public MeldPaaGjestController() {
        meldPaaGjestController = this;
    }


    public void betaltVipps(MouseEvent mouseEvent) {
        betaling.harBetalt();
        betaltText();
    }

    public void betaltText() {
        betalLabel.setText("Du har naa betalt for arrangementet!");
    }

    public void betaltVisa(MouseEvent mouseEvent) {
        betaling.harBetalt();
        betaltText();
    }

    private String inputValideringGjest(Person person) {
        StringBuilder inputResultat = new StringBuilder();
        inputResultat.append(person.erFornavnGitt(person.getFornavn()));
        inputResultat.append(person.erEtternavnGitt(person.getEtternavn()));
        inputResultat.append(person.erEmailGitt(person.getEmail()));
        return inputResultat.toString();
    }

    private void setFeilMeldinger(Person person) {
        String fornavn = fornavnTextField.getText();
        String etternavn = etternavnTextField.getText();
        String email = emailTextField.getText();

        fornavnLabel.setText(person.erFornavnGitt(fornavn));
        etternavnLabel.setText(person.erEtternavnGitt(etternavn));
        emailLabel.setText(person.erEmailGitt(email));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image vipps = new Image("/vipps.png");
        Image visa = new Image("/visa.png");
        visaImageView.setImage(visa);
        vippsImageView.setImage(vipps);
    }

    public void gjestErMeldtPaa(ActionEvent event) {
        String fornavn = fornavnTextField.getText();
        String etternavn = etternavnTextField.getText();
        String email = emailTextField.getText();

        gjestMedlem = new Person(fornavn, etternavn, email, Boolean.FALSE, new ArrayList<>());
        Arrangement valgtArrangement = GjestsideController.gjestsideController.getArrangementListView().getSelectionModel().getSelectedItem();

        if (!inputValideringGjest(gjestMedlem).isEmpty()){
            setFeilMeldinger(gjestMedlem);
         if(betaling.isBetalt()) {
             betalLabel.setText("Du maa betale for du kan registere deg. Vennligst velg betalingsmetode under:");
         }
        } else if (inputValideringGjest(gjestMedlem).isEmpty() && betaling.isBetalt()) {
            if (!valgtArrangement.getDeltakere().contains(gjestMedlem)) {
                valgtArrangement.leggTilDeltaker(gjestMedlem);
                gjestMedlem.meldPaaArrangement(valgtArrangement);

                Parent brukerParent = null;
                try {
                    brukerParent = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("gjestside.fxml")));
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
    }

        public void gaaTilbake (ActionEvent event) {
            visFXML(event, "/gjestside.fxml");
        }


    public ArrayList<Arrangement> getGjestMedlem () {
        return gjestMedlem.getArrangementerPersonErPameldt();
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

}


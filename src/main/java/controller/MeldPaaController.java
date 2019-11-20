package controller;

import View.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Arrangement;
import model.Person;

import java.io.IOException;
import java.util.ArrayList;

public class MeldPaaController {

    @FXML
    private ListView<Person> lagspillereListView;

    @FXML
    private ListView<Person> valgteMedlemmerListView;

    @FXML
    private Button leggTilValgtButton;

    @FXML
    private Button fjernValgtButton;

    @FXML
    private Button leggTilFlereButton;

    @FXML
    private Label sendFakturaLabel;

    @FXML
    private Button returnerButton;

    @FXML
    private Button sendFakturaButton;

    public static MeldPaaController meldPaaController;
    public MeldPaaController() {meldPaaController = this;};


    //ObservableList som holder på alle medlemmene fra tufte.
    private ArrayList<Person> medlemmerTufte = new ArrayList<Person>(Main.getApplication().getTufte().getMedlemmer());
    private ObservableList<Person> medlemmerGui = FXCollections.observableList(medlemmerTufte);
    //ObservableList som holder på påmeldte personer.
    private Arrangement deltakerListe = AdminController.adminController.getArrangementListView().getSelectionModel().getSelectedItem();
    private ObservableList<Person> valgteMedlemmerGui = FXCollections.observableList(deltakerListe.getDeltakere());


    public void leggTilValgtePersoner(ActionEvent event) {
        Person lagspiller = lagspillereListView.getSelectionModel().getSelectedItem();
        Boolean finnesSpiller = Boolean.FALSE;

        if (!deltakerListe.getDeltakere().contains(lagspiller) && lagspiller != null) {

            for(Person pers:valgteMedlemmerGui) {
                if(lagspiller.getFornavn() == pers.getFornavn() && lagspiller.getEtternavn() == pers.getEtternavn()) {
                    finnesSpiller = Boolean.TRUE;
                }
            }

            if(finnesSpiller.equals(Boolean.FALSE)) {
                valgteMedlemmerGui.add(lagspiller);
                medlemmerGui.remove(lagspiller);
            }
        }

        /**Siden vi kun illustrer bruk av admin grensesnitt som et lag, blir dette logikken for hvordan man
         * melder "påloggede" lag på et arrangement
         */
        if(!deltakerListe.getDeltakere().isEmpty() && !Main.getApplication().getTufte().getArrangementerLagetErPaameldt().contains(deltakerListe)) {
            Main.getApplication().getTufte().meldPaaArrangement(deltakerListe);
            System.out.println(Main.getApplication().getTufte().getArrangementerLagetErPaameldt());
        }

        lagspillereListView.setItems(medlemmerGui);
        valgteMedlemmerListView.setItems(valgteMedlemmerGui);
        disableReturnerKnappOmListenIkkeErTom();
    }

    @FXML
    void fjernValgteMedlem(ActionEvent event) {
        Person valgtMedlem = valgteMedlemmerListView.getSelectionModel().getSelectedItem();
        Boolean finnesSpiller = Boolean.FALSE;

        if(deltakerListe.getDeltakere().contains(valgtMedlem)) {

            if(!valgtMedlem.getHarLagTilknytning()) {
                Alert advarsel = new Alert(Alert.AlertType.WARNING);
                advarsel.setContentText("Kan ikke melde av personer som ikke er en del av " + Main.getApplication().getTufte().getNavn());
                advarsel.showAndWait();
            } else {
                valgteMedlemmerGui.remove(valgtMedlem);
                deltakerListe.fjernDeltaker(valgtMedlem);

                for (Person pers : medlemmerGui) {
                    if (pers.getFornavn() == valgtMedlem.getFornavn() && valgtMedlem.getEtternavn() == pers.getEtternavn()) {
                        finnesSpiller = Boolean.TRUE;
                    }
                }

                if (finnesSpiller.equals(Boolean.FALSE)) {
                    medlemmerGui.add(valgtMedlem);
                }
            }
        }

        /** Avmelding fra arrangement**/
        if(deltakerListe.getDeltakere().isEmpty()) {
            Main.getApplication().getTufte().avmeldArrangement(deltakerListe);
        }

        lagspillereListView.setItems(medlemmerGui);
        valgteMedlemmerListView.setItems(valgteMedlemmerGui);

        //disableReturnerKnappOmListenIkkeErTom();
    }

    @FXML
    public void returnerTilHovedside(ActionEvent event)  {

        visFXML(event,"/adminside.fxml");
        int valgte = AdminController.adminController.getArrangementListView().getSelectionModel().getSelectedIndex();
        AdminController.adminController.getArrangementListView().getSelectionModel().select(valgte);
    }




    @FXML
    public void initialize(){
        if(valgteMedlemmerGui.isEmpty()) {
            sendFakturaButton.setDisable(true);
        }

        if(!deltakerListe.getDeltakere().isEmpty()) {
            sendFakturaButton.setDisable(true);
        }

        lagspillereListView.setItems(medlemmerGui);
        valgteMedlemmerListView.setItems(valgteMedlemmerGui);

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


    public void sendFaktura(ActionEvent actionEvent) {

        returnerButton.setDisable(false);
        sendFakturaLabel.setVisible(true);

    }

    public void disableReturnerKnappOmListenIkkeErTom() {
        if(!valgteMedlemmerGui.isEmpty()) {
            returnerButton.setDisable(true);
            sendFakturaButton.setDisable(false);
        } else {
            returnerButton.setDisable(false);
            sendFakturaButton.setDisable(true);
        }
    }
}

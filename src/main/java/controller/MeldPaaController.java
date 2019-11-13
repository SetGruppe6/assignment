package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Arrangement;
import model.Lag;
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

    public static MeldPaaController meldPaaController;
    public MeldPaaController() {meldPaaController = this;};

    //Lager en instans av et lag, som opptrer som det laget som er innlogget.
    private ArrayList<Person> medlemmerITufte = new ArrayList<>();
    private ArrayList<Arrangement> arrangementerTufteErMeldtPaa = new ArrayList<>();
    private Lag tufte = new Lag("Tufte IL", medlemmerITufte, arrangementerTufteErMeldtPaa);
    //ObservableList som holder på alle medlemmene fra tufte.
    private ObservableList<Person> medlemmerGui = FXCollections.observableList(tufte.leggTilDummyMedlemmer(tufte));
    //ObservableList som holder på påmeldte personer.
    private Arrangement deltakerListe = AdminController.adminController.getArrangementListView().getSelectionModel().getSelectedItem();
    private ObservableList<Person> valgteMedlemmerGui = FXCollections.observableList(deltakerListe.getDeltakere());;


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

        lagspillereListView.setItems(medlemmerGui);
        valgteMedlemmerListView.setItems(valgteMedlemmerGui);

    }

    @FXML
    void fjernValgteMedlem(ActionEvent event) {
        Person valgtMedlem = valgteMedlemmerListView.getSelectionModel().getSelectedItem();
        Boolean finnesSpiller = Boolean.FALSE;

        if(deltakerListe.getDeltakere().contains(valgtMedlem)) {
            valgteMedlemmerGui.remove(valgtMedlem);
            deltakerListe.fjernDeltaker(valgtMedlem);

            for(Person pers:medlemmerGui) {
                if(pers.getFornavn() == valgtMedlem.getFornavn() && valgtMedlem.getEtternavn() == pers.getEtternavn()) {
                    finnesSpiller = Boolean.TRUE;
                }
            }

            if(finnesSpiller.equals(Boolean.FALSE)) {
                medlemmerGui.add(valgtMedlem);
            }
        }

        /** Avmelding fra arrangement**/
        if(deltakerListe.getDeltakere().isEmpty()) {
            tufte.avmeldArrangement(deltakerListe);
        }

        lagspillereListView.setItems(medlemmerGui);
        valgteMedlemmerListView.setItems(valgteMedlemmerGui);
    }

    @FXML
    public void meldPaaValgte(ActionEvent event)  {

        for (Person pers : valgteMedlemmerGui) {
            if (!deltakerListe.getDeltakere().contains(pers)) {
                deltakerListe.leggTilDeltaker(pers);
                medlemmerGui.add(pers);
            }
        }

        /**Siden vi kun illustrer bruk av admin grensesnitt som et lag, blir dette logikken for hvordan man
         * melder "påloggede" lag på et arrangement
         */
        if(!deltakerListe.getDeltakere().isEmpty()) {
            tufte.meldPaaArrangement(deltakerListe);
            System.out.println(tufte.getArrangementerLagetErPaameldt());
        }


        visFXML(event,"/adminside.fxml");
        int valgte = AdminController.adminController.getArrangementListView().getSelectionModel().getSelectedIndex();
        AdminController.adminController.getArrangementListView().getSelectionModel().select(valgte);
    }




    @FXML
    public void initialize(){

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


    public Lag getTufte() {
        return tufte;
    }
}

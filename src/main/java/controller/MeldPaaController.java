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
import javafx.scene.control.SelectionMode;
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
    private ListView<Person> listeTextArea;

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
    private ObservableList<Person> medlemmerGui = FXCollections.observableList(tufte.getMedlemmer());
    //ObservableList som holder på påmeldte personer.
    private Arrangement deltakerListe = AdminController.adminController.getArrangementListView().getSelectionModel().getSelectedItem();
    private ObservableList<Person> valgteMedlemmerGui = FXCollections.observableList(deltakerListe.getDeltakere());;


    public void leggTilValgtePersoner(ActionEvent event) {
        Person lagspiller = lagspillereListView.getSelectionModel().getSelectedItem();

        if (!deltakerListe.getDeltakere().contains(lagspiller)) {
            valgteMedlemmerGui.add(lagspiller);
            medlemmerGui.remove(lagspiller);
        }

        lagspillereListView.setItems(medlemmerGui);
        listeTextArea.setItems(valgteMedlemmerGui);
    }

    @FXML
    void fjernValgteMedlem(ActionEvent event) {
        Person valgtMedlem = listeTextArea.getSelectionModel().getSelectedItem();

        if(deltakerListe.getDeltakere().contains(valgtMedlem)) {
            valgteMedlemmerGui.remove(valgtMedlem);
            deltakerListe.fjernDeltaker(valgtMedlem);
            medlemmerGui.add(valgtMedlem);
        }

        lagspillereListView.setItems(medlemmerGui);
        listeTextArea.setItems(valgteMedlemmerGui);
    }


    @FXML
    void velgFlereMedlemmer(ActionEvent event) {
        ObservableList<Person> deltakereGui = lagspillereListView.getSelectionModel().getSelectedItems();

        for(Person pers: deltakereGui) {
            if(listeTextArea.getItems().isEmpty()) {
                if (!deltakerListe.getDeltakere().contains(pers)) {
                    valgteMedlemmerGui.add(pers);
                }
            }
            for (Person pers2 : deltakerListe.getDeltakere()) {
                if (!pers2.getFornavn().equals(pers.getFornavn()) && !pers2.getEtternavn().equals(pers.getEtternavn())) {
                    deltakerListe.leggTilDeltaker(pers);
                    valgteMedlemmerGui.add(pers);
                }
            }

        }

        for(Person pers2: valgteMedlemmerGui) {
            if(medlemmerGui.contains(pers2)) {
                medlemmerGui.remove(pers2);
            }
        }

        lagspillereListView.setItems(medlemmerGui);
        listeTextArea.setItems(valgteMedlemmerGui);

    }


    public void meldPaaValgte(ActionEvent event)  {
        Arrangement deltakere = AdminController.adminController.getArrangementListView().getSelectionModel().getSelectedItem();

        for (Person pers : valgteMedlemmerGui) {
            if (!deltakere.getDeltakere().contains(pers)) {
                deltakere.leggTilDeltaker(pers);
            }
        }

        visFXML(event,"/adminside.fxml");
    }

    public void gaaTilbake(ActionEvent event) {
        visFXML(event,"/adminside.fxml");
    }



    @FXML
    public void initialize(){
        tufte.leggTilDummyMedlemmer(tufte);
        lagspillereListView.setItems(medlemmerGui);
        lagspillereListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listeTextArea.setItems(valgteMedlemmerGui);
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

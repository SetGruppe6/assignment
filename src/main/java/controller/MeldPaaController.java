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

    //Lager en instans av et lag, som opptrer som det laget som er innlogget.
    private Lag tufte = new Lag("Tufte IL", new ArrayList<>());
    //ObservableList som holder på alle medlemmene fra tufte.
    private ObservableList<Person> medlemmerGui = FXCollections.observableList(tufte.getMedlemmer());
    //ObservableList som holder på påmeldte personer.
    private ArrayList<Person> medlemmerTilValgteGui = new ArrayList<>();
    private ObservableList<Person> valgteMedlemmerGui = FXCollections.observableArrayList(medlemmerTilValgteGui);


    public void leggTilValgtePersoner(ActionEvent event) {
        Person lagspiller = lagspillereListView.getSelectionModel().getSelectedItem();
        Arrangement deltakerListe = AdminController.adminController.getArrangementListView().getSelectionModel().getSelectedItem();

        if(!deltakerListe.getDeltakere().contains(lagspiller)) {
            deltakerListe.leggTilDeltaker(lagspiller);
        }

        if(!valgteMedlemmerGui.contains(lagspiller)) {
            valgteMedlemmerGui.add(lagspiller);
            medlemmerGui.remove(lagspiller);
        }

        lagspillereListView.setItems(medlemmerGui);
        listeTextArea.setItems(valgteMedlemmerGui);
    }

    @FXML
    void fjernValgteMedlem(ActionEvent event) {
        Person valgtMedlem = listeTextArea.getSelectionModel().getSelectedItem();
        Arrangement deltakerListe = AdminController.adminController.getArrangementListView().getSelectionModel().getSelectedItem();

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
        Arrangement deltakere = AdminController.adminController.getArrangementListView().getSelectionModel().getSelectedItem();

        for(Person pers: deltakereGui) {
            if(!valgteMedlemmerGui.contains(pers) && !deltakere.getDeltakere().contains(pers)) {
                valgteMedlemmerGui.add(pers);
                deltakere.leggTilDeltaker(pers);
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


    public void tilbakeTilAdminside(ActionEvent event)  {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/adminside.fxml"));
        try {
            fxmlLoader.load();
        }catch (IOException e){
            System.out.println(e);
        }
        Parent p = fxmlLoader.getRoot();
        Scene scene = new Scene(p);
        Stage vindu = (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(scene);
        vindu.show();
    }

    public void gaaTilbake(ActionEvent event) throws IOException {
        Parent brukerParent = FXMLLoader.load(getClass().getResource("/adminside.fxml"));
        Scene brukerScene = new Scene(brukerParent);
        Stage vindu = (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(brukerScene);
        vindu.show();
    }

    @FXML
    public void initialize(){

        tufte.leggTilDummyMedlemmer(tufte.getMedlemmer());
        lagspillereListView.setItems(medlemmerGui);
        lagspillereListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listeTextArea.setItems(valgteMedlemmerGui);

    }

}

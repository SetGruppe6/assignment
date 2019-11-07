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
import javafx.scene.control.TextArea;
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
    private TextArea listeTextArea;

    @FXML
    private Button selectAllButton;

    @FXML
    private Button leggOverButton;

    private ArrayList<Person> personerListe = new ArrayList<>();
    private Lag tufte = new Lag("Tufte IL", new ArrayList<>());
    private ObservableList<Person> medlemmerGui = FXCollections.observableList(tufte.getMedlemmer());
    private StringBuilder choosenOne = new StringBuilder();





    @FXML
    public void initialize(){
        tufte.leggTilDummyMedlemmer(tufte.getMedlemmer());
        lagspillereListView.setItems(medlemmerGui);
        lagspillereListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void gaaTilbake(ActionEvent event) throws IOException {
        Parent brukerParent = FXMLLoader.load(getClass().getResource("/adminside.fxml"));
        Scene brukerScene = new Scene(brukerParent);
        Stage vindu = (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(brukerScene);
        vindu.show();
    }

    public void leggTilValgtePersoner(ActionEvent event) {
        Person lagspiller = lagspillereListView.getSelectionModel().getSelectedItem();

        Arrangement deltakerListe = AdminController.adminController.getArrangementListView().getSelectionModel().getSelectedItem();

        if(!deltakerListe.getDeltakere().contains(lagspiller)) {
            deltakerListe.leggTilDeltaker(lagspiller);
        }

        if(!choosenOne.toString().contains(lagspiller.getFornavn())) {
            choosenOne.append(lagspiller.getFornavn()).append(lagspiller.getEtternavn()).append("\n");
        }

        listeTextArea.setText(choosenOne.toString());
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


}

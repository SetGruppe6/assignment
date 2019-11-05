package controller;

import datahandler.Datahandler;
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

    @FXML
    public void initialize(){

        lagspillereListView.setItems(Datahandler.personData());
        lagspillereListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void gaaTilbake(ActionEvent event) throws IOException {
        Parent brukerParent = FXMLLoader.load(getClass().getResource("/adminside.fxml"));
        Scene brukerScene = new Scene(brukerParent);
        Stage vindu = (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(brukerScene);
        vindu.show();
    }

    public void selectAllMetode(ActionEvent event) {
        Person lagspiller;
        lagspiller = lagspillereListView.getSelectionModel().getSelectedItem();

        Datahandler.getDeltakere().add(lagspiller);

        String variabel = new String();
        for (Person enPerson: Datahandler.getDeltakere()) {
            variabel += enPerson.getFornavn()+  " " + enPerson.getEtternavn() + "\n";
        }
        listeTextArea.setText(variabel);
    }


    public void nyMetode(ActionEvent event)  {
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

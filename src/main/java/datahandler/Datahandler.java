package datahandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Arrangement;
import model.Person;

import java.util.ArrayList;

public class Datahandler {

    public static Datahandler dataHandler;
    public Datahandler() {dataHandler = this;};


    //////////////////////////////////ARRANGEMENTER///////////////////////////////////////////////////////////////////////
    private static ObservableList<Arrangement> arrangementListe = FXCollections.observableList(Arrangement.getArrangementer());





    private static ArrayList<Person> medlemmer = new ArrayList<>();

    /**public ObservableList<Person> leggTilDataIGui(ObservableList<Person> liste) {
        liste.addAll(tufte.getMedlemmer());
        return liste;
    }**/

    public static ArrayList<Person> getMedlemmer() {
        return medlemmer;
    }

    public static ObservableList<Arrangement> getArrangementListe() {
        return arrangementListe;
    }

}


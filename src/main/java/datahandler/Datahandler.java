package datahandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Arrangement;

import java.util.ArrayList;

public class Datahandler {

    public static Datahandler dataHandler;
    public Datahandler() {dataHandler = this;};


    //////////////////////////////////ARRANGEMENTER///////////////////////////////////////////////////////////////////////
    private static ObservableList<Arrangement> arrangementListe = FXCollections.observableList(Arrangement.getArrangementer());





    public static ObservableList<Arrangement> getArrangementListe() {
      
        return arrangementListe;
    }

    public static ObservableList<Arrangement> setArrangementListe(ArrayList<Arrangement> arr) {
        Datahandler.arrangementListe = FXCollections.observableList(arr);
        return Datahandler.arrangementListe;
    }

}


package datahandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Arrangement;

public class Datahandler {

    public static Datahandler dataHandler;
    public Datahandler() {dataHandler = this;};


    //////////////////////////////////ARRANGEMENTER///////////////////////////////////////////////////////////////////////
    private static ObservableList<Arrangement> arrangementListe = FXCollections.observableList(Arrangement.getArrangementer());


    public static ObservableList<Arrangement> getArrangementListe() {
        return arrangementListe;
    }

}


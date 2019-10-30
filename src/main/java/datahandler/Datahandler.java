package datahandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Arrangement;
import model.Lop;
import model.Ski;
import model.Sykkel;

import java.util.ArrayList;

public class Datahandler {

    private static ArrayList<Arrangement> listeArrangement = new ArrayList<>();
    private final static ObservableList<Arrangement> arrangementListe = FXCollections.observableArrayList(listeArrangement);

    public static ObservableList<Arrangement> arrangementData(){
        if(arrangementListe.size() == 0 ){
           arrangementListe.add(new Lop("Holmekollen stafetten","dette er et løp", "sted", "26.11.2019", "12:00", "18:00", 123, 100));
           arrangementListe.add(new Sykkel("Tour de halden", "dette er et sykkel kappløp", "annet sted", "12.12.2019", "17:00", "21:00", 200, 50));
           arrangementListe.add(new Ski("Birkebeinerne", "dette er en ski konkurranse", "annet annet sted", "24.12.2019", "08:00", "16:00", 50, 0));


        }
        return arrangementListe;
    }
}

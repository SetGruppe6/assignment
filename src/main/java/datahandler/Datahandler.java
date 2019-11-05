package datahandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Datahandler {

    private static ArrayList<Person> personerListe = new ArrayList<>();

    private final static ObservableList<Person> listePersoner = FXCollections.observableArrayList(personerListe);

    public static ObservableList <Person> personData(){
        if(listePersoner.size() == 0){
            listePersoner.add(new Person("Petter", "Northug"));
            listePersoner.add(new Person("Daria", "Northug Jr"));
            listePersoner.add(new Person("Jens", "Juul"));
            listePersoner.add(new Person("Sander", "Fleece"));
            listePersoner.add(new Person("Joakim", "Manedskog"));
            listePersoner.add(new Person("Jarle", "MacMonday"));
            listePersoner.add(new Person("Polly", "Esther"));
            listePersoner.add(new Person("Donald", "Stump"));
            listePersoner.add(new Person("Anne", "Blaa"));
            listePersoner.add(new Person("Therese", "Dohaug"));
            listePersoner.add(new Person("Silje", "Stikksag"));
            listePersoner.add(new Person("Hans", "son-Mbop"));
            listePersoner.add(new Person("Harald", "Haarfagre"));
            listePersoner.add(new Person("Putin", "OnAShow"));
            listePersoner.add(new Person("Henny", "Koppen"));
            listePersoner.add(new Person("Siri", "Senkesett"));
            listePersoner.add(new Person("Svein", "Charter"));
        }
        return listePersoner;
    }


    //private static ArrayList<Arrangement> listeArrangement = Arrangement.getArrangementer();
    private static ObservableList<Arrangement> arrangementListe = FXCollections.observableList(Arrangement.getArrangementer());


    private static ArrayList<Person> deltakere = new ArrayList<>();


    public static ObservableList<Arrangement> arrangementData(){
        if(arrangementListe.size() == 0 ){
           arrangementListe.add(new Lop("Holmeenkollen Stafetten", "Oslo", LocalDate.of(2019,12,24), "00:00","01:00", 100, 250, "Dette er et maraton", deltakere));
           arrangementListe.add(new Sykkel("Tour de Halden", "Halden", LocalDate.of(2019,12,18), "12:00", "18:00", 50, 100, "Dette er et sykkelløp", deltakere));
           arrangementListe.add(new Ski("Birkebeinerne", "et sted", LocalDate.of(2019,11,28), "11:00", "16:00", 50, 50, "Dette er et skiløp" , deltakere));
        }


        return arrangementListe;
    }

    public static ArrayList<Person> getDeltakere() {
        return deltakere;
    }

}

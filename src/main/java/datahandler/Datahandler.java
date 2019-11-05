package datahandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.util.ArrayList;

public class Datahandler {

    ////////////////////////////////////TESTPERSONER///////////////////////////////////////////////////////////////////////
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

    ////////////////////////////////////TESTPERSONER///////////////////////////////////////////////////////////////////////


    // TESTLØP
    public static Lop lop = new Lop("Holmeenkollen Stafetten", "Oslo", "12.12.2012", "00:00","01:00", 100, 250, "Dette er et maraton", new ArrayList<>());
    public static Ski ski = new Ski("Birkebeinerne", "et sted", "12.12.2019", "11:00", "16:00", 50, 50, "Dette er et skiløp" , new ArrayList<>());
    public static Sykkel sykkel = new Sykkel("Tour de Halden", "Halden", "24.12.2019", "12:00", "18:00", 50, 100, "Dette er et sykkelløp", new ArrayList<>());


    private static ArrayList<Arrangement> listeArrangement = new ArrayList<>();
    private static ObservableList<Arrangement> arrangementListe = FXCollections.observableArrayList(listeArrangement);

    private static ArrayList<Person> deltakere = new ArrayList<>();

    public static ObservableList<Arrangement> arrangementData(){
        if(arrangementListe.size() == 0 ){
            arrangementListe.add(lop);
           arrangementListe.add(sykkel);
           arrangementListe.add(ski);
        }
        return arrangementListe;
    }

    public static ArrayList<Person> getDeltakere() {
        return deltakere;
    }

    public static ObservableList<Arrangement> getArrangementListe() {
        return arrangementListe;
    }
}
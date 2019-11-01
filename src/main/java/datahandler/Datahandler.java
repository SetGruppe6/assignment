package datahandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.util.ArrayList;

public class Datahandler {

    private static ArrayList<Person> personerListe = new ArrayList<>();

    private final static ObservableList<Person> listePersoner = FXCollections.observableArrayList(personerListe);

    public static ObservableList <Person> personData(){
        if(listePersoner.size() == 0){
            listePersoner.add(new Person("navn1", "etternavn1"));
            listePersoner.add(new Person("navn2", "etternavn2"));
            listePersoner.add(new Person("navn3", "etternavn3"));
            listePersoner.add(new Person("navn4", "etternavn4"));
            listePersoner.add(new Person("navn5", "etternavn4"));
            listePersoner.add(new Person("navn6", "etternavn4"));
            listePersoner.add(new Person("navn7", "etternavn4"));
            listePersoner.add(new Person("navn8", "etternavn4"));
            listePersoner.add(new Person("navn9", "etternavn4"));
            listePersoner.add(new Person("navn10", "etternavn4"));
            listePersoner.add(new Person("navn11", "etternavn4"));
            listePersoner.add(new Person("navn12", "etternavn4"));
            listePersoner.add(new Person("navn13", "etternavn4"));
            listePersoner.add(new Person("navn14", "etternavn4"));
            listePersoner.add(new Person("navn15", "etternavn4"));
            listePersoner.add(new Person("navn16", "etternavn4"));
            listePersoner.add(new Person("navn17", "etternavn4"));
        }
        return listePersoner;
    }

    private static ArrayList<Arrangement> listeArrangement = new ArrayList<>();
    private final static ObservableList<Arrangement> arrangementListe = FXCollections.observableArrayList(listeArrangement);

    private static ArrayList<Person> deltakere = new ArrayList<>();

    private static void fyllopp(){
        for (int i = 0; i <5 ; i++) {
            deltakere.add(new Person("navn"+ i, "etternavn" + i));
        }
    }

    public static ObservableList<Arrangement> arrangementData(){
        if(arrangementListe.size() == 0 ){
            fyllopp();
           arrangementListe.add(new Lop("Holmekollen stafetten","dette er et løp", "sted", "26.11.2019", "12:00", "18:00", 123, deltakere, 100));
           arrangementListe.add(new Sykkel("Tour de halden", "dette er et sykkel kappløp", "annet sted", "12.12.2019", "17:00", "21:00", 200, deltakere,50));
           arrangementListe.add(new Ski("Birkebeinerne", "dette er en ski konkurranse", "annet annet sted", "24.12.2019", "08:00", "16:00", 50, deltakere, 0));
        }
        return arrangementListe;
    }

}

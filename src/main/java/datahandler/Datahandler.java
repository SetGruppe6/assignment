package datahandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Arrangement;
import model.Person;

import java.util.ArrayList;

public class Datahandler {

    ////////////////////////////////////TESTPERSONER///////////////////////////////////////////////////////////////////////
    private static ArrayList<Person> personerListe = new ArrayList<>();

    //////////////////////////////////ARRANGEMENTER///////////////////////////////////////////////////////////////////////
    private static ObservableList<Arrangement> arrangementListe = FXCollections.observableList(Arrangement.getArrangementer());

    private final static ObservableList<Person> listePersoner = FXCollections.observableArrayList(personerListe);


    private static ArrayList<Person> medlemmer = new ArrayList<>();

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

    public static ArrayList<Person> getMedlemmer() {
        return medlemmer;
    }

    public static ObservableList<Arrangement> getArrangementListe() {
        return arrangementListe;
    }
}


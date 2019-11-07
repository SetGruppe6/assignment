package datahandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.time.LocalDate;
import java.time.LocalTime;
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
    /**public Lop lop = new Lop("Holmeenkollen Stafetten", "Oslo", LocalDate.of(2019,12,24), LocalTime.of(23,0),LocalTime.of(1, 0), 100, 250, "Dette er et maraton", new ArrayList<>());
    public static Sykkel sykkel = new Sykkel("Tour de Halden", "Halden", LocalDate.of(2019,12,18),LocalTime.of(16,0), LocalTime.of(18,0), 50, 100, "Dette er et sykkelløp", new ArrayList<>());
    public static Ski ski = new Ski("Birkebeinerne", "et sted", LocalDate.of(2019,11,28), LocalTime.of(13,0), LocalTime.of(16,0), 50, 50, "Dette er et skiløp" , new ArrayList<>());**/

    private static ObservableList<Arrangement> arrangementListe = FXCollections.observableList(Arrangement.getArrangementer());


    private static ArrayList<Person> medlemmer = new ArrayList<>();

    public static ObservableList<Arrangement> arrangementData(){
        if(arrangementListe.size() == 0 ){
            arrangementListe.add(new Lop("Holmenkollstafetten", "Underhaugsveien 1, 0354 Oslo", LocalDate.of(2020,5,5), LocalTime.of(10,0),LocalTime.of(18, 0), 2000, 250, "Holmenkollstafetten er et stafett arrangert av Idrettsklubben Tjalve, og blir omtalt som vaarens vakreste eventyr. Et av Norges storste friiddrettsarrangementer i antall paameldte.", new ArrayList<>()));
            arrangementListe.add(new Sykkel("Tour de Halden", "Festningen, 1748 Halden", LocalDate.of(2019,12,18),LocalTime.of(16,0), LocalTime.of(18,0), 50, 100, "Veldedighetslop over 100km, arrangert av Kvikk Halden. Arrangeres for aa samle inn penger til veldige formaal", new ArrayList<>()));
            arrangementListe.add(new Ski("Birkebeinerrennet", "Tingstadjordet 3, 2450 Rena", LocalDate.of(2019,11,28), LocalTime.of(13,0), LocalTime.of(16,0), 50, 50, "Birkebeinerrennet er Norges mest tradisjonsrike turrenn paa ski og gaar hvert aar fra Rena til Lillehammer." , new ArrayList<>()));
        }

        return arrangementListe;
    }

    public static ArrayList<Person> getMedlemmer() {
        return medlemmer;
    }


    public static ObservableList<Arrangement> getArrangementListe() {
        return arrangementListe;
    }
}


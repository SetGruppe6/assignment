package datahandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Arrangement;
import model.Lop;
import model.Ski;
import model.Sykkel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Datahandler {

    public static Datahandler dataHandler;
    public Datahandler() {dataHandler = this;};

    private static ArrayList<Arrangement> arrangementer = new ArrayList<>();
    private static ObservableList<Arrangement> arrangementListe = FXCollections.observableList(getArrangementer());

    public static void leggTilArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }

    //Legger til DummyArrangementer i prototypen.
    public static ArrayList<Arrangement> leggTilDummyArrangementer(ArrayList<Arrangement> arrangementListen){
        if(getArrangementer().size() == 0 ){

            arrangementListen.add(new Lop("Holmenkollstafetten", "Underhaugsveien 1, 0354 Oslo", LocalDate.of(2020,5,5), LocalTime.of(10,0),LocalTime.of(18, 0), 2000, 250, "Holmenkollstafetten er et stafett arrangert av Idrettsklubben Tjalve, og blir omtalt som vaarens vakreste eventyr. Et av Norges storste friiddrettsarrangementer i antall paameldte.", new ArrayList<>()));
            arrangementListen.add(new Sykkel("Tour de Halden", "Festningen, 1748 Halden", LocalDate.of(2019,12,18),LocalTime.of(16,0), LocalTime.of(18,0), 50, 0, "Veldedighetslop over 100km, arrangert av Kvikk Halden. Arrangeres for aa samle inn penger til veldige formaal", new ArrayList<>()));
            arrangementListen.add(new Ski("Birkebeinerrennet", "Tingstadjordet 3, 2450 Rena", LocalDate.of(2019,11,28), LocalTime.of(13,0), LocalTime.of(16,0), 50, 50, "Birkebeinerrennet er Norges mest tradisjonsrike turrenn paa ski og gaar hvert aar fra Rena til Lillehammer." , new ArrayList<>()));
            arrangementListen.add(new Ski("Halden barneskirenn", "Tistedalen, 1748 Halden", LocalDate.of(2019,10,28), LocalTime.of(13,0), LocalTime.of(16,0), 50, 50, "Barneskirenn for alle som onsker aa delta. Alle som deltar faar gratis premie og det blir muligheter for kjop av Glogg, kaffe og vafler samt lodd som trekkes paa juleavslutningen." , new ArrayList<>()));
            arrangementListen.add(new Sykkel("Sellebakk Oldtids tour", "Oldtidsveien, 1645 Sellebakk", LocalDate.of(2019,9,18), LocalTime.of(13,0), LocalTime.of(16,0), 50, 50, "Terrenglop langs Oldtidsveien, konkurrer blandt gamle runer. Husk reservehjul og luftpatron ettersom stien kan vaere utfordende for sykkehjulene, vel moett!" , new ArrayList<>()));
        }

        return arrangementListen;
    }

    public static ArrayList<Arrangement> filtrerPaaDatoKommende(ArrayList<Arrangement> arrangementer) {
        LocalDate now = LocalDate.now();
        ArrayList<Arrangement> kommende = new ArrayList<>();

        for(Arrangement arr: arrangementer) {
            if(arr.getDato().isAfter(now)) {
                kommende.add(arr);
            }
        }
        return kommende;
    }

    public static  ArrayList<Arrangement> filtrerPaaAvsluttede(ArrayList<Arrangement> arrangementer) {
        LocalDate now = LocalDate.now();
        ArrayList<Arrangement> avsluttede = new ArrayList<>();

        for(Arrangement arr: arrangementer) {
            if(arr.getDato().isBefore(now)) {
                avsluttede.add(arr);
            }
        }
        return avsluttede;
    }

    public static ObservableList<Arrangement> getArrangementListe() { return arrangementListe; }

    public static ObservableList<Arrangement> setArrangementListe(ArrayList<Arrangement> arr) {
        Datahandler.arrangementListe = FXCollections.observableList(arr);
        return Datahandler.arrangementListe;
    }

    public static ArrayList<Arrangement> getArrangementer() {
        return arrangementer;
    }
}


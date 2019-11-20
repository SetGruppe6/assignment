package datahandler;

import model.Arrangement;
import model.Lop;
import model.Ski;
import model.Sykkel;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatahandlerTest {

    private static ArrayList<Arrangement> testListe = new ArrayList<>();
    private static ArrayList<Arrangement> testListe2 = new ArrayList<>();
    private Lop test = new Lop("Holmenkollstafetten", "Underhaugsveien 1, 0354 Oslo", LocalDate.of(2020,5,5), LocalTime.of(10,0),LocalTime.of(18, 0), 2000, 250, "Holmenkollstafetten er et stafett arrangert av Idrettsklubben Tjalve, og blir omtalt som vaarens vakreste eventyr. Et av Norges storste friiddrettsarrangementer i antall paameldte.", new ArrayList<>());
    private Sykkel test2 = new Sykkel("Tour de Halden", "Festningen, 1748 Halden", LocalDate.of(2019,12,18),LocalTime.of(16,0), LocalTime.of(18,0), 50, 0, "Veldedighetslop over 100km, arrangert av Kvikk Halden. Arrangeres for aa samle inn penger til veldige formaal", new ArrayList<>());
    private  Ski test3  = new Ski("Birkebeinerrennet", "Tingstadjordet 3, 2450 Rena", LocalDate.of(2019,11,28), LocalTime.of(13,0), LocalTime.of(16,0), 50, 50, "Birkebeinerrennet er Norges mest tradisjonsrike turrenn paa ski og gaar hvert aar fra Rena til Lillehammer." , new ArrayList<>());
    private Ski test4 = new Ski("Halden barneskirenn", "Tistedalen, 1748 Halden", LocalDate.of(2019,10,28), LocalTime.of(13,0), LocalTime.of(16,0), 50, 50, "Barneskirenn for alle som onsker aa delta. Alle som deltar faar gratis premie og det blir muligheter for kjop av Glogg, kaffe og vafler samt lodd som trekkes paa juleavslutningen." , new ArrayList<>());
    private Sykkel test5 = new Sykkel("Sellebakk Oldtids tour", "Oldtidsveien, 1645 Sellebakk", LocalDate.of(2019,9,18), LocalTime.of(13,0), LocalTime.of(16,0), 50, 50, "Terrenglop langs Oldtidsveien, konkurrer blandt gamle runer. Husk reservehjul og luftpatron ettersom stien kan vaere utfordende for sykkehjulene, vel moett!" , new ArrayList<>());




    // Krav 3.8.2
    @Test
    public void leggTilArrangementTest(){
        Sykkel test = new Sykkel("Tour de Halden", "Festningen, 1748 Halden", LocalDate.of(2019,12,18), LocalTime.of(16,0), LocalTime.of(18,0), 50, 0, "Veldedighetslop over 100km, arrangert av Kvikk Halden. Arrangeres for aa samle inn penger til veldige formaal", new ArrayList<>());
        ArrayList<Arrangement> TestArrangementer = new ArrayList<>();
        TestArrangementer.add(test);
        Datahandler.leggTilArrangement(test);
        assertEquals(TestArrangementer, Datahandler.getArrangementer());
    }

    @Test
    public void leggTilDummyArrangementerTest() {
        Datahandler.leggTilDummyArrangementer(testListe);

        testListe2.add(test);
        testListe2.add(test2);
        testListe2.add(test3);
        testListe2.add(test4);
        testListe2.add(test5);

        assertEquals(testListe2.size(), testListe.size());
    }

    @Test
    public void filtrerKommendeArrangementerTest() {
        ArrayList<Arrangement> kommende = new ArrayList<>();
        Boolean arrangeresEtterDagensDato = Boolean.TRUE;
        LocalDate now = LocalDate.now();

        Datahandler.leggTilDummyArrangementer(kommende);
        Datahandler.filtrerPaaDatoKommende(kommende);

        for(Arrangement arr : kommende) {
            if(!arr.getDato().isAfter(now)) {
                arrangeresEtterDagensDato = Boolean.FALSE;
                break;
            }
        }

        assertEquals(Boolean.TRUE, arrangeresEtterDagensDato);
    }

    @Test
    public void filtrerTidligereArrangementerTest() {
        ArrayList<Arrangement> tidligere = new ArrayList<>();
        Boolean arrangeresForDagensDato = Boolean.TRUE;
        LocalDate now = LocalDate.now();
        Datahandler.leggTilDummyArrangementer(tidligere);

        Datahandler.filtrerPaaAvsluttede(tidligere);

        for(Arrangement arr : tidligere) {
            if(arr.getDato().isAfter(now)) {
                arrangeresForDagensDato = Boolean.FALSE;
                break;
            }
        }

        assertEquals(Boolean.TRUE, arrangeresForDagensDato);
    }

}
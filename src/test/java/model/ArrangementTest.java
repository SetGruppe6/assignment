package model;

import org.junit.jupiter.api.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArrangementTest {

    Lop TestArrangementKorrekt = new Lop("Oslo Maraton", "Oslo, Rådhusplassen", LocalDate.of(2020, 9, 19), LocalTime.of(13,0), LocalTime.of(19,0), 900, 299, "Oslo Maraton er Norges største maraton og arrangeres hver høst i Oslos gater av Sportsklubben Vidar", new ArrayList<>());
    Ski TestArrangementFeilVerdier = new Ski("Birk", "", LocalDate.of(2018, 2, 3), LocalTime.of(20,30), LocalTime.of(10,30), 0, -200, "", new ArrayList<>());
    Sykkel FeilVerdierSykkelTest = new Sykkel("Tour de la France Global Cycling Tour", "", LocalDate.of(2019, 12,1), LocalTime.of(10,30), LocalTime.of(10,30), 2000, 2000, "", new ArrayList<>());
    Person TestJon = new Person("Jon","Jonsen");
    Person TestPer = new Person("Per", "Persson");
    Person TestErik = new Person("Erik","Ericcson");
    @Test
    public void erTittelOkTest(){


        assertEquals("", TestArrangementKorrekt.erTittelOk(TestArrangementKorrekt.getNavn()));
        assertEquals("Tittel for lang", FeilVerdierSykkelTest.erTittelOk(FeilVerdierSykkelTest.getNavn()));
        assertEquals("Tittel for kort", TestArrangementFeilVerdier.erTittelOk(TestArrangementFeilVerdier.getNavn()));
    }

    @Test
    public void erLokasjonOkTest(){
        assertEquals("Fyll inn lokasjon", TestArrangementFeilVerdier.erLokasjonGitt(TestArrangementFeilVerdier.getLokasjon()));
        assertEquals("", TestArrangementKorrekt.erLokasjonGitt(TestArrangementKorrekt.getLokasjon()));
    }

    @Test
    public void erDatoOkTest(){
        assertEquals("", TestArrangementKorrekt.erDatoOK(TestArrangementKorrekt.getDato()));
        assertEquals("Arrangementets dato kan ikke være i fortiden", TestArrangementFeilVerdier.erDatoOK(TestArrangementFeilVerdier.getDato()));
        assertEquals("Arrangementets dato må tidligst være om 30 dager", FeilVerdierSykkelTest.erDatoOK(FeilVerdierSykkelTest.getDato()));
    }

    @Test
    public void erTidsromGittTest(){
        //Har ikke test for "vennligst skriv inn på riktig format"
        assertEquals("Starttidspunkt kan ikke være før sluttidspunkt", TestArrangementFeilVerdier.erStartTidspunktOk(TestArrangementFeilVerdier.getStartTid(), TestArrangementFeilVerdier.getSluttTid()));
        assertEquals("Start- og sluttidspunkt kan ikke være det samme", FeilVerdierSykkelTest.erStartTidspunktOk(FeilVerdierSykkelTest.getStartTid(), FeilVerdierSykkelTest.getSluttTid()));
        assertEquals("", TestArrangementKorrekt.erStartTidspunktOk(TestArrangementKorrekt.getStartTid(), TestArrangementKorrekt.getSluttTid()));
    }

    @Test
    public void erDeltakerKapasitetOkTest(){
        assertEquals("Deltakerkapasitet må være større enn 0", TestArrangementFeilVerdier.erDeltakerKapasitetOk(TestArrangementFeilVerdier.getDeltakerKapasitet()));
        assertEquals("Kapasitet under 0 eller over 1000", FeilVerdierSykkelTest.erDeltakerKapasitetOk(FeilVerdierSykkelTest.getDeltakerKapasitet()));
        assertEquals("", TestArrangementKorrekt.erDeltakerKapasitetOk(TestArrangementKorrekt.getDeltakerKapasitet()));
    }


    @Test
    public void erBeskrivelseGittTest(){
        assertEquals("Beskrivelse ikke gitt", FeilVerdierSykkelTest.erBeskrivelseGitt(FeilVerdierSykkelTest.getBeskrivelse()));
        assertEquals("", TestArrangementKorrekt.erBeskrivelseGitt(TestArrangementKorrekt.getBeskrivelse()));
    }

    @Test
    public void erPrisGittTest(){
        assertEquals("Arrangement er for dyrt", FeilVerdierSykkelTest.erPrisGitt(FeilVerdierSykkelTest.getPameldingsAvgift()));
        assertEquals("Pris kan ikke være negativ", TestArrangementFeilVerdier.erPrisGitt(TestArrangementFeilVerdier.getPameldingsAvgift()));
        assertEquals("", TestArrangementKorrekt.erPrisGitt(TestArrangementKorrekt.getPameldingsAvgift()));
    }

    @Test // Ikke ferdig. Blir dette riktig måte å sjekke om man legger til et arrangement??? Metoden benyttes.
    public void leggTilArrangementTest(){
        ArrayList<Arrangement> TestArrangementer = new ArrayList<>();
        TestArrangementer.add(TestArrangementKorrekt);
        Arrangement.leggTilArrangement(TestArrangementKorrekt);
        assertEquals(TestArrangementer, Arrangement.getArrangementer());
    }

    @Test //Bruke en ny arraylist i testen?
    public void leggTilDeltakerTest(){
        ArrayList<Person> TestDeltakere = new ArrayList<>();
        TestDeltakere.add(TestJon);
        TestDeltakere.add(TestPer);
        TestDeltakere.add(TestErik);
        TestArrangementKorrekt.leggTilDeltaker(TestJon);
        TestArrangementKorrekt.leggTilDeltaker(TestPer);
        TestArrangementKorrekt.leggTilDeltaker(TestErik);
        assertEquals(TestDeltakere, TestArrangementKorrekt.getDeltakere());
    }

    @Test
    public void fjerneDeltakerTest(){
        ArrayList<Person> TestDeltakere = new ArrayList<>();
        TestDeltakere.add(TestJon);
        TestDeltakere.add(TestPer);
        TestArrangementKorrekt.leggTilDeltaker(TestJon);
        TestArrangementKorrekt.leggTilDeltaker(TestPer);
        TestArrangementKorrekt.leggTilDeltaker(TestErik);
        TestArrangementKorrekt.fjernDeltaker(TestErik);
        assertEquals(TestDeltakere, TestArrangementKorrekt.getDeltakere());
    }
    /*
    @Test
    public void leggTilDummyArrangementer(){ ///Gjør denne bare det samme som leggtilarrangementer-metoden?
        ArrayList<Arrangement> TestArrangementer = new ArrayList<>();
        TestArrangementer.add(TestArrangementKorrekt);
        TestArrangementer.add(TestArrangementFeilVerdier);
        TestArrangementer.add(FeilVerdierSykkelTest);
        Arrangement.leggTilDummyArrangementer().add(TestArrangementKorrekt);
        Arrangement.leggTilDummyArrangementer().add(TestArrangementFeilVerdier);
        Arrangement.leggTilDummyArrangementer().add(FeilVerdierSykkelTest);
        assertEquals(TestArrangementer, Arrangement.getArrangementer());
    } */
}
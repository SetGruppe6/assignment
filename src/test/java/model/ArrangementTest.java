package model;

import datahandler.Datahandler;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrangementTest {

    /*
    * Oppretter instanser som skal brukes i testingen.
    * */
    Lop TestArrangementKorrekt = new Lop("Oslo Maraton", "Oslo, Rådhusplassen", LocalDate.of(2020, 9, 19), LocalTime.of(13,0), LocalTime.of(19,0), 477, 299, "Oslo Maraton er Norges største maraton og arrangeres hver høst i Oslos gater av Sportsklubben Vidar", new ArrayList<>());
    Ski TestArrangementFeilVerdier = new Ski("Birk", "", LocalDate.of(2018, 2, 3), LocalTime.of(20,30), LocalTime.of(10,30), 0, -200, "", new ArrayList<>());
    Sykkel FeilVerdierSykkelTest = new Sykkel("Tour de la France Global Cycling Tour", "", LocalDate.of(2019, 12,1), LocalTime.of(10,30), LocalTime.of(10,30), 2000, 2000, "", new ArrayList<>());
    Person TestJon = new Person("Jon","Jonsen");
    Person TestPer = new Person("Per", "Persson");
    Person TestErik = new Person("Erik","Ericcson");


    // Krav 3.1.1
    @Test
    public void erTittelOkTest(){
        assertEquals("", TestArrangementKorrekt.erTittelOk(TestArrangementKorrekt.getNavn()));
        assertEquals("Tittel for lang", FeilVerdierSykkelTest.erTittelOk(FeilVerdierSykkelTest.getNavn()));
        assertEquals("Tittel for kort", TestArrangementFeilVerdier.erTittelOk(TestArrangementFeilVerdier.getNavn()));
    }

    // Krav 3.1.9
    @Test
    public void erLokasjonOkTest(){
        assertEquals("Fyll inn lokasjon", TestArrangementFeilVerdier.erLokasjonGitt(TestArrangementFeilVerdier.getLokasjon()));
        assertEquals("", TestArrangementKorrekt.erLokasjonGitt(TestArrangementKorrekt.getLokasjon()));
    }

    // Krav 3.1.5
    @Test
    public void erDatoOkTest(){
        assertEquals("", TestArrangementKorrekt.erDatoOK(TestArrangementKorrekt.getDato()));
        assertEquals("Arrangementets dato kan ikke vaere i fortiden", TestArrangementFeilVerdier.erDatoOK(TestArrangementFeilVerdier.getDato()));
        assertEquals("Arrangementets dato maa tidligst vaere om 30 dager", FeilVerdierSykkelTest.erDatoOK(FeilVerdierSykkelTest.getDato()));
    }

    // Krav 3.1.6
    @Test
    public void erTidsromGittTest(){
        //Har ikke test for "vennligst skriv inn på riktig format"
        assertEquals("Starttidspunkt kan ikke vaere for sluttidspunkt", TestArrangementFeilVerdier.erStartTidspunktOk(TestArrangementFeilVerdier.getStartTid(), TestArrangementFeilVerdier.getSluttTid()));
        assertEquals("Start- og sluttidspunkt maa vaere ulik", FeilVerdierSykkelTest.erStartTidspunktOk(FeilVerdierSykkelTest.getStartTid(), FeilVerdierSykkelTest.getSluttTid()));
        assertEquals("", TestArrangementKorrekt.erStartTidspunktOk(TestArrangementKorrekt.getStartTid(), TestArrangementKorrekt.getSluttTid()));
    }

    // Krav 3.1.7
    @Test
    public void erDeltakerKapasitetOkTest(){
        assertEquals("Deltakerkapasitet maa vaere storre enn 0", TestArrangementFeilVerdier.erDeltakerKapasitetOk(TestArrangementFeilVerdier.getDeltakerKapasitet()));
        assertEquals("Kapasitet under 0 eller over 500", FeilVerdierSykkelTest.erDeltakerKapasitetOk(FeilVerdierSykkelTest.getDeltakerKapasitet()));
        assertEquals("", TestArrangementKorrekt.erDeltakerKapasitetOk(TestArrangementKorrekt.getDeltakerKapasitet()));
    }

    // Krav 3.1.2
    @Test
    public void erBeskrivelseGittTest(){
        assertEquals("Beskrivelse ikke gitt", FeilVerdierSykkelTest.erBeskrivelseGitt(FeilVerdierSykkelTest.getBeskrivelse()));
        assertEquals("", TestArrangementKorrekt.erBeskrivelseGitt(TestArrangementKorrekt.getBeskrivelse()));
    }

    // Krav 3.1.4 og 3.1.4.1
    @Test
    public void erPrisGittTest(){
        assertEquals("Arrangement er for dyrt", FeilVerdierSykkelTest.erPrisGitt(FeilVerdierSykkelTest.getPameldingsAvgift()));
        assertEquals("Pris kan ikke vaere negativ", TestArrangementFeilVerdier.erPrisGitt(TestArrangementFeilVerdier.getPameldingsAvgift()));
        assertEquals("", TestArrangementKorrekt.erPrisGitt(TestArrangementKorrekt.getPameldingsAvgift()));
    }

    // Krav 3.8.2
    @Test
    public void leggTilArrangementTest(){
        ArrayList<Arrangement> TestArrangementer = new ArrayList<>();
        TestArrangementer.add(TestArrangementKorrekt);
        Datahandler.leggTilArrangement(TestArrangementKorrekt);
        assertEquals(TestArrangementer, Datahandler.getArrangementer());
    }

    // Krav 3.2.1
    @Test
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

    // Krav 3.2.12
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
}
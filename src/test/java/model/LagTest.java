package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LagTest {


    Ski TestArrangementSki = new Ski("Birk", "", LocalDate.of(2018, 2, 3), LocalTime.of(20,30), LocalTime.of(10,30), 0, -200, "", new ArrayList<>());
    Lop TestArrangementLop = new Lop("Oslo Maraton", "Oslo, Rådhusplassen", LocalDate.of(2020, 9, 19), LocalTime.of(13,0), LocalTime.of(19,0), 900, 299, "Oslo Maraton er Norges største maraton og arrangeres hver høst i Oslos gater av Sportsklubben Vidar", new ArrayList<>());
    Lag TestLag = new Lag("Testlaget", new ArrayList<Person>(), new ArrayList<Arrangement>());
    Person TestJon = new Person("Jon","Jonsen");
    Person TestPer = new Person("Per", "Persson");
    Person TestErik = new Person("Erik","Ericcson");


    // Krav 3.2.9
    @Test
    public void meldPaaArrangementTest(){
        ArrayList<Arrangement> paameldteArrangement = new ArrayList<>();
        paameldteArrangement.add(TestArrangementLop);
        TestLag.meldPaaArrangement(TestArrangementLop);
        assertEquals(paameldteArrangement,TestLag.getArrangementerLagetErPaameldt());
    }

    // Krav 3.2.12
    @Test
    public void avmeldArrangementTest(){
        ArrayList<Arrangement> paameldteArrangement = new ArrayList<>();
        paameldteArrangement.add(TestArrangementSki);
        TestLag.meldPaaArrangement(TestArrangementLop);
        TestLag.meldPaaArrangement(TestArrangementSki);
        TestLag.avmeldArrangement(TestArrangementLop);
        assertEquals(paameldteArrangement,TestLag.getArrangementerLagetErPaameldt());
    }

    @Test
    public void paameldteArrangementerTest(){
        ArrayList<Arrangement> paameldteArrangementTest = new ArrayList<>();
        paameldteArrangementTest.add(TestArrangementSki);
        paameldteArrangementTest.add(TestArrangementLop);
        TestArrangementLop.leggTilDeltaker(TestJon);
        TestArrangementSki.leggTilDeltaker(TestJon);
        assertEquals(paameldteArrangementTest, TestLag.paameldteArrangementer(paameldteArrangementTest));
    }

    // Krav 3.6.9
    @Test
    public void erEttLagmedlemLagtTilTest(){
        TestLag.getMedlemmer().add(TestJon);
        assertEquals(TestLag.getMedlemmer(), TestLag.leggTilDummyMedlemmer(TestLag));
    }


    @Test
    public void erFlereLagmedlemLagtTilTest(){
        TestLag.getMedlemmer().add(TestJon);
        TestLag.getMedlemmer().add(TestPer);
        TestLag.getMedlemmer().add(TestErik);
        assertEquals(TestLag.getMedlemmer(), TestLag.leggTilDummyMedlemmer(TestLag));
    }
}

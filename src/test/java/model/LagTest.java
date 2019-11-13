package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LagTest {

    Lag TestLag = new Lag("Testlaget", new ArrayList<Person>());
    Person TestJon = new Person("Jon","Jonsen");
    Person TestPer = new Person("Per", "Persson");
    Person TestErik = new Person("Erik","Ericcson");


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

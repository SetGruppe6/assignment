package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LagTest {

    Lag TestLag = new Lag("Testlaget", new ArrayList<Person>());
    Person TestJon = new Person("Jon","Jonsen");


    @Test
    public void erLagmedlemmLagtTilTest(){
        TestLag.getMedlemmer().add(TestJon);
        assertEquals(TestLag.getMedlemmer(), TestLag.leggTilDummyMedlemmer(TestLag));
    }
}

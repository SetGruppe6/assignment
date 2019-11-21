package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BrukerTest {

    private Bruker testbruker = new Bruker("test", "nilsen", "test@nilsen.no",Boolean.FALSE, new ArrayList<>(), "testnilsen", "aB!3bc");

    //Krav 3.6.12
   @Test
    public void erBrukernavnGittTest(){
        assertEquals("Brukernavn mangler", testbruker.erBrukernavnGitt(""));
        assertEquals("", testbruker.erBrukernavnGitt(testbruker.getBrukernavn()));
    }

    //Krav 3.6.13
    @Test
    public void erPassordGittTest(){
        assertEquals("Passord mangler", testbruker.erPassordGitt(""));
        assertEquals("", testbruker.erPassordGitt(testbruker.getPassord()));
    }

    @Test
    public void hentBrukerNavnTest() {
        assertEquals("testnilsen", testbruker.getBrukernavn());
    }
}
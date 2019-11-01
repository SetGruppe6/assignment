package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrukerTest {

    @Test
    public void erBrukernavnGittTest(){
        assertEquals("Brukernavn mangler", Bruker.erBrukernavnGitt(""));
        assertEquals("", Bruker.erBrukernavnGitt("JesusLever"));
    }

    @Test
    public void erPassordGittTest(){
        assertEquals("Passord mangler", Bruker.erPassordGitt(""));
        assertEquals("", Bruker.erPassordGitt("abc123"));
    }
}
package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BetalingsTest {

    // Krav 3.2.10
    @Test
    public void harBetaltTest(){
        boolean betalt = false;
        Betaling betaling = new Betaling(betalt);
        betaling.harBetalt();
        assertTrue(betaling.isBetalt());
    }

    // Krav 3.2.10
    @Test
    public void harIkkeBetaltTest(){
        boolean betalt = false;
        Betaling betaling = new Betaling(betalt);
        assertFalse(betaling.isBetalt());
    }
}

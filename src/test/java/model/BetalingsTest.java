package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BetalingsTest {

    @Test
    public void harBetaltTest(){
        boolean betalt = false;
        Betaling betaling = new Betaling(betalt);
        betaling.harBetalt();
        assertTrue(betaling.isBetalt());
    }

    @Test
    public void harIkkeBetaltTest(){
        boolean betalt = false;
        Betaling betaling = new Betaling(betalt);
        assertFalse(betaling.isBetalt());
    }
}

package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrangementTest {
    @Test
    public void noe(){
        assertEquals("name Ok", Arrangement.isNameLongEnough("Vasaloppet"));
    }
}
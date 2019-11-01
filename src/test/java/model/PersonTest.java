package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void erNavnGittTest(){
        assertEquals("Fullt navn mangler", Person.erNavnGitt(""));
        assertEquals("", Person.erNavnGitt("JesusLever"));
    }

    @Test
    public void erPassordGittTest(){
        assertEquals("Passord mangler", Person.erPassordGitt(""));
        assertEquals("", Person.erPassordGitt("abc123"));
    }

    @Test
    public void erEmailGittTest(){
        assertEquals("E-post mangler", Person.erEmailGitt(""));
        assertEquals("", Person.erEmailGitt("JesusLever@yahoo.com"));
    }

    @Test
    public void erTlfGittTest(){
        assertEquals("Ugyldig telefonnummer", Person.erTlfGitt("12"));
        assertEquals("Ugyldig telefonnummer", Person.erTlfGitt("125643"));
        assertEquals("Ugyldig telefonnummer", Person.erTlfGitt("1256432423"));
        assertEquals("", Person.erTlfGitt("12345678"));

    }
}
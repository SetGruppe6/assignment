package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person TestJon = new Person("Jon","Jonsen", "JonJonsen@gmail.com");
    Person TestPer = new Person("", "","");


    @Test
    public void erFornavnGittTest(){
        assertEquals("", TestJon.erFornavnGitt(TestJon.getFornavn()));
        assertEquals("Fornavn mangler", TestPer.erFornavnGitt(TestPer.getFornavn()));
    }

    @Test
    public void erEtternavnGittTest(){
        assertEquals("Etternavn mangler", TestPer.erEtternavnGitt(TestPer.getEtternavn()));
        assertEquals("", TestJon.erEtternavnGitt(TestJon.getEtternavn()));
    }

    @Test
    public void erEmailGittTest(){
        assertEquals("E-post mangler", TestPer.erEmailGitt(TestPer.getEmail()));
        assertEquals("", TestJon.erEmailGitt(TestJon.getEmail()));
    }
}
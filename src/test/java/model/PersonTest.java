package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person TestJon = new Person("Jon","Jonsen", "JonJonsen@gmail.com");
    Person TestPer = new Person("", "","");
    private Lop test = new Lop("Holmenkollstafetten", "Underhaugsveien 1, 0354 Oslo", LocalDate.of(2020,5,5), LocalTime.of(10,0),LocalTime.of(18, 0), 2000, 250, "Holmenkollstafetten er et stafett arrangert av Idrettsklubben Tjalve, og blir omtalt som vaarens vakreste eventyr. Et av Norges storste friiddrettsarrangementer i antall paameldte.", new ArrayList<>());


    // Krav 3.4.1
    @Test
    public void erFornavnGittTest(){
        assertEquals("", TestJon.erFornavnGitt(TestJon.getFornavn()));
        assertEquals("Fornavn mangler", TestPer.erFornavnGitt(TestPer.getFornavn()));
    }

    // Krav 3.4.1
    @Test
    public void erEtternavnGittTest(){
        assertEquals("Etternavn mangler", TestPer.erEtternavnGitt(TestPer.getEtternavn()));
        assertEquals("", TestJon.erEtternavnGitt(TestJon.getEtternavn()));
    }

    // Krav 3.4.1
    @Test
    public void erEmailGittTest(){
        assertEquals("E-post mangler", TestPer.erEmailGitt(TestPer.getEmail()));
        assertEquals("", TestJon.erEmailGitt(TestJon.getEmail()));
    }

}
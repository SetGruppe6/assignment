package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BrukerTest {

    private Bruker testbruker = new Bruker("test", "nilsen", "test@nilsen.no",Boolean.FALSE, new ArrayList<>(), "testnilsen", "aB!3bc");

    
   @Test
    public void erBrukernavnGittTest(){
        assertEquals("Brukernavn mangler", testbruker.erBrukernavnGitt(""));
        assertEquals("", testbruker.erBrukernavnGitt(testbruker.getBrukernavn()));
    }


    @Test
    public void erPassordGittTest(){
        assertEquals("Passord mangler", testbruker.erPassordGitt(""));
        assertEquals("", testbruker.erPassordGitt(testbruker.getPassord()));
    }


    @Test
    public void hentBrukerNavnTest() {
        assertEquals("testnilsen", testbruker.getBrukernavn());
    }



    @Test
    public void oppretteNyBrukerOgMeldePaaArrangement() {
       Bruker jennyTest = new Bruker();
       ArrayList<Person> testPamelding = new ArrayList<>();
       ArrayList<Arrangement> testArrListe = new ArrayList<>();
       Lop haldenRundt = new Lop("Halden rundt", "Halden", LocalDate.of(2020, 5, 24), LocalTime.of(9,00), LocalTime.of(13,00), 200, 100, "Haldenlopet er paa festningen, hvor du kan lope fra fortiden og til idag", new ArrayList<>());
       boolean betalt = false;
       Betaling betaling = new Betaling(betalt);

       String fornavn = "Jenny";
       String etternavn = "Juice";
       ArrayList<Arrangement> JennyErPameldt = new ArrayList<>();
       String email = "jennytester@metoder.no";
       String brukernavn = "JenJu";
       String passord = "qwerty";

       StringBuilder tilbakemelding = new StringBuilder();
       tilbakemelding.append(jennyTest.erFornavnGitt(fornavn));
       tilbakemelding.append(jennyTest.erEtternavnGitt(etternavn));
       tilbakemelding.append(jennyTest.erBrukernavnGitt(brukernavn));
       tilbakemelding.append(jennyTest.erEmailGitt(email));
       tilbakemelding.append(jennyTest.erPassordGitt(passord));

       if(tilbakemelding.toString().isEmpty()){
           jennyTest.setFornavn(fornavn);
           jennyTest.setEtternavn(etternavn);
           jennyTest.setEmail(email);
           jennyTest.setBrukernavn(brukernavn);
           jennyTest.setPassord(passord);
           jennyTest.setArrangementerPersonErPameldt(JennyErPameldt);
       }

        testPamelding.add(jennyTest);
        haldenRundt.leggTilDeltaker(jennyTest);

        testArrListe.add(haldenRundt);
        jennyTest.meldPaaArrangement(haldenRundt);

        //Simulerer at vi betaler for arrangementet
        betaling.harBetalt();

        //Sjekker at boolean betalt vi satte tidligere nå er true
        assertTrue(betaling.isBetalt());

        //Sjekker at verdiene er det samme etter Bruker er opprettet
        assertEquals(fornavn, jennyTest.getFornavn());
        assertEquals(etternavn, jennyTest.getEtternavn());
        assertEquals(email, jennyTest.getEmail());
        assertEquals(brukernavn, jennyTest.getBrukernavn());
        assertEquals(passord,jennyTest.getPassord());
        assertEquals(JennyErPameldt, jennyTest.getArrangementerPersonErPameldt());

        //Ser om en testliste med jennyTest samsvarer med arrangementets liste over deltakere etter å ha
        //brukt metoden i Arrangementklassen
        assertEquals(testPamelding, haldenRundt.getDeltakere());

        //Sjekker at en persons ArrayListe for påmeldte arrangementer er inneholder det
        //riktige arrangementet
        assertEquals(testArrListe, JennyErPameldt);
    }
}
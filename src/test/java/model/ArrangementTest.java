package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrangementTest {
    @Test
    public void erTittelOkTest(){
        assertEquals("", Arrangement.erTittelOk("Vasaloppet"));
        assertEquals("Tittel for lang", Arrangement.erTittelOk("VasaloppetVasaloppetVasaloppetVasaloppetVasaloppetVasaloppetVasaloppet"));
        assertEquals("Tittel for kort", Arrangement.erTittelOk("Løp"));
    }

    @Test
    public void erLokasjonOkTest(){
        assertEquals("Lokasjon ikke gitt", Arrangement.erLokasjonGitt(""));
        assertEquals("", Arrangement.erLokasjonGitt("Oslo, Bislett Stadion"));
    }

    @Test
    public void erDatoOkTest(){
        assertEquals("Datofelt tomt", Arrangement.erDatoOK(""));
        assertEquals("", Arrangement.erDatoOK("00.00.0000"));
    }

    @Test
    public void erTidsromGittTest(){
        assertEquals("Angi start og sluttid", Arrangement.erTidsromGitt("", ""));
        assertEquals("Angi sluttid", Arrangement.erTidsromGitt("00:00",""));
        assertEquals("Angi starttid", Arrangement.erTidsromGitt("","00:00"));
        assertEquals("", Arrangement.erTidsromGitt("00:00","00:00"));
    }

    @Test
    public void erDeltakerKapasitetOkTest(){
        assertEquals("Kapasitet under 0 eller over 1000", Arrangement.erDeltakerKapasitetOk(1001));
        assertEquals("", Arrangement.erDeltakerKapasitetOk(666));

    }
/*
    @Test
    public void erPameldingBetaltTest(){
        assertTrue();

    }*/


}
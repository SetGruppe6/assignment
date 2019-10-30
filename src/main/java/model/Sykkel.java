package model;

public class Sykkel extends Arrangement {
    public Sykkel(String navn, String beskrivelse, String lokasjon, String dato, String startTid, String sluttTid, int deltakerKapasitet, int påmeldingsAvgift) {
        super(navn, beskrivelse, lokasjon, dato, startTid, sluttTid, deltakerKapasitet, påmeldingsAvgift);
    }
}

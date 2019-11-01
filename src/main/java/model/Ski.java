package model;

import java.util.ArrayList;

public class Ski extends Arrangement {
    public Ski (String navn, String beskrivelse, String lokasjon, String dato, String startTid, String sluttTid, int deltakerKapasitet, ArrayList<Person> deltakere, int påmeldingsAvgift) {
        super(navn, beskrivelse, lokasjon, dato, startTid, sluttTid, deltakerKapasitet, deltakere, påmeldingsAvgift);
    }
}

package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ski extends Arrangement {
  private static Distanse[] skiAvstander = new Distanse[4];

    public Ski(String navn, String lokasjon, LocalDate dato, String startTid, String sluttTid, int deltakerKapasitet, int pameldingsAvgift, String beskrivelse, ArrayList<Person> deltakere) {
        super(navn, lokasjon, dato, startTid, sluttTid, deltakerKapasitet, pameldingsAvgift, beskrivelse, deltakere);
    }

    public Ski(String navn, String lokasjon, LocalDate dato, String startTid, String sluttTid, int deltakerKapasitet, int pameldingsAvgift, String beskrivelse, ArrayList<Person> deltakere, Distanse distanse) {
        super(navn, lokasjon, dato, startTid, sluttTid, deltakerKapasitet, pameldingsAvgift, beskrivelse, deltakere, distanse);
    }

    public static Distanse[] getSkiAvstander() {
        return skiAvstander;
    }

    public static void setSkiAvstander(Distanse[] skiAvstander) {
        Ski.skiAvstander = skiAvstander;
    }

    public static void fyllDistanseListe() {
        String[] kategori = {"Sprint", "Langdistanse", "Klassisk", "Fristil"};
        Distanse[] liste = new Distanse[4];
        int k = 0;

        while(k < 4) {
            liste[k] = new Distanse(kategori[k]);
            k++;
        }

        setSkiAvstander(liste);
    }
}

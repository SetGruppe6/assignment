package model;

import java.util.ArrayList;

public class Ski extends Arrangement {
  private static Distanse[] skiAvstander = new Distanse[4];

    public Ski (String navn, String beskrivelse, String lokasjon, String dato, String startTid, String sluttTid, int deltakerKapasitet, ArrayList<Person> deltakere, int påmeldingsAvgift) {
        super(navn, beskrivelse, lokasjon, dato, startTid, sluttTid, deltakerKapasitet, deltakere, påmeldingsAvgift);

    }

    public static Distanse[] getSkiAvstander() {
        return skiAvstander;
    }

    public static void setSkiAvstander(Distanse[] skiAvstander) {
        Ski.skiAvstander = skiAvstander;
    }

    public static void fyllDistanseListe() {
        String[] kategori = {"Spring", "Langdistanse", "Klassisk", "Fristil"};
        Distanse[] liste = new Distanse[4];
        int k = 0;

        while(k < 4) {
            liste[k] = new Distanse(kategori[k]);
            k++;
        }

        setSkiAvstander(liste);
    }
}

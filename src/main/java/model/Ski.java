package model;

import java.util.ArrayList;

public class Ski extends Arrangement {
  private static Distanse[] skiAvstander = new Distanse[4];

    public Ski(String navn, String lokasjon, String dato, String startTid, String sluttTid, int deltakerKapasitet, int pameldingsAvgift, String beskrivelse, ArrayList<Person> deltakere) {
        super(navn, lokasjon, dato, startTid, sluttTid, deltakerKapasitet, pameldingsAvgift, beskrivelse, deltakere);
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

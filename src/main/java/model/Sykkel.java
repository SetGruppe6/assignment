package model;

import java.util.ArrayList;

public class Sykkel extends Arrangement {
  
private static Distanse[] sykkelAvstander = new Distanse[3];

    public Sykkel(String navn, String lokasjon, String dato, String startTid, String sluttTid, int deltakerKapasitet, int pameldingsAvgift, String beskrivelse, ArrayList<Person> deltakere) {
        super(navn, lokasjon, dato, startTid, sluttTid, deltakerKapasitet, pameldingsAvgift, beskrivelse, deltakere);
    }

    public Sykkel(String navn, String lokasjon, String dato, String startTid, String sluttTid, int deltakerKapasitet, int pameldingsAvgift, String beskrivelse, ArrayList<Person> deltakere, Distanse distanse) {
        super(navn, lokasjon, dato, startTid, sluttTid, deltakerKapasitet, pameldingsAvgift, beskrivelse, deltakere, distanse);
    }

    public static Distanse[] getSykkelAvstander() {
        return sykkelAvstander;
    }

    public static void setSykkelAvstander(Distanse[] sykkelAvstander) {
        Sykkel.sykkelAvstander = sykkelAvstander;
    }

    public static void fyllDistanseListe() {
        String[] kategori = {"Landeveissykling", "Banesykling", "Terreng"};
        Distanse[] liste = new Distanse[3];
        int k = 0;

        while(k < 3) {
            liste[k] = new Distanse(kategori[k]);
            k++;
        }

        setSykkelAvstander(liste);
    }
}

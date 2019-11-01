package model;

public class Sykkel extends Arrangement {

    private static Distanse[] sykkelAvstander = new Distanse[3];

    public Sykkel(String navn, String beskrivelse, String lokasjon, String dato, String startTid, String sluttTid, int deltakerKapasitet, int påmeldingsAvgift) {
        super(navn, beskrivelse, lokasjon, dato, startTid, sluttTid, deltakerKapasitet, påmeldingsAvgift);
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

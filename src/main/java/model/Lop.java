package model;

public class Lop extends Arrangement {

    private static Distanse[] lopsAvstander = new Distanse[5];

    public Lop(String navn, String beskrivelse, String lokasjon, String dato, String startTid, String sluttTid, int deltakerKapasitet, int påmeldingsAvgift) {
        super(navn, beskrivelse, lokasjon, dato, startTid, sluttTid, deltakerKapasitet, påmeldingsAvgift);
    }

    public static Distanse[] getLopsAvstander() {
        return lopsAvstander;
    }

    public static void setLopsAvstander(Distanse[] lopsAvstander) {
        Lop.lopsAvstander = lopsAvstander;
    }

    public static void fyllDistanseListe() {
        String[] kategori = {"Sprint", "Mellomdistanse", "Langdistanse", "Terreng", "Landevei"};
        Distanse[] liste = new Distanse[5];
        int k = 0;

        while(k < 5) {
            liste[k] = new Distanse(kategori[k]);
            k++;
        }

        setLopsAvstander(liste);
    }


}

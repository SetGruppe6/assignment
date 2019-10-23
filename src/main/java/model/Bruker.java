package model;

import java.util.ArrayList;

public class Bruker {

    private String brukernavn;
    private String passord;
    private ArrayList<Bruker> brukerListe;
    private static int antallBrukere = 0;

    public Bruker (String brukernavn, String passord){
        this.brukernavn = brukernavn;
        this.passord = passord;
    }


    public void leggTilBruker(Bruker enBruker){
        brukerListe.add(enBruker);
    }




    //////////////////////////////CONSTRUCTOR/////////////////////////////////////////////////////////

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getPassord() {
        return passord;
    }

    public ArrayList<Bruker> getBrukerListe() {
        return brukerListe;
    }

    public void setBrukerListe(ArrayList<Bruker> brukerListe) {
        this.brukerListe = brukerListe;
    }

    public static int getAntallBrukere() {
        return antallBrukere;
    }

    public static void setAntallBrukere(int antallBrukere) {
        Bruker.antallBrukere = antallBrukere;
    }

    //////////////////////////////CONSTRUCTOR/////////////////////////////////////////////////////////
}

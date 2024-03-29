package model;

import java.util.ArrayList;

public class Bruker extends Person {

    private String brukernavn;
    private String passord;

    public Bruker(String fornavn, String etternavn, String email, Boolean harLagTilknytning, ArrayList<Arrangement> arrangementerPersonErPameldt, String brukernavn, String passord) {
        super(fornavn, etternavn, email, harLagTilknytning, arrangementerPersonErPameldt);
        this.brukernavn = brukernavn;
        this.passord = passord;
    }

    public Bruker() {
        super();
    }

    public String erBrukernavnGitt(String brukernavn){

        if (brukernavn.isEmpty()) {
            return "Brukernavn mangler";
        }
        return "";
    }

    public String erPassordGitt(String passord){

        if (passord.isEmpty()) {
            return "Passord mangler";
        }
        return "";
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public String getPassord() { return passord; }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }
}

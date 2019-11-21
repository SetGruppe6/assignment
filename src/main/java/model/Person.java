package model;

import java.util.ArrayList;

public class Person {

    private String fornavn;
    private String etternavn;
    private String email;
    private Boolean harLagTilknytning;
    private ArrayList<Arrangement> arrangementerPersonErPameldt;


    public Person(String fornavn, String etternavn, String email) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.email = email;
    }

    public Person(String fornavn, String etternavn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public Person(String fornavn, String etternavn, String email, Boolean harLagTilknytning, ArrayList<Arrangement> arrangementerPersonErPameldt) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.email = email;
        this.harLagTilknytning = harLagTilknytning;
        this.arrangementerPersonErPameldt = arrangementerPersonErPameldt;
    }

    public Person(String fornavn, String etternavn, Boolean harLagTilknytning) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.harLagTilknytning = harLagTilknytning;
    }

    public Person(String fornavn, String etternavn, String email, ArrayList<Arrangement> arrangementerPersonErPameldt) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.email = email;
        this.arrangementerPersonErPameldt = arrangementerPersonErPameldt;
    }

    public Person() {

    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getHarLagTilknytning() {
        return harLagTilknytning;
    }

    public ArrayList<Arrangement> getArrangementerPersonErPameldt() {
        return arrangementerPersonErPameldt;
    }

    public void meldPaaArrangement(Arrangement arrangement) {
        arrangementerPersonErPameldt.add(arrangement);
    }

    public void setArrangementerPersonErPameldt(ArrayList<Arrangement> arrangementerPersonErPameldt) {
        this.arrangementerPersonErPameldt = arrangementerPersonErPameldt;
    }

    public void meldAvArrangement(Arrangement arrangement) {
        arrangementerPersonErPameldt.remove(arrangement);
    }

    public String erFornavnGitt(String fornavn) {

        if (fornavn.isEmpty()) {
            return "Fornavn mangler";
        }
        return "";
    }

    public String erEtternavnGitt(String etternavn) {

        if (etternavn.isEmpty()) {
            return "Etternavn mangler";
        }
        return "";
    }


    public String erEmailGitt(String email) {

        if (email.isEmpty()) {
            return "E-post mangler";
        }
        return "";
    }

  
      @Override
    public String toString() {
        return fornavn + " " + etternavn;
    }
}



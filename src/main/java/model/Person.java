package model;

import java.util.ArrayList;

public class Person {

    private String fornavn;
    private String etternavn;
    private String email;
    private String passord;
    private String tlf;
    private ArrayList<Arrangement> arrangementerPersonErPameldt = new ArrayList<>();

    public Person(String fornavn, String etternavn, String email, String passord, String mobilnr) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.email = email;
        this.passord = passord;
        this.tlf = mobilnr;
    }

    public Person(String fornavn, String etternavn, String email) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.email = email;
    }

    public Person(String fornavn, String etternavn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public Person(String fornavn, String etternavn, String email, ArrayList<Arrangement> arrangementerPersonErPameldt) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.email = email;
        this.arrangementerPersonErPameldt = arrangementerPersonErPameldt;
    }

    public ArrayList<Arrangement> paameldteArrangementerPerson(ArrayList<Arrangement> arrangementer, Person person) {
        ArrayList<Arrangement> paameldteArrangement = new ArrayList<>();

        for(Arrangement arr: arrangementer) {
            if(arr.getDeltakere().contains(person)) {
                paameldteArrangement.add(arr);
            }
        }

        return paameldteArrangement;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }


    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public ArrayList<Arrangement> getArrangementerPersonErPameldt() {
        return arrangementerPersonErPameldt;
    }

    public void setArrangementerPersonErPameldt(Arrangement arrangement) {
        arrangementerPersonErPameldt.add(arrangement);
    }

    public static String erNavnGitt(String navn) {

        if (navn.isEmpty()) {
            return "Fullt navn mangler";
        }
        return "";
    }

    public static String erPassordGitt (String passord) {

        if (passord.isEmpty()) {
            return "Passord mangler";
        }
        return "";
    }

    public static String erEmailGitt(String email) {

        if (email.isEmpty()) {
            return "E-post mangler";
        }
        return "";
    }

    public static String erTlfGitt(String tlf) {

        if (tlf.length() != 8){
            return "Ugyldig telefonnummer";
        }
        return "";
    }
  
      @Override
    public String toString() {
        return fornavn + " " + etternavn;
    }
}



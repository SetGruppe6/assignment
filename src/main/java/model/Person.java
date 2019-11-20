package model;

import java.util.ArrayList;

public class Person {

    private String fornavn;
    private String etternavn;
    private String email;
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

    public String getEtternavn() {
        return etternavn;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Arrangement> getArrangementerPersonErPameldt() {
        return arrangementerPersonErPameldt;
    }

    public void setArrangementerPersonErPameldt(Arrangement arrangement) {
        arrangementerPersonErPameldt.add(arrangement);
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



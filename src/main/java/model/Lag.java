package model;

import java.util.ArrayList;

public class Lag {
    private String navn;
    private ArrayList<Person> lagspillere = new ArrayList<>();

    public Lag(String navn, ArrayList<Person> lagspillere) {
        this.navn = navn;
        this.lagspillere = lagspillere;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public ArrayList<Person> getLagspillere() {
        return lagspillere;
    }

    public void setLagspillere(ArrayList<Person> lagspillere) {
        this.lagspillere = lagspillere;
    }
}

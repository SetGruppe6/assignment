package model;

import java.util.ArrayList;

public class Lag {
    private String navn;
    private ArrayList<Person> medlemmer = new ArrayList<>();

    public Lag(String navn, ArrayList<Person> medlemmer) {
        this.navn = navn;
        this.medlemmer = medlemmer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public ArrayList<Person> getMedlemmer() {
        return medlemmer;
    }

    public void setMedlemmer(ArrayList<Person> medlemmer) {
        this.medlemmer = medlemmer;
    }


    public ArrayList<Person> leggTilDummyMedlemmer(ArrayList<Person> medl){
        if(medl.size() == 0) {
            medl.add(new Person("Petter", "Northug"));
            medl.add(new Person("Daria", "Northug Jr"));
            medl.add(new Person("Jens", "Juul"));
            medl.add(new Person("Sander", "Fleece"));
            medl.add(new Person("Joakim", "Manedskog"));
            medl.add(new Person("Jarle", "MacMonday"));
            medl.add(new Person("Polly", "Esther"));
            medl.add(new Person("Donald", "Stump"));
            medl.add(new Person("Anne", "Blaa"));
            medl.add(new Person("Therese", "Dohaug"));
            medl.add(new Person("Silje", "Stikksag"));
            medl.add(new Person("Hans", "son-Mbop"));
            medl.add(new Person("Harald", "Haarfagre"));
            medl.add(new Person("Putin", "OnAShow"));
            medl.add(new Person("Henny", "Koppen"));
            medl.add(new Person("Siri", "Senkesett"));
            medl.add(new Person("Svein", "Charter"));
        }

        return medl;
    }

}
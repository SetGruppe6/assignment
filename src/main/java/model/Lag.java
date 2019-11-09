package model;

import java.util.ArrayList;

public class Lag {
    private String navn;
    private ArrayList<Person> medlemmer;
    private ArrayList<Arrangement> arrangementerLagetErPaameldt;

    public Lag(String navn, ArrayList<Person> medlemmer) {
        this.navn = navn;
        this.medlemmer = medlemmer;
    }

    public Lag(String navn, ArrayList<Person> medlemmer, ArrayList<Arrangement> arrangementerLagetErPaameldt) {
        this.navn = navn;
        this.medlemmer = medlemmer;
        this.arrangementerLagetErPaameldt = arrangementerLagetErPaameldt;
    }

    public void meldPaaArrangement(Arrangement arrangement) {
        arrangementerLagetErPaameldt.add(arrangement);
    }

    public void avmeldArrangement(Arrangement arrangement) {
        arrangementerLagetErPaameldt.remove(arrangement);
    }


    public ArrayList<Person> leggTilDummyMedlemmer(Lag laget){
        if(laget.getMedlemmer().size() == 0) {
            laget.getMedlemmer().add(new Person("Petter", "Northug"));
            laget.getMedlemmer().add(new Person("Daria", "Northug Jr"));
            laget.getMedlemmer().add(new Person("Jens", "Juul"));
            laget.getMedlemmer().add(new Person("Sander", "Fleece"));
            laget.getMedlemmer().add(new Person("Joakim", "Manedskog"));
            laget.getMedlemmer().add(new Person("Jarle", "MacMonday"));
            laget.getMedlemmer().add(new Person("Polly", "Esther"));
            laget.getMedlemmer().add(new Person("Donald", "Stump"));
            laget.getMedlemmer().add(new Person("Anne", "Blaa"));
            laget.getMedlemmer().add(new Person("Therese", "Dohaug"));
            laget.getMedlemmer().add(new Person("Silje", "Stikksag"));
            laget.getMedlemmer().add(new Person("Hans", "son-Mbop"));
            laget.getMedlemmer().add(new Person("Harald", "Haarfagre"));
            laget.getMedlemmer().add(new Person("Putin", "OnAShow"));
            laget.getMedlemmer().add(new Person("Henny", "Koppen"));
            laget.getMedlemmer().add(new Person("Siri", "Senkesett"));
            laget.getMedlemmer().add(new Person("Svein", "Charter"));
        }

        return laget.getMedlemmer();
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

}
package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Lag {
    private String navn;
    private ArrayList<Person> medlemmer;
    private ArrayList<Arrangement> arrangementerLagetErPaameldt;


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

    public ArrayList<Arrangement> paameldteArrangementer(ArrayList<Arrangement> arrangementer) {
        ArrayList<Arrangement> paameldteArrangement = new ArrayList<>();

        for(Arrangement arr: arrangementer) {
            if(!arr.getDeltakere().isEmpty()) {
                paameldteArrangement.add(arr);
            }
        }

        return paameldteArrangement;
    }

    public ArrayList<Person> leggTilDummyMedlemmer(Lag laget){
        if(laget.getMedlemmer().size() == 0) {
            ArrayList<Person> medl = new ArrayList<>(Arrays.asList(
             new Person("Petter", "Northug", Boolean.TRUE),
             new Person("Daria", "Northug Jr", Boolean.TRUE),
             new Person("Jens", "Juul", Boolean.TRUE),
             new Person("Sander", "Fleece", Boolean.TRUE),
             new Person("Joakim", "Manedskog", Boolean.TRUE),
             new Person("Jarle", "MacMonday", Boolean.TRUE),
             new Person("Polly", "Esther", Boolean.TRUE),
             new Person("Donald", "Stump", Boolean.TRUE),
             new Person("Anne", "Blaa", Boolean.TRUE),
             new Person("Therese", "Dohaug", Boolean.TRUE),
             new Person("Silje", "Stikksag", Boolean.TRUE),
             new Person("Hans", "son-Mbop", Boolean.TRUE),
             new Person("Harald", "Haarfagre", Boolean.TRUE),
             new Person("Putin", "OnAShow", Boolean.TRUE),
             new Person("Henny", "Koppen", Boolean.TRUE),
             new Person("Siri", "Senkesett", Boolean.TRUE),
             new Person("Svein", "Charter", Boolean.TRUE)));

            laget.setMedlemmer(medl);
        }

        return laget.getMedlemmer();
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Person> getMedlemmer() {
        return medlemmer;
    }

    public void setMedlemmer(ArrayList<Person> medlemmer) {
        this.medlemmer = medlemmer;
    }

    public ArrayList<Arrangement> getArrangementerLagetErPaameldt() {
        return arrangementerLagetErPaameldt;
    }
}
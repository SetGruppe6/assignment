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
             new Person("Petter", "Northug"),
             new Person("Daria", "Northug Jr"),
             new Person("Jens", "Juul"),
             new Person("Sander", "Fleece"),
             new Person("Joakim", "Manedskog"),
             new Person("Jarle", "MacMonday"),
             new Person("Polly", "Esther"),
             new Person("Donald", "Stump"),
             new Person("Anne", "Blaa"),
             new Person("Therese", "Dohaug"),
             new Person("Silje", "Stikksag"),
             new Person("Hans", "son-Mbop"),
             new Person("Harald", "Haarfagre"),
             new Person("Putin", "OnAShow"),
             new Person("Henny", "Koppen"),
             new Person("Siri", "Senkesett"),
             new Person("Svein", "Charter")));

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
package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Arrangement {

    private String navn;
    private String lokasjon;
    private LocalDate dato;
    private LocalTime startTid;
    private LocalTime sluttTid;
    private int deltakerKapasitet;
    private int pameldingsAvgift;
    private String beskrivelse;
    private ArrayList<Person> deltakere = new ArrayList<>();
    private Distanse distanse;
    private static ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public ArrayList<Person> getDeltakere() {
        return deltakere;
    }

    public Arrangement(){}


    public Arrangement(String navn, String lokasjon, LocalDate dato, LocalTime startTid, LocalTime sluttTid, int deltakerKapasitet, int pameldingsAvgift, String beskrivelse, ArrayList<Person> deltakere) {

        this.navn = navn;
        this.lokasjon = lokasjon;
        this.dato = dato;
        this.startTid = startTid;
        this.sluttTid = sluttTid;
        this.deltakerKapasitet = deltakerKapasitet;
        this.pameldingsAvgift = pameldingsAvgift;
        this.beskrivelse = beskrivelse;
        this.deltakere = deltakere;
    }

    public Arrangement(String navn, String lokasjon, LocalDate dato, LocalTime startTid, LocalTime sluttTid, int deltakerKapasitet, int pameldingsAvgift, String beskrivelse, ArrayList<Person> deltakere, Distanse distanse) {
        this.navn = navn;
        this.lokasjon = lokasjon;
        this.dato = dato;
        this.startTid = startTid;
        this.sluttTid = sluttTid;
        this.deltakerKapasitet = deltakerKapasitet;
        this.pameldingsAvgift = pameldingsAvgift;
        this.beskrivelse = beskrivelse;
        this.deltakere = deltakere;
        this.distanse = distanse;
    }

    public Arrangement(String navn){
        this.navn = navn;
    }

    //GETTER OG SETTER

    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getLokasjon() {
        return lokasjon;
    }
    public void setLokasjon(String lokasjon) {
        this.lokasjon = lokasjon;
    }

    public LocalDate getDato() {
        return dato;
    }
    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }
    public void setStartTid(LocalTime startTid) {
        this.startTid = startTid;
    }

    public LocalTime getSluttTid() {
        return sluttTid;
    }
    public void setSluttTid(LocalTime sluttTid) {
        this.sluttTid = sluttTid;
    }

    public int getDeltakerKapasitet() {
        return deltakerKapasitet;
    }
    public void setDeltakerKapasitet(int deltakerKapasitet) {
        this.deltakerKapasitet = deltakerKapasitet;
    }

    public int getPameldingsAvgift() {
        return pameldingsAvgift;
    }
    public void setPameldingsAvgift(int pameldingsAvgift) {
        this.pameldingsAvgift = pameldingsAvgift;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public void setDeltakere(ArrayList<Person> deltakere) {
        this.deltakere = deltakere;
    }

    public Distanse getDistanse() {
        return distanse;
    }

    public void setDistanse(Distanse distanse) {
        this.distanse = distanse;
    }

    public static ArrayList<Arrangement> getArrangementer() {
        return arrangementer;
    }

    public static void setArrangementer(ArrayList<Arrangement> arrangementer) {
        Arrangement.arrangementer = arrangementer;
    }


    //METODER


    public String erTittelOk (String tittel){

         if (tittel.length() >= 65){
            return "Tittel for lang";
        } else if (tittel.length() <= 5){
            return "Tittel for kort";
        }
        return "";
    }

    public String erLokasjonGitt(String lokasjon){

        if (lokasjon.isEmpty()){
            return "Fyll inn lokasjon";
        }
        return "";
    }

    public String erDatoOK (LocalDate dato){
        LocalDate iDag = LocalDate.now();

        //Sjekker om dato til opprettet arrangement er før datoen om 14 dager.
        if (dato.isBefore(iDag.plusDays(14))){
            return "Arrangementets dato må tidligst være om 14 dager";
        }
        else if(dato.isBefore(iDag)) {
            return "Arrangementets dato kan ikke være i fortiden";
        }
        return "";
    }

    public String erStartTidspunktOk(LocalTime start, LocalTime slutt){
        LocalTime now = LocalTime.now();
        String formatet = "hh:mm";

        if(start.isBefore(slutt)) {
            return "Starttidspunkt kan ikke være før slutttidspunkt";
        }
        else if(!start.toString().equals(formatet)) {
            return "Vennligts fyll inn klokkeslett på formatet hh:mm";
        }

        return "";
    }

    public String erDeltakerKapasitetOk (int kapasitet){

        if(kapasitet == 0) {
            return "Deltakerkapasitet må være større 0";
        }
        else if (kapasitet < 1 || kapasitet > 1000){
            return "Kapasitet under 0 eller over 1000";
        }
        return "";
    }
    

    public String erPrisGitt(int betaling){

        if(betaling == 0){
            return "Arrangement er gratis";
        }
        else if(betaling > 600){
            return "Arrangement er for dyrt";
        }
        else if(betaling < 0){
            return "Pris kan ikke være negativ";
        }
        return "";
    }

    public static void meldDegPaa(Arrangement typeArrangement, Person person){
        typeArrangement.getDeltakere().add(person);
    }


    public static void leggTilArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }

    public void leggTilDeltaker(Person person) {
        deltakere.add(person);
    }


    @Override
    public String toString() {
        return navn ;
    }
}


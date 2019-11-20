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

    public void avmeldPerson(Person person){
        deltakere.remove(person);
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

    public ArrayList<Person> getDeltakere() {
        return deltakere;
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


    //METODER


    public String erTittelOk (String tittel){

         if (tittel.length() >= 30){
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


        if(dato.isBefore(iDag)) {
            return "Arrangementets dato kan ikke vaere i fortiden";
        }
        //Sjekker om dato til opprettet arrangement er før datoen om 30 dager.
        else if (dato.isBefore(iDag.plusDays(30))){
            return "Arrangementets dato maa tidligst vaere om 30 dager";
        }
        return "";
    }

    public String erStartTidspunktOk(LocalTime start, LocalTime slutt){

        if(start.isAfter(slutt)) {
            return "Starttidspunkt kan ikke vaere for sluttidspunkt";
        }
        else if(start.equals(slutt)) {
            return "Start- og sluttidspunkt maa vaere ulik";
        }

        return "";
    }

    public String erDeltakerKapasitetOk (int kapasitet){

        if(kapasitet == 0) {
            return "Deltakerkapasitet maa vaere storre enn 0";
        }
        else if (kapasitet < 1 || kapasitet > 500){
            return "Kapasitet under 0 eller over 500";
        }
        return "";
    }
    

    public String erPrisGitt(int betaling){

        if(betaling > 600){
            return "Arrangement er for dyrt";
        }
        else if(betaling < 0){
            return "Pris kan ikke vaere negativ";
        }
        return "";
    }

    public String erBeskrivelseGitt (String beskrivelse) {
        if (beskrivelse.isEmpty()){
            return "Beskrivelse ikke gitt";
        }
        return "";
    }


    public void leggTilDeltakere(ArrayList<Person> deltakerene) {
        deltakere = deltakerene;
    }

    public void leggTilDeltaker(Person person) {
        if(!deltakere.contains(person)) {
            deltakere.add(person);
        }
    }

    public void fjernDeltaker(Person person) {
        deltakere.remove(person);
    }

    // FILTRERINGSLOGIKK


    @Override
    public String toString() {
        return navn ;
    }
}


package model;

public abstract class Arrangement {

    private String navn;
    private String lokasjon;
    private String dato;
    private String startTid;
    private String sluttTid;
    private int deltakerKapasitet;
    private int påmeldingsAvgift;
    private String beskrivelse;


    public Arrangement(){}

    public Arrangement(String navn, String beskrivelse, String lokasjon, String dato, String startTid, String sluttTid, int deltakerKapasitet, int pameldingsavgift) {
        this.navn = navn;
        this.lokasjon = lokasjon;
        this.dato = dato;
        this.startTid = startTid;
        this.sluttTid = sluttTid;
        this.deltakerKapasitet = deltakerKapasitet;
        this.påmeldingsAvgift = pameldingsavgift;
        this.beskrivelse = beskrivelse;
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

    public String getDato() {
        return dato;
    }
    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getStartTid() {
        return startTid;
    }
    public void setStartTid(String startTid) {
        this.startTid = startTid;
    }

    public String getSluttTid() {
        return sluttTid;
    }
    public void setSluttTid(String sluttTid) {
        this.sluttTid = sluttTid;
    }

    public int getDeltakerKapasitet() {
        return deltakerKapasitet;
    }
    public void setDeltakerKapasitet(int deltakerKapasitet) {
        this.deltakerKapasitet = deltakerKapasitet;
    }

    public int getPåmeldingsAvgift() {
        return påmeldingsAvgift;
    }
    public void setPåmeldingsAvgift(int påmeldingsAvgift) {
        this.påmeldingsAvgift = påmeldingsAvgift;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    //METODER


    public static String erTittelOk (String tittel){

         if (tittel.length() >= 65){
            return "Tittel for lang";
        } else if (tittel.length() <= 5){
            return "Tittel for kort";
        }
        return "";
    }

    public static String erLokasjonGitt(String lokasjon){

        if (lokasjon.isEmpty()){
            return "Lokasjon ikke gitt";
        }
        return "";
    }

    public static String erDatoOK (String dato){

        if (dato.isEmpty()){
            return "Datofelt tomt";
        }
        return "";
    }

    public static String erTidsromGitt (String start, String slutt){

        if (start.isEmpty() && slutt.isEmpty()){
            return "Angi start og sluttid";
        }
        if (start.isEmpty() && !slutt.isEmpty()){
            return "Angi starttid";
        }
        if (!start.isEmpty() && slutt.isEmpty()){
            return "Angi sluttid";
        }
        return "";
    }

    public static String erDeltakerKapasitetOk (int kapasitet){

        if (kapasitet < 1 || kapasitet > 1000){
            return "Kapasitet under 0 eller over 1000";
        }
        return "";
    }

    public static String erBeskrivelseGitt (String beskrivelse){

        if (beskrivelse.isEmpty())
    }


    @Override
    public String toString() {
        return navn;
    }
}


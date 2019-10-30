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

    public Arrangement(String navn, String beskrivelse, String lokasjon, String dato, String startTid, String sluttTid, int deltakerKapasitet, int påmeldingsAvgift) {
        this.navn = navn;
        this.lokasjon = lokasjon;
        this.dato = dato;
        this.startTid = startTid;
        this.sluttTid = sluttTid;
        this.deltakerKapasitet = deltakerKapasitet;
        this.påmeldingsAvgift = påmeldingsAvgift;
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


    public static String isNameLongEnough (String name){

        if (name.length() >= 5 && name.length() < 65){
            return "name Ok";
        } else if (name.length() >= 65){
            return "name too long";
        } else {
            return "name too short";
        }
    }

    /**public static void scanInfo(){
        String navn;
        String sted;
        String tid;



        Scanner sjekk = new Scanner(System.in);
        System.out.println("Skriv navn på arrangement:");
        navn = sjekk.nextLine();
        System.out.println("Skriv inn sted:");

        sted =   sjekk.nextLine();

        System.out.println("Når går arrangementet?");
        tid = sjekk.nextLine();

        //Arrangement hei = new Arrangement (navn, sted, tid);

        ArrayList<Arrangement> liste = new ArrayList<>();

        liste.add(new Arrangement(navn, sted, tid));

        //System.out.println(liste);

    }**/




    @Override
    public String toString() {
        return navn;
    }
}


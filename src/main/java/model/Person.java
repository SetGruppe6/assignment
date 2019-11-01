package model;

public class Person {

    private String fornavn;
    private String etternavn;
    private String email;
    private String passord;
    private String tlf;

    public Person(String fornavn, String etternavn, String email, String passord, String mobilnr) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.email = email;
        this.passord = passord;
        this.tlf = mobilnr;
    }

    public Person(String fornavn, String etternavn, String email) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.email = email;
    }

    public Person(String fornavn, String etternavn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }


    public static String erNavnGitt(String navn) {

        if (navn.isEmpty()) {
            return "Fullt navn mangler";
        }
        return "";
    }

    public static String erPassordGitt (String passord) {

        if (passord.isEmpty()) {
            return "Passord mangler";
        }
        return "";
    }

    public static String erEmailGitt(String email) {

        if (email.isEmpty()) {
            return "E-post mangler";
        }
        return "";
    }

    public static String erTlfGitt(String tlf) {

        if (tlf.length() != 8){
            return "Ugyldig telefonnummer";
        }
        return "";
    }
}
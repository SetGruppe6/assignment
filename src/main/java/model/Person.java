package model;

public class Person {

    private String fornavn;
    private String etternavn;
    private String email;
    private int mobilnr;

    public Person(String fornavn, String etternavn, String email, int mobilnr) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.email = email;
        this.mobilnr = mobilnr;
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

    public int getMobilnr() {
        return mobilnr;
    }

    public void setMobilnr(int mobilnr) {
        this.mobilnr = mobilnr;
    }
}

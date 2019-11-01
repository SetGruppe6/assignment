package model;

public class Bruker {

    private String brukernavn;
    private String passord;

    public Bruker (String brukernavn, String passord){
        this.brukernavn = brukernavn;
        this.passord = passord;
    }



    public static String erBrukernavnGitt(String brukernavn){

        if (brukernavn.isEmpty()) {
            return "Brukernavn mangler";
        }
        return "";
    }

    public static String erPassordGitt(String passord){

        if (passord.isEmpty()) {
            return "Passord mangler";
        }
        return "";
    }




    //////////////////////////////GETTERANDSETTER/////////////////////////////////////////////////////////

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getPassord() {
        return passord;
    }

    //////////////////////////////GETTERANDSETTER/////////////////////////////////////////////////////////


}

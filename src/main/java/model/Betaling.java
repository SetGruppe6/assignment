package model;

public class Betaling {

    private boolean betalt = false;

    public Betaling(boolean betalt) {
        this.betalt = betalt;
    }

    public void harBetalt(){
        betalt = true;
    }

    public boolean isBetalt() {
        return betalt;
    }
}

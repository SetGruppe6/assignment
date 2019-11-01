package model;

public class Distanse {

    private String kategori;
    private int lengde;

    public Distanse(String kategori) {
        this.kategori = kategori;
    }

    public Distanse(String kategori, int lengde) {
        this.kategori = kategori;
        this.lengde = lengde;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getLengde() {
        return lengde;
    }

    public void setLengde(int lengde) {
        this.lengde = lengde;
    }

    @Override
    public String toString() {
        return kategori;
    }
}



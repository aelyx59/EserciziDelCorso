package it.unibs.fdp.archivioCD;

public class Brano {

    private int minuti;
    private int secondi;
    private String titolo;

    public Brano(int minuti, int secondi, String titolo) {
        this.minuti = minuti;
        this.secondi = secondi;
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "Brano: " + titolo + ", durata: " + minuti + ":" + secondi;
    }
}

package it.unibs.fdp.aziendaSanitaria;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Medico {

    private String nome;
    private String cognome;
    private String codice;
    private Giorni g;
    private ArrayList<Paziente> pazienti;

    public Medico(String nome, String cognome, String codice) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice = codice;
        this.g = Giorni.getRestDay();
        this.pazienti = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodice() {
        return codice;
    }

    public Giorni getG() {
        return g;
    }

    public ArrayList<Paziente> getPazienti() {
        return pazienti;
    }

    public static boolean checkCode(String codice) {

        if(codice.length() != 4) {
            System.out.println("Codice medico non valido");
            return false;
        }

        if(codice.charAt(0) != 'm') {
            System.out.println("Codice medico non valido");
            return false;
        }

        int i = 1;

        do {
            if(codice.charAt(i) < '0' || codice.charAt(i) > '9') {
                return false;
            }

            i++;

        } while(i < 4);

        return true;
    }

    @Override
    public String toString() {
        return "Medico: nome: " + nome + ", cognome: " + cognome + ", codice: " + codice + ", giorno di riposo: " + g;

    }

    public boolean isResting(Giorni giorno) {

        if(giorno == g)
            return true;

        return false;
    }

    public void addPaziente(Paziente p) {

        pazienti.add(p);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Medico medico = (Medico) o;

        if(this.getCodice().equals(medico.getCodice()))
            return true;

        return false;
    }

    public void printPazienti() {

        for(Paziente p: pazienti)
            System.out.println(p);
    }

}
